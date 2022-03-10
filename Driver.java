public class Driver {
    public String license;
    public String name;
    public String street;
    public String city;
    public String province;

    public Driver (){
        this(" "," ", " ", " "," ");
        }

    public Driver( String license, String name, String street, String city, String province ){
        this.license=license;
        this.name=name;
        this.street=street;
        this.city=city;
        this.province=province;   
    }

    public String getLicense(){
        return this.license;
    }
    public String getName(){
        return this.name;
    }
    public String getStreet(){
        return this.street;
    }   
    public String getCity(){
        return this.city;
    }
    public String getProvince(){
        return this.province;
    }

    public void  setLicense(String license){
        this.license=license;
    }

    @Override
    public String toString(){
        return "" + getLicense() +" "+ getName() +" living at "+ getStreet() +","+ getCity() +","+ getProvince();
      }
}
