package domain;

import java.util.ArrayList;

/**
 *
 * @author Jannik
 */
public class Control {

    ArrayList<Item> vareliste = new ArrayList<Item>();
    ArrayList<Order> ordreliste = new ArrayList<Order>();
    ArrayList<Customer> kundeliste = new ArrayList<Customer>();
    ArrayList<Item> varelistereserveret = new ArrayList<Item>();
    ArrayList ledigevare = new ArrayList();

    public void createVare(int nummer, int antal) {
        Item vare = new Item(nummer, antal);
        vareliste.add(vare);

    }

    public void createOrdre(int ordreNo, ArrayList<Item> Tissemand) {
        Order ordre = new Order(ordreNo, Tissemand);
        ordreliste.add(ordre);
    }

    public ArrayList getVareliste() {
        return vareliste;
    }

    public void createKunde(String navn) {
        Customer kunde = new Customer(navn);
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
            res += kundeliste.get(i).getName() + "\n";
        }
        return res;
    }

    public void reserveretVare() {
        for (int i=0;i<ordreliste.size();i++){
        for (int j=0;j<ordreliste.get(i).getItemlist().size();j++){
            varelistereserveret.add(ordreliste.get(j).getItemlist().get(j));
            
        }    
        }
    }
    public void ledigeVare(){
        for (int i=0; i<varelistereserveret.size();i++){
            for (int j=0; j<vareliste.size();j++){
                if (vareliste.get(j)==varelistereserveret.get(i)){
                    ledigevare.add(vareliste.get(j).getItemAmount()-varelistereserveret.get(j).getItemAmount());
                }
            }
        }
    }
}
