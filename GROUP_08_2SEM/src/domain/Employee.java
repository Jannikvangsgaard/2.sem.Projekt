/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Mike
 */
public class Employee {
    
   private int employeeID;
   private String name;
   
    public Employee(int employeeID, String name){
        this.employeeID = employeeID;
        this.name = name;
    }
    public Employee(String name){
        this.name = name;
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