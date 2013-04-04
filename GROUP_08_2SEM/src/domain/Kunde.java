package domain;

/**
 *
 * @author Jannik
 */
public class Kunde {
   private String kundeID;
   private String navn;
   
   public Kunde getKunde(){
       return this;
   }
    public Kunde(String navn) {
        this.navn = navn;
    }

    public String getKundeID() {
        return kundeID;
    }

    public void setKundeID(String kundeID) {
        this.kundeID = kundeID;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    
}
