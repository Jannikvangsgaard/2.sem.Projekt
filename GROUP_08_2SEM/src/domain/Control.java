package domain;

import java.util.ArrayList;

/**
 *
 * @author Jannik
 */
public class Control {
   
    ArrayList<Vare> vareliste = new ArrayList<Vare>();
    ArrayList<Order> ordreliste = new ArrayList<Order>();
    
    public void createVare(int nummer, int antal){
        Vare vare= new Vare(nummer, antal);
        vareliste.add(vare);
        
    }
    public void createOrdre(int ordreNo, ArrayList<Vare> Tissemand){
       Order ordre = new Order(ordreNo, Tissemand);
       ordreliste.add(ordre);
    }
    public ArrayList getVareliste(){
        return vareliste;
    }
    public void createKunde(String navn){
       Kunde kunde = new Kunde(navn);
    }
    public ArrayList getOrdreliste(){
        return ordreliste;
    }
}
