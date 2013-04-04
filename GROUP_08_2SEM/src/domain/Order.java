package domain;

import java.util.ArrayList;

/**
 *
 * @author Jannik
 */
public class Order {
    private int orderNo;
    private int kundeID;
    private int state;
    private ArrayList<Vare> vareliste = new ArrayList<Vare>();
    public Order(int no, ArrayList<Vare> tissemand){
      this.orderNo = no;
      vareliste = tissemand;          
      state=0;        
              
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int ordreNo) {
        this.orderNo = ordreNo;
    }

    public int getKundeID() {
        return kundeID;
    }

    public void setKundeID(int kundeID) {
        this.kundeID = kundeID;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public ArrayList<Vare> getVareliste() {
        return vareliste;
    }

    
    
        
}
