package domain;

/**
 *
 * @author Jannik
 */
public class Ordre {
    private int ordreNo;
    private int antal;
    private Kunde kunde;
    
    public Ordre(Kunde kunde,int antal, int no){
      this.kunde=kunde;
      this.antal = antal;
      this.ordreNo = no;
      
    }
    
}
