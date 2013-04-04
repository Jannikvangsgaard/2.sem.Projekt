/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import domain.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Mike
 */
public class TheMapper {
    
    public boolean saveOrder(ArrayList<Order> order, Connection con) {
		int rowsInserted = 0;
		String SQLString1 = "insert into ordre values(?,?,?)";
		String SQLString2 = "insert into ordreDetails values(?,?,?)";
                String SQLString3 = "select employeeseq.nextval from dual";
                
               

		PreparedStatement statement = null;

		try {
                      statement = con.prepareStatement(SQLString3);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
                               for(int k = 0; order.size()>k; k++){
                                   Order o = order.get(k);
                               o.setOrderNo(rs.getInt(1));
                               }
                           
			}
                    
			statement = con.prepareStatement(SQLString1);

			for (int i = 0; i < order.size(); i++) {
				Order o = order.get(i);
				statement.setInt(1, o.getOrderNo());
				statement.setInt(2, o.getKundeID());
				statement.setInt(3, o.getState());

				rowsInserted += statement.executeUpdate();
			}

			if (rowsInserted == order.size()) {
				rowsInserted = 0;
				statement = con.prepareStatement(SQLString2);

				for (int i = 0; i < order.size(); i++) {
					Order o = order.get(i);
                                        for(int j = 0 ; j < o.getVareliste().size(); j++){
					statement.setInt(1, o.getVareliste().get(j).getVareNo());
					statement.setInt(2, o.getVareliste().get(j).getVareAntal());
                                        statement.setInt(3, o.getOrderNo());
                                        }
					rowsInserted += statement.executeUpdate();
				}
			} else {
				System.out.println("Fejl i OrdreMapper - Part 1");
			}

		} catch (Exception e) {
			System.out.println("Fejl i OrdreMapper - SaveNewProject");
			e.printStackTrace();
		}
		return rowsInserted == order.size();

	}
    
    
     public boolean saveItem(ArrayList<Item> item, Connection con) {
		int rowsInserted = 0;
		String SQLString1 = "update tilrådighed set antal = ? where varerNo = ?; ";
	
		PreparedStatement statement = null;

		try {
			statement = con.prepareStatement(SQLString1);

			for (int i = 0; i < item.size(); i++) {
				Item it = item.get(i);
				statement.setInt(1, o.getOrderNo());
				statement.setInt(2, o.getKundeID());
				statement.setInt(3, o.getState());

				rowsInserted += statement.executeUpdate();
			}

			if (rowsInserted == order.size()) {
				rowsInserted = 0;
				statement = con.prepareStatement(SQLString2);

				for (int i = 0; i < order.size(); i++) {
					Order o = order.get(i);
                                        for(int j = 0 ; j < o.getVareliste().size(); j++){
					statement.setInt(1, o.getVareliste().get(j).getVareNo());
					statement.setInt(2, o.getVareliste().get(j).getVareAntal());
                                        statement.setInt(3, o.getOrderNo());
                                        }
					rowsInserted += statement.executeUpdate();
				}
			} else {
				System.out.println("Fejl i OrdreMapper - Part 1");
			}

		} catch (Exception e) {
			System.out.println("Fejl i OrdreMapper - SaveNewProject");
			e.printStackTrace();
		}
		return rowsInserted == order.size();

	}
    
    
}
