package gbr1806645p2_easyrent;
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class GBR1806645P2_EasyRent {

    public static void main(String[] args) throws Exception {

        //creat scanner to read from file
        File inputCar = new File("inputCar.txt");
        Scanner read = new Scanner(inputCar);
        //cheak the file 
        if (!inputCar.exists()) {
            System.out.println("the file doesn't exist");
        }
        //creat file and writer
        File carsifo = new File("Carsinfo.txt");
        PrintWriter write = new PrintWriter(carsifo);
        //creat array of opject
        int size1 = read.nextInt();
        Car[] cars = new Car[size1];
        Service[] services = new Service[read.nextInt()];
        int count = 0;
        int count1 = 0;

        while (read.hasNext()) {
            String add;
            add = read.next();
               //filling the array of cars and services
                    if (add.equals("AddCar")) {
                        String brand = read.next();
                        int year = read.nextInt();
                        double rate = read.nextDouble();
                        boolean Transmission = read.nextBoolean();
                        String type = read.next();
                        boolean convertible = read.nextBoolean();
                        cars[count] = new Car(brand, year,rate,  Transmission, type,convertible);
                        
                        count++;}

                     if (add.equals("AddService")) {
                        String type1 = read.next();
                        double price1 = read.nextDouble();
                        services[count1]=new Service(type1,price1);
                        count1++;  }
                     }
        
        //write into file carsinfo
        write.println("--------------- Welcome to Car Renting  Data Base ---------------\n\n");
        for (int i = 0; i < cars.length; i++) {
          write.println(cars[i]);  
          write.println("------------------------------------------------------");
          write.println();
        }
        //close file
        write.close();
        //check the file 
        File reservationInput = new File("Reservationinput.txt");
        Scanner read1 = new Scanner(reservationInput);
        if (!reservationInput.exists()) {
            System.out.println("the file doesn't exist");
        }
        //create file and writer
        File  reservationStatus= new File("ReservationStatus.txt");
        PrintWriter write1 = new PrintWriter(reservationStatus);
        //create array of object
        Reservation[] reservations = new Reservation[read1.nextInt()];
        
        int count2 = 0;
        String convert ="";
        String carType = "";
        boolean transmission=false;
        boolean convertible = false;
        String transmit="";
        String convertible1="";
        //create service object and car object for each customer
        Service [] service= new Service[3];
        Car [] car=new Car[3];
        //read from file reservation
        
        while(read1.hasNext()){
        String reserve =read1.next(); 
        
            if(reserve.equals("Reserve")){
                        carType = read1.next();
                         transmit = read1.next();
                        if(transmit.equals("Manual"))
                            transmission=true;
                        else transmission=false;
                         convert = read1.next();
                        convertible = false;
                        if(convert.equals("Convertible"))
                            convertible=true;
                        else convertible=false;
                        String pickup = read1.next();
                        String dropof = read1.next();
                        int year = read1.nextInt();
                        int month = read1.nextInt();
                        int day = read1.nextInt();
                        int year1 = read1.nextInt();
                        int month1 = read1.nextInt();
                        int day1 = read1.nextInt();
                        Date Dpickup = new Date();
                        Dpickup.setDate(day);
                        Dpickup.setMonth(month);
                        Dpickup.setYear(year);
                        Date Ddrobof = new Date();
                        Ddrobof.setDate(day1);
                        Ddrobof.setMonth(month1);
                        Ddrobof.setYear(year1);
                        String firstname = read1.next();
                        String lastname = read1.next();
                        String email = read1.next();
                        long card = read1.nextLong();
                        int code = read1.nextInt();
                         service[count2]=new Service(read1.next());
                        if(service.equals("submit")){
                        	service[count2]=null;
                        }
                        
                      Customer customer=  new Customer(firstname, lastname, email, card, code);
                      car [count2]= new Car( carType,transmission, convertible);
                      
                //boolean isThere=true;
                      
                if (chechTheCar(cars,car[count2])){
                    reservations[count2] = new Reservation(pickup, dropof, Dpickup, Ddrobof, customer ,  car[count2]);
                }else  reservations[count2]=null;
                       
               count2++;        
            }
            
              }
        
        //write into file
        write1.println("--------------- Welcome to Car Renting  Management System ---------------\r\n");
        write1.println("--------------- Display All System Procedures ---------------\r\n");
        
        // to fill service price
        for(int i=0; i<services.length; i++){
        	for(int j=0; j<service.length; j++){
        	if(services[i].gettype().equals(service[j].gettype())){
        		service[j].setprice(services[i].getprice());
        	}
        	}
        	}
      //to write reservtionstatus
        for(int i=0; i<reservations.length; i++)
        {
        	if(reservations[i]!=null) {
                     String trans="";
                        if(reservations[i].GetCar().getTransmission()){
                           trans = "Manual" ;
                        }else trans="Automatic";
                        String convert1 = "";
                        if(reservations[i].GetCar().isConvertible()){
                           convert1 = " and Convertible"; 
                        }else convert1="";
                        write1.println("DONE: The reservation is completed");
        		write1.println("******Reservation Refrence number : "+reservationReference(reservations[i],  cars ,i));
        		write1.println(reservations[i]);
                        write1.println("******Car information : The car Type: "+car[i].getBrand()+" "+reservations[i].GetCar().getCarType()+", Year: "+car[i].getYearOfConstruction()+", Transmission: "+ trans+convert1);
                        write1.println("******Additional services : Service "+service[i].gettype() );
                        write1.println("--------------- Invoice Details ---------------");
                      //calculate number of rental days
                     long difference = reservations[i].GetDrobof().getTime()-reservations[i].GetPickup().getTime();
     	             float numerofrentaldays = (difference / (1000*60*60*24));
                     write1.printf("Number of reserved days: %.0f\r\n", numerofrentaldays);
                     //write intial price
                     double intialTotal=car[i].CalculateFinalPrice()*numerofrentaldays;
                
                     write1.println("Intial Total: " + intialTotal);
                     write1.println("--------------- Additional Services Price ---------------");
                     intialTotal= intialTotal + (service[i].getprice());
                     write1.println("Total After additional Services : " +  intialTotal );
                     write1.println("--------------- Final Payment after Discount ---------------");
                
                    //final price after discount
     	            int discode=reservations[i].GetCustomer().getClientCode();
               
     	       //check discount criteria
               double finalpriceafterdis=calculate(discode, intialTotal );
                write1.println("Final Total : " +  finalpriceafterdis );
                write1.println("\r\n\r\n");

        	}else {write1.println("SORRY: The reservation is NOT completed \n" +
                                      "There is no available Car\r\n\r\n");
            

        	}
        }
        write1.close();
       
    }

    
    public static boolean chechTheCar(Car cars[], Car car ){
           boolean isAvalible = false;
           for (int j = 0; j < cars.length; j++) {
                 if(car.getCarType().equals(cars[j].getCarType())&&car.getTransmission()==cars[j].getTransmission()&&car.isConvertible()==cars[j].isConvertible()){
                     car.setBrand(cars[j].getBrand());
                     car.setYearOfConstruction(cars[j].getYearOfConstruction());
                     car.setCarrate(cars[j].getCarrate());
                     isAvalible=true;
                     break;   
                 }}
                     
        return isAvalible;
        
    }
    
    
    public static String reservationReference(Reservation reserveCar, Car[] cars , int count){
     String character = reserveCar.GetCustomer().getFirstName().substring(0,1);
     String character1 = reserveCar.GetCustomer().getLastName().substring(0,1);
     
     int random = (int)(Math.random()*1000);
     
     int year = cars[count].getYearOfConstruction();
        
     return character.toUpperCase()+character1.toUpperCase()+"_"+random+"_"+year;
        
    }
    
    
    public static double calculate(int discode, double intialTotal ){
    
    
    double finalpriceafterdis=0.0; 
    if(String.valueOf(discode).startsWith("9") || String.valueOf(discode).startsWith("8")|| String.valueOf(discode).startsWith("7")){
     	    	   finalpriceafterdis= Math.round(intialTotal- intialTotal *(20.0f/100.0f));
     	    	  return finalpriceafterdis; 
     	       }else if (String.valueOf(discode).startsWith("5") || String.valueOf(discode).startsWith("6")|| String.valueOf(discode).startsWith("4")){
     	    	   finalpriceafterdis= Math.round(intialTotal- intialTotal*(15.0f/100.0f));
     	    	   return finalpriceafterdis; 
     	       }else if (String.valueOf(discode).startsWith("3") || String.valueOf(discode).startsWith("2")|| String.valueOf(discode).startsWith("1")|| String.valueOf(discode).startsWith("0")){
     	    	   finalpriceafterdis= Math.round(intialTotal- intialTotal*(10.0f/100.0f));  
     	         return finalpriceafterdis; 
               }else 
                   return finalpriceafterdis; 
    
    }
    
    
    
}

