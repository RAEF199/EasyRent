package gbr1806645p2_easyrent;


public class Car {

private String Brand;
private String CarType;
private int Year_of_construction;
private double Car_rate;
private boolean Transmission_Manual;
private boolean Convertible;

public Car(){
	
}

    public Car(String CarType, boolean Transmission_Manual, boolean Convertible) {
        this.CarType = CarType;
        this.Transmission_Manual = Transmission_Manual;
        this.Convertible = Convertible;
    }



    public Car(String brand, int year, double rate, boolean Transmission, String type, boolean convertible) {
        Brand = brand;
        CarType = type;
        Year_of_construction = year;
        Car_rate = rate;
        Transmission_Manual = Transmission;
        Convertible = convertible;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getCarType() {
        return CarType;
    }

    public void setCarType(String type) {
        this.CarType = type;
    }

    public int getYearOfConstruction() {
        return Year_of_construction;
    }

    public void setYearOfConstruction(int year) {
        Year_of_construction = year;
    }

    public double getCarrate() {
        return Car_rate;
    }

    public void setCarrate(double rate) {
        Car_rate = rate;
    }

    public boolean getTransmission() {
        return Transmission_Manual;
    }

    public void setTransmission(boolean Transmission) {
        Transmission_Manual = Transmission;
    }

    public boolean isConvertible() {
        return Convertible;
    }

    public void setConvertible(boolean convertible) {
        Convertible = convertible;
    }
    
    public  double CalculateFinalPrice(){
        double intialTotalPrice=this.Car_rate;
        if(this.getCarType().equalsIgnoreCase("Luxury")){
        	intialTotalPrice= (intialTotalPrice*0.1)+ intialTotalPrice;        	
        }
        return intialTotalPrice;
    }

    @Override
    public String toString() {
        String transmission="";
        if(Transmission_Manual){
         transmission =  "Manual";
        }
        else transmission = "Automatic";
        String convertible="";
        if(Convertible){
          convertible=" and Convertible"; 
        }
        else convertible="";
        
        return "The car Type: "+Brand+" "+ CarType+ ", Year: "+Year_of_construction+", Transmission: "+transmission +convertible;
    }








 
 
 
 
 
}