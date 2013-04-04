package domain;

import java.util.ArrayList;

/**
 *
 * @author Jannik
 */
public class Control {
   
    ArrayList<Vare> vareliste = new ArrayList<Vare>();
    
    public void createVare(String navn, int antal, int nummer){
        Vare vare= new Vare(navn, antal, nummer);
        vareliste.add(vare);
        
    }
    public ArrayList getVareliste(){
        return vareliste;
    }
    public void createKunde(String navn){
       Kunde kunde = new Kunde(navn);
    }
}
