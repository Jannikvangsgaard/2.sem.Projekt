package domain;

/**
 *
 * @author Jannik
 */
public class Customer {
   private int customerID;
   private String name;
   private String address;
   private String postnr;
   private String by;
   private String email;
   private String nr;
   
    public Customer(int customerID, String name){
        this.customerID = customerID;
        this.name = name;
    }
    public Customer(String name, String address, String postnr, String by, String email, String nr){
        this.name = name;
        this.address = address;
        this.postnr = postnr;
        this.by = by;
        this.email = email;
        this.nr = nr;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

    public String getPostnr() {
        return postnr;
    }

    public void setPostnr(String postnr) {
        this.postnr = postnr;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }
    
    
    public String toString()
    {
        return "Kunde nummer: " + customerID + ", Navn: " + name;
    }
    
    public String toStringDetails()
    {
        return "Kunde nummer: " + customerID + "\n"
                + "Navn: " + name + "\n"
                + "Email: " + email + "\n"
                + "Tlf: " + nr + "\n"
                + "Adresse: " + address + "\n"
                + "By: " + postnr + ", " + by + "\n";

    }

    
}
