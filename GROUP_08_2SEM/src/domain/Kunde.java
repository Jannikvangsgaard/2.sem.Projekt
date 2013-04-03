package domain;

/**
 *
 * @author Jannik
 */
public class Kunde {
   private String kundeID;
   private String navn;
   private String ordreNo;

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

    public String getOrdreNo() {
        return ordreNo;
    }

    public void setOrdreNo(String ordreNo) {
        this.ordreNo = ordreNo;
    }
    
}
