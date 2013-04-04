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
    private ArrayList<Vare> vareliste = new ArrayList<Vare>();
    public Ordre(int antal, int no, ArrayList<Vare> tissemand){
      this.antal = antal;
      this.ordreNo = no;
      vareliste = tissemand;          
              
              
              
              
      
      
    }
    public ArrayList getVareArray(){
        return vareliste;
    }
    
        
}
