

package gbr1806645p2_easyrent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Date;

public class Reservation {
   
    private String Reservation_code;
    private String pick_up_location;
    private String drop_of_location;
    private Date Pick_up;
    private Date Drob_of;
    private Date Date_of_reservation;
    private Customer customer;
    private Car car;
    private Service additional_services;
    
    public Reservation(){
    	
    }
   

    public Reservation(String pickup, String dropof, Date Dpickup, Date Ddrobof, Customer customer, Car car) {
        pick_up_location = pickup;
        drop_of_location = dropof;
        Pick_up = Dpickup;
        Drob_of = Ddrobof;
        this.customer = customer;
        this.car = car;
    }

    
    
    
    
    
    public String GetReservationCode() {
        return Reservation_code;
    }

    public void SetReservationCode(String code) {
        Reservation_code = code;
    }

    public String GetPickUpLocation() {
        return pick_up_location;
    }

    public void setPickUpLocation(String pickup) {
        pick_up_location = pickup;
    }

    public String GetDropOfLocation() {
        return drop_of_location;
    }

    public void SetDropOfLocation(String dropof) {
        drop_of_location = dropof;
    }

    public Date GetPickup() {
        return Pick_up;
    }

    public void SetPickup(Date pickup) {
        Pick_up = pickup;
    }

    public Date GetDrobof() {
        return Drob_of;
    }

    public void SetDrobof(Date drobof) {
        Drob_of = drobof;
    }

    public Service getservices() {
        return additional_services;
    }

    public void addservices(Service currentservices) {
        additional_services = currentservices;
    }

    public Date getdateofReservation() {
        return Date_of_reservation;
    }

    public Customer GetCustomer() {
        return customer;
    }

    public Car GetCar() {
        return car;
    }

    public void SetCar(Car another) {
        car = another;
    }

    @Override
    public String toString() { 
        String transmit="";
        if (GetCar().getTransmission()==false){
         transmit = "Automatic";    
        }else transmit = "Manual";
        
        return "******Customer information : Customer Name: "+GetCustomer().getFirstName()+" "+GetCustomer().getLastName()+", Email: "+GetCustomer().getemail()+" Code: "+GetCustomer().getClientCode()+
   "\n******Pick up location : "+GetPickUpLocation()+" ******Drop of location : "+GetDropOfLocation()+
    "\n******Pick up date : "+Pick_up.getDate()+"-"+Pick_up.getMonth()+"-"+Pick_up.getYear()+" ******Drop of date : "+Drob_of.getDate()+"-"+Drob_of.getMonth()+"-"+Drob_of.getYear();        
                
                
                }
    
    
    
    
   
                           
                             
                            
    
    
    
    
    
    
    
    
    
    
    
    
    
}
