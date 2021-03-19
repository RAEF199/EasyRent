package gbr1806645p2_easyrent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



public class Service {
    private String servicetype;
    private double serviceprice;
    
    public Service(String type){
    	this.servicetype=type;
    }

    public Service(String type, double price) {
        servicetype = type;
        serviceprice = price;
    }

    public String gettype() {
        return servicetype;
    }

    public void settype(String type) {
       servicetype = type;
    }

    public double getprice() {
        return serviceprice;
    }

    public void setprice(double price) {
        serviceprice = price;
    }

    @Override
    public String toString() {
        return "servicetype: " + servicetype + ", serviceprice: " + serviceprice ;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
