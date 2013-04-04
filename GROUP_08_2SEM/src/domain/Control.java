package domain;

import java.util.ArrayList;

/**
 *
 * @author Jannik
 */
public class Control {

    ArrayList<Vare> vareliste = new ArrayList<Vare>();
    ArrayList<Order> ordreliste = new ArrayList<Order>();
    ArrayList<Kunde> kundeliste = new ArrayList<Kunde>();
    ArrayList<Vare> varelistereserveret = new ArrayList<Vare>();
    ArrayList ledigevare = new ArrayList();

    public void createVare(int nummer, int antal) {
        Vare vare = new Vare(nummer, antal);
        vareliste.add(vare);

    }

    public void createOrdre(int ordreNo, ArrayList<Vare> Tissemand) {
        Order ordre = new Order(ordreNo, Tissemand);
        ordreliste.add(ordre);
    }

    public ArrayList getVareliste() {
        return vareliste;
    }

    public void createKunde(String navn) {
        Kunde kunde = new Kunde(navn);
        kundeliste.add(kunde);
    }

    public ArrayList getOrdreliste() {
        return ordreliste;
    }

    public ArrayList getKundeliste() {
        return kundeliste;
    }

    public String kundeToString() {
        String res = "";
        for (int i = 0; i < kundeliste.size(); i++) {
            res += kundeliste.get(i).getNavn() + "\n";
        }
        return res;
    }

    public void reserveretVare() {
        for (int i=0;i<ordreliste.size();i++){
        for (int j=0;j<ordreliste.get(i).getVareliste().size();j++){
            varelistereserveret.add(ordreliste.get(j).getVareliste().get(j));
            
        }    
        }
    }
    public void ledigeVare(){
        for (int i=0; i<varelistereserveret.size();i++){
            for (int j=0; j<vareliste.size();j++){
                if (vareliste.get(j)==varelistereserveret.get(i)){
                    ledigevare.add(vareliste.get(j).getVareAntal()-varelistereserveret.get(j).getVareAntal());
                }
            }
        }
    }
}
