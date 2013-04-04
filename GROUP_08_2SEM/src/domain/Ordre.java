package domain;

import java.util.ArrayList;

/**
 *
 * @author Jannik
 */
public class Ordre {
    private int ordreNo;
    private int antal;
    private int kundeID;
    private int state;
    private ArrayList<Vare> vareliste = new ArrayList<Vare>();
    public Ordre(int antal, int no, ArrayList<Vare> tissemand){
      this.antal = antal;
      this.ordreNo = no;
      vareliste = tissemand;          
      state=0;        
              
    }

    public int getOrdreNo() {
        return ordreNo;
    }

    public void setOrdreNo(int ordreNo) {
        this.ordreNo = ordreNo;
    }

    public int getAntal() {
        return antal;
    }

    public void setAntal(int antal) {
        this.antal = antal;
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

    public void setVareliste(ArrayList<Vare> vareliste) {
        this.vareliste = vareliste;
    }
    public ArrayList getVareArray(){
        return vareliste;
    }
    
    
        
}
