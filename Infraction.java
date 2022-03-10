//import java.text.SimpleDateFormat;
import java.util.Date; 

public class Infraction {
    public float amount;
    public String description;
    public Date dateIssued ; 
    public boolean outstanding=false;
    public Driver driver =new Driver();


    public Infraction(float amount, String description, Date dateIssued){
        this.amount= amount;
        this.description= description;
        this.dateIssued= dateIssued;
    }

    public Infraction(){
        this(100,"NA", new Date());
    }

    public String getAmount(){
        return String.format("%.2f", this.amount);
    }
    public String getDescription(){
        return this.description;
    }
    public Date getDate(){
        return this.dateIssued;
    }
    public String getOutstanding(){
        if(this.outstanding==true){
            return "[PAID IN FULL]";
        }else{
            return "[OUTSTANDING]";
        }
    }

    public void pay(){
        this.outstanding=true;
    }
    public String toString(){
        return "$"+getAmount()+" Infraction on "+ getDate()+" "+getOutstanding();
    }
}

