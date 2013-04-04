package datasource;

import domain.*;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Thomas Kragsberger
 */
public class DBFacade
{
    	  private TheMapper om; 
	  private Connection con;
	  private static DBFacade instance;
	 
	  private DBFacade() {
		  om 	= new TheMapper();
		  con 	= new DBConnector().getConnection(); 
		  							  
	  }
	  public static DBFacade getInstance()
	  {
		  if(instance == null)
			  instance = new DBFacade();
		  return instance;
	  }
          
          public Order getOrder(int ono) 
	  {
		  return om.getOrder(ono, con);	      
	  }
          
          public Kunde getKunde(int ono)
          {
              return om.getKunde(ono, con);
          }
          
          public boolean saveOrder(ArrayList<Order> o)
          {
              return om.saveOrder(o, con);
          }
}
