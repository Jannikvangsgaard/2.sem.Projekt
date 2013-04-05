package datasource;

import domain.Order;
import domain.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @author 
 * Anders Friis Pedersen
 * CLdat-b12e
 * <andersfriis91@gmail.com>
 */

public class OrderMapperPIK 
{
    
    static boolean testRun = false;
    
    public Order getOrder(int ono, Connection conn)
    {
        Order o = null;
        
        String SQLString1 = "SELECT * FROM ordre";  //Get order
        String SQLString2 = "SELECT varerno, antal FROM ordredetails WHERE ordreno = ?"; //Get orderdetails
        
        PreparedStatement statement = null;
        PreparedStatement statement2 = null;
        
         try
        {
            //Get order
            statement = conn.prepareStatement(SQLString1);
            statement2 = conn.prepareStatement(SQLString2);
            ArrayList<Item> vare = new ArrayList();
            
            ResultSet rs = statement.executeQuery();
            ResultSet rs2 = statement2.executeQuery();
            while (rs2.next()) 
            {
                int VareNo = rs2.getInt(1);
                int qty = rs2.getInt(2);
                Item v = new Item(VareNo, qty);
                vare.add(v);
            }
            while (rs.next())
            {
                o = new Order(ono, vare);
            }
        }
         
        catch(Exception ex)
        {
            System.out.println("Error in OrderMapper - getOrdre");
            System.out.println(ex.getMessage());
        }
        
        if (testRun) 
        {
            System.out.println("Retrieved Order: " + o);
        }
        return o;
    }

}
