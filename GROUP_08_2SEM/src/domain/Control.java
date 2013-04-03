package domain;

import java.util.ArrayList;

/**
 *
 * @author Jannik
 */
public class Control {
    
    ArrayList<Vare> vareliste = new ArrayList<Vare>();
    public void createVare(String navn, int antal, String nummer){
        Vare vare= new Vare(navn, antal, navn);
        vareliste.add(vare);
        
    }
    public ArrayList getVareliste(){
        return vareliste;
    }
}
