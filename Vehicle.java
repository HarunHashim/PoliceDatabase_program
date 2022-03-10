public class Vehicle {

    public String make;
    public String model;
    public int year;
    public String color;
    public String plate;
    public Driver owner;
    public Boolean reportedStolen=false;


    public  Vehicle (){
        this("","",0,"","");
        }

    public Vehicle (String make ,String model,int year,String color,String plate){
        this.make=make;
        this.model=model;
        this.year=year;
        this.color=color;
        this.plate=plate;
    }
    public String getMake(){
        return this.make;
    }
    public String getModel(){
        return this.model;
    }
    public int getYear(){
        return this.year;
    }
    public String getColor(){
        return this.color;
    }
    
    public String getPlate(){
        return this.plate;
    }
    public Driver getOwner(){
        return this.owner;
    }
    public boolean getReportedStolen(){
        return this.reportedStolen;
    }

    public void setReportedStolen(Boolean reported){
        this.reportedStolen=reported;
    }

    public void setOwner(Driver owner){
        this.owner=owner;
    }

    public String toString(){
        return "A "+getColor()+" "+ Integer.toString(getYear())+" "+getMake()+" "+getModel()+" with plate"+" "+getPlate();
    }

	
    
}
