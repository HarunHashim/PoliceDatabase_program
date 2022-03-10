
import java.util.Arrays;
import java.util.Date;


public class PoliceDatabase {
        public static int n=1;
        Vehicle[] vehicles = new Vehicle[vehicle_limit];
        public static int numVehicles = 0;
        Driver[] drivers = new Driver[drivers_limit];
        public static int numDrivers = 0;
        Infraction[] infractions = new Infraction[infraction_limit];
        public static int numInfractions = 0;
        private static final int drivers_limit = 2000;
        private static final int vehicle_limit = 1000;
        private static final int infraction_limit = 800;
        public int outs=0;


        public PoliceDatabase() {
                PoliceDb(new Vehicle(), new Driver(), new Infraction());
        }

        public void PoliceDb(Vehicle vehicle, Driver driver, Infraction infraction) {
                this.drivers[numDrivers] = driver;
                this.vehicles[numVehicles] = vehicle;
                this.infractions[numInfractions] = infraction;
        }

        public void registerDriver(Driver aDriver) {
                drivers[numDrivers] = aDriver;
                numDrivers = numDrivers + 1;
        }

        public void registerVehicle(Vehicle aVehicle, String license) {
                vehicles[numVehicles] = aVehicle;
                for(int i=0;i<drivers.length ;i++){
                        if(drivers[i]!=null){
                                if(drivers[i].license==license){
                                   vehicles[numVehicles].owner = drivers[i];     
                                }

                        }
                }
                
                //vehicles[numVehicles].owner.license = license;

                // this.drivers[numDrivers-1]=new Driver();
                // this.drivers[numDrivers-1].setLicense(license);
                //numDrivers += 1;
                numVehicles += 1;
        }

    public void unregisterVehicle(String plate){
        //!!! Couldnt find a way of getting rid of the FUNFUN vehicle without getting nulls which would 
        //cause errors on the program, if you dont mind could you please comment tips on my remarks thanks

        Vehicle [] copy= new Vehicle [vehicles.length-1];
        
        
        for(int i=0,j=0;i<vehicles.length;i++){
                if (vehicles[i]==null){
                        
                }else{
                        
                      if(vehicles[i].plate!=plate){
                        if(vehicles[i]!=null){      
                        //System.out.println(true);
                        copy[j]=vehicles[i];
                        j=j+1;   
                        
                        //numVehicles=numVehicles-1;    
                        }
                }       
                }
                
                }   
        for(int k=0;k<copy.length;k++){
                if(copy[k]!=null){
                vehicles[k]=copy[k];
                }
        }
        
        
        
    }
    

    public void reportStolen(String plate){
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i]!=null){    
                if ( vehicles[i].getPlate()== plate){
                        vehicles[i].setReportedStolen(true);
                }
            }
        }
    }

    public void changeOwner( String plate, String license){  

        for (int i = 0; i < vehicles.length; i++) {
                if(vehicles[i]!=null){
                    if ( vehicles[i].plate== plate){
                        for(int j = 0; j < drivers.length; j++){
                          if(drivers[j]!=null){       
                                if( drivers[j].license == license){
                                    vehicles[i].owner=drivers[j];    
                                    
                                        
                                }
                        }
                }}
            }
        }
        }
    
        
//==============================================================================================================================================
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//==============================================================================================================================================


    public Infraction  issueInfraction(String license, float amount, String description, Date date){
        Infraction infraction= new Infraction(amount,description, date);
        //sets the driver object for the infraction created
        for(int i=0;i<drivers.length;i++){
                if(drivers[i]!=null){
                        if(drivers[i].license==license){ 
                                infraction.driver=drivers[i];
                        }       
                }
                }
          
        int items=0;

        for(int m=0; m<infractions.length ;m++){
                if (infractions[m]!=null){
                    items+=1;          
                }    
        }

        //copy array which will store the new infraction
        Infraction [] copy= new Infraction [items+1]; 
        for(int m=0; m<infractions.length ;m++){
                if (infractions[m]!=null){       
                    copy[m]= infractions[m];    
                }        
        }
        copy[items]=infraction;

        //copy2 array which will be created with the same length as infractions array but it will have the elements of copy
        Infraction [] copy2= new Infraction [infractions.length];   
        
        for(int m=0; m<copy.length ;m++){       
                copy2[m]= copy[m];    
                
        }
        infractions=copy2;
        
        /*
        for(int i=0;i<drivers.length;i++){
                if(drivers[i]!=null){
                        if(drivers[i].license==license){ 
                                infractions[i]=infraction;
                                infractions[i].driver=drivers[i];
                        }       
                }
                }
        //System.out.println(infraction);
        */
        return infraction;
    }


    public boolean hasOutstandingInfractions(Driver d) {
        boolean a=false;    
        for(int i=0;i<infractions.length;i++){
           if(infractions[i]!=null){
                   if(infractions[i].driver==d){
                           return true;
                   }
           }     
        }
        return a;   
    }
    
    public boolean shouldStopVehicle(String plate){
       boolean b= false;
       for(int i=0;i<vehicles.length;i++){
        if(vehicles[i]!=null){
                if(vehicles[i].plate==plate){
                        if(vehicles[i].reportedStolen==true){
                                return true;
                        }else if( hasOutstandingInfractions(vehicles[i].owner) == true){
                                return true;
                        }
                }
        }
        }
        return b;    
    }
    
    public void showInfractionsFor(String license){
            
        for(int i=0;i<infractions.length;i++){
                if(infractions[i]!=null){
                        if(infractions[i].driver.license==license){
                                System.out.println(infractions[i].toString());
                                if(infractions[i].outstanding==false){
                                        outs=outs+1;

                                }
                        }
        
                        
            }
        }
        System.out.println("Total outstanding infractions = "+ Integer.toString(outs));
                     
    }

    public Driver[] cleanDrivers(){
        
        int clean=0;
        boolean a=false;
        for(int i=0;i<drivers.length;i++){
                if(drivers[i]!=null){
                for(int j=0;j<infractions.length;j++){
                        if(infractions[j]!=null){
                           if(drivers[i]==infractions[j].driver){  
                                a=true;
                           }                              
                        }
                }
                if(a==false){
                        clean=clean+1;
                        }
                a=false;       
                
                }
        }
        Driver clean_driver[]= new Driver[clean];
        int q=0;
        for(int p=0;p<drivers.length;p++){
                if(drivers[p]!=null){
                for(int j=0;j<infractions.length;j++){
                        if(infractions[j]!=null){
                           if(drivers[p]==infractions[j].driver){
                                a=true;
                           }                              
                        }
                }
                if(a==false){
                        clean_driver[q]=drivers[p];
                        q=q+1;
                        }
                a=false;       
                
                }
        }
        
        
        return clean_driver ;

    }

    public String [] showInfractionReport(){
        int no_drivers=0;
        int y=0;   
        
        /*
        for (int test=0; test<infractions.length;test++){
                if(infractions[test]!=null){
                    System.out.println(infractions[test]);    
                }  
        }*/
        

        for(int i=0;i<drivers.length; i++){
                if(drivers[i]!=null){
                        for(int j=0;j<infractions.length;j++){
                                if(infractions[j]!=null){
                                   if(drivers[i]==infractions[j].driver){
                                        no_drivers=no_drivers+1;
                                        break;
                                   }
                                }
                        }
                }        
        }
        //System.out.println(no_drivers);

        Driver [] infraction_drivers= new Driver[no_drivers];
        boolean q=false;
        for(int p=0;p<drivers.length;p++){
                if(drivers[p]!=null){
                        for(int j=0;j<infractions.length;j++){
                                if(infractions[j]!=null){
                                   if(drivers[p]==infractions[j].driver){
                                        infraction_drivers[y]= drivers[p];
                                        q=true;   
                                   }
                                }
                        }if(q==true){
                                y=y+1;
                                q=false;
                        }
                }        
        }
        
        int [] no_inf= new int[no_drivers];
        int n_infractions=0;
        for(int g=0; g<infraction_drivers.length; g++){
                for(int j=0;j<infractions.length;j++){
                        if(infractions[j]!=null){
                                //System.out.println(infractions[j].driver);
                                if(infraction_drivers[g].license==infractions[j].driver.license){
                                        //System.out.println(infraction_drivers[g].license);
                                        //System.out.println( no_inf[g]);
                                        n_infractions+=1;
                                        //System.out.println(n_infractions);       
                                        no_inf[g]=n_infractions;
                                }
                                         
                        }
                      
                
                }
                n_infractions=0;
                //System.out.println("Done with  one driver");
                 
        }
        
        float [] amounts= new float[no_drivers];
        float i_amount_paid=0;
        for(int g=0; g<infraction_drivers.length; g++){
                
                for(int j=0;j<infractions.length;j++){
                        if(infractions[j]!=null){
                                if(infraction_drivers[g]==infractions[j].driver){
                                        if(infractions[j].outstanding){
                                                i_amount_paid=i_amount_paid+infractions[j].amount;
                                                amounts[g]=i_amount_paid;     
                                        }
                                        
                                }
                        }
                }
                i_amount_paid=0;
                 
        }

        String [] inf_driver = new String[no_drivers];
        //System.out.println(no_drivers);
        for(int og=0; og<inf_driver.length; og++){
                //System.out.println(infraction_drivers[og]);
                if(infraction_drivers[og]!=null){
                        //System.out.println("Passed by though");
                        System.out.println(String.format("%20s",infraction_drivers[og].name) +" "+ Integer.toString(no_inf[og]) + " infractions, total paid = $"+ String.format("%6s",(String.format("%.2f", (amounts[og])))));
                        
                        inf_driver[og]=String.format("%20s",infraction_drivers[og].name) +" "+ Integer.toString(no_inf[og]) + " infractions, total paid = $"+ String.format("%6s",(String.format("%.2f", (amounts[og])))); 
        
                }
         }

        return inf_driver;

    }


    public static  PoliceDatabase example() { // Register all drivers and their vehicles
        PoliceDatabase pdb = new PoliceDatabase();
    
        pdb.registerDriver(new Driver("L1567-34323-84980", "Matt Adore",
                "1323 Kenaston St.", "Gloucester", "ON"));
        pdb.registerDriver(new Driver("L0453-65433-87655", "Bob B. Pins",
                "32 Rideau Rd.", "Greely", "ON"));
        pdb.registerDriver(new Driver("L2333-45645-54354", "Stan Dupp",
                "1355 Louis Lane", "Gloucester", "ON"));
        pdb.registerDriver(new Driver("L1234-35489-99837", "Ben Dover",
                "2348 Walkley Rd.", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L8192-87498-27387", "Patty O'Lantern",
                "2338 Carling Ave.", "Nepean", "ON"));
        pdb.registerDriver(new Driver("L2325-45789-35647", "Ilene Dover",
                "287 Bank St.", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L1213-92475-03984", "Patty O'Furniture",
                "200 St. Laurant Blvd.", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L1948-87265-34782", "Jen Tull",
                "1654 Stonehenge Cres.", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L0678-67825-83940", "Jim Class",
                "98 Oak Blvd.", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L0122-43643-73286", "Mark Mywords",
                "3 Third St.", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L6987-34532-43334", "Bob Upandown",
                "434 Gatineau Way", "Hull", "QC"));
        pdb.registerDriver(new Driver("L3345-32390-23789", "Carrie Meehome",
                "123 Thurston Drive", "Kanata", "ON"));
        pdb.registerDriver(new Driver("L3545-45396-88983", "Sam Pull",
                "22 Colonel By Drive", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L1144-26783-58390", "Neil Down",
                "17 Murray St.", "Nepean", "ON"));
        pdb.registerDriver(new Driver("L5487-16576-38426", "Pete Reedish",
                "3445 Bronson Ave.", "Ottawa", "ON"));
        pdb.registerVehicle(new Vehicle("Honda", "Civic", 2015, "yellow", "W3EW4T"),
                "L0453-65433-87655");
        pdb.registerVehicle(new Vehicle("Pontiac","Grand Prix",2007,"dark green","GO SENS"),
                "L0453-65433-87655");
        pdb.registerVehicle(new Vehicle("Mazda", "RX-8", 2004, "white", "OH YEAH"),
                "L2333-45645-54354");
        pdb.registerVehicle(new Vehicle("Nissan","Altima",2017,"bergundy", "Y6P9O7"),
                "L1234-35489-99837");
        pdb.registerVehicle(new Vehicle("Saturn", "Vue", 2002, "white", "9R6P2P"),
                "L2325-45789-35647");
        pdb.registerVehicle(new Vehicle("Honda", "Accord", 2018, "gray", "7U3H5E"),
                "L2325-45789-35647");
        pdb.registerVehicle(new Vehicle("Chrysler", "PT-Cruiser", 2006, "gold", "OLDIE"),
                "L2325-45789-35647");
        pdb.registerVehicle(new Vehicle("Nissan", "Cube", 2010, "white", "5Y6K8V"),
                "L1948-87265-34782");
        pdb.registerVehicle(new Vehicle("Porsche", "959", 1989, "silver", "CATCHME"),
                "L0678-67825-83940");
        pdb.registerVehicle(new Vehicle("Kia", "Soul", 2018, "red", "J8JG2Z"),
                "L0122-43643-73286");
        pdb.registerVehicle(new Vehicle("Porsche", "Cayenne", 2014, "black", "EXPNSV"),
                "L6987-34532-43334");
        pdb.registerVehicle(new Vehicle("Nissan", "Murano", 2010, "silver", "Q2WF6H"),
                "L3345-32390-23789");
        pdb.registerVehicle(new Vehicle("Honda", "Element", 2008, "black", "N7MB5C"),
                "L3545-45396-88983");
        pdb.registerVehicle(new Vehicle("Toyota", "RAV-4", 2010, "green", "R3W5Y7"),
                "L3545-45396-88983");
        pdb.registerVehicle(new Vehicle("Toyota", "Celica", 2006, "red", "FUNFUN"),
                "L5487-16576-38426");
    
        return pdb;
    }
}

