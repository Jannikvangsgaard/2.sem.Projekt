package datasource;

import domain.Ordre;
import java.sql.Connection;

/**
 * @author 
 * Anders Friis Pedersen
 * CLdat-b12e
 * <andersfriis91@gmail.com>
 */

public class OrderMapperPIK 
{
    
    static boolean testRun = false;
    
    /**
     * Metoder til at gemme på databasen
     */
    
    
    
    
    
    
    
    
    
    
    /**
     * Metoder til at læse fra databasen
     */
    
    public Ordre getOrdre(int ono, Connection conn)
    {
        Ordre o = null;
        
        String SQLString1 = "SELECT * FROM ordre WHERE ono = ?";  //Hent ordre
        String SQLString2 = "SELECT * FROM ordredetails WHERE ono = ?"; //Hent ordredetaljer
    }

}
