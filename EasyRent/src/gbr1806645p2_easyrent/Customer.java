package gbr1806645p2_easyrent;




public class Customer {
  
  private  String First_name;
  private  String Last_name;
  private String email;
  private long Cridit_Card;
  private int discount_code;

    public Customer(String firstname, String lastname, String email, long card, int code) {
        First_name = firstname;
        Last_name = lastname;
        this.email = email;
        Cridit_Card = card;
        discount_code = code;
    }

    public String getFirstName() {
        return First_name;
    }

    public void setFirstName(String firstname) {
        First_name = firstname;
    }

    public String getLastName() {
        return Last_name;
    }

    public void setLastName(String lastname) {
        Last_name = lastname;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public long getCriditCard() {
        return Cridit_Card;
    }

    public void setCriditCard(long card) {
        Cridit_Card = card;
    }

    public int getClientCode() {
        return discount_code;
    }

    @Override
    public String toString() {
        return "Customer{" + "First_name=" + First_name + ", Last_name=" + Last_name + ", email=" + email + ", Cridit_Card=" + Cridit_Card + ", discount_code=" + discount_code + '}';
    }
  
  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
