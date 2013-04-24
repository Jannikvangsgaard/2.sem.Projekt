/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Mike
 */
public class Employee {
    
  private int employeeID;
   private String name;
   private String position;
   private String phoneNumber;
   private String email;
   private String zipCode;
   private String city;
   private String adress;
   private Date dato;
   private ArrayList dates = new ArrayList();
   
    public Employee(int employeeID, Date dato){
        this.employeeID = employeeID;
        this.dato = dato;
    }
    
    public Employee(String name, String position, String phoneNumber, String email, String zipCode,String city, String adress){
        this.name = name;
        this.position = position;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.zipCode= zipCode;
        this.city = city;
        this.adress=adress;
    }
    public Employee(int eno, String name, String position, String phoneNumber, String email, String zipCode,String city, String adress, ArrayList dates){
        this.name = name;
        this.position = position;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.zipCode= zipCode;
        this.city = city;
        this.adress=adress;
        this.dates=dates;
        this.employeeID=eno;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setDato(Date dato) {
        this.dato = dato;
    }

    public void setDates(ArrayList dates) {
        this.dates = dates;
    }

    public String getPosition() {
        return position;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public String getAdress() {
        return adress;
    }

    public Date getDato() {
        return dato;
    }

    public ArrayList getDates() {
        return dates;
    }
    public Employee(int employeeID, String name, String position, ArrayList dates){
        this.name = name;
        this.position = position;
        this.employeeID = employeeID;
        this.dates=dates;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String toString()
    {
        return "Arbejder nummer: " + employeeID + ", Navn: " + name;
    }

    
    
}
