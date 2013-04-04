package datasource;

import domain.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
    
    public Order getOrdre(int ono, Connection conn)
    {
        Order o = null;
        
        String SQLString1 = "SELECT * FROM ordre WHERE ono = ?";  //Hent ordre
        String SQLString2 = "SELECT * FROM ordredetails WHERE ono = ?"; //Hent ordredetaljer
        
        PreparedStatement statement = null;
        
        try
        {
            //Hent ordre
            statement = conn.prepareStatement(SQLString1);
            statement.setInt(1, ono);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) 
            {
               if (rs.next()) {
                        o = new Order(rs.getInt(1), 
                                
                                
                //idonteven
            }
        }
        
        catch(Exception ex)
        {
            System.out.println("Fejl i OrderMapper - getOrdre");
            System.out.println(ex.getMessage());
        }
        
        if (testRun) 
        {
            System.out.println("Retrieved Order: " + o);
        }
        return o;
    }

}
