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
   private Date dato;
   private ArrayList dates = new ArrayList();
   
    public Employee(int employeeID, Date dato){
        this.employeeID = employeeID;
        this.dato = dato;
    }
    
    public Employee(String name, String position){
        this.name = name;
        this.position = position;
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
