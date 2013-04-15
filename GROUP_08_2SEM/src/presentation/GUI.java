package presentation;

import domain.Control;
import domain.Customer;
import domain.Item;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Jannik
 */
public class GUI extends javax.swing.JFrame
{

    Control control = new Control();
    DefaultListModel model1;
    DefaultListModel model2;
    ArrayList<Item> orderList = new ArrayList();
    ArrayList<Item> vareliste2 = new ArrayList();

    /**
     * Creates new form GUI
     */
    public GUI()
    {
        initComponents();
        model1 = new DefaultListModel();
        model2 = new DefaultListModel();
        jListvareliste.setModel(model1);
        jListVareTilOrdre.setModel(model2);
        control.loadItemliste();
//        vareliste2 = control.getAvailableItems();
        control.loadAvailableItems();
        
        visVareliste();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldKundeNavn = new javax.swing.JTextField();
        jButtonOpretKunde = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaVisKunder = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jButtonHentKunder = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListvareliste = new javax.swing.JList();
        jTextFieldAntalItems = new javax.swing.JTextField();
        jButtonTilføjvare = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListVareTilOrdre = new javax.swing.JList();
        jTextFieldCustomerNo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButtonSaveOrder = new javax.swing.JButton();
        jButtonFjernVare = new javax.swing.JButton();
        jLabelOrderSavedNotSaved = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel1.setText("Opret ny kunde");

        jButtonOpretKunde.setText("Opret");
        jButtonOpretKunde.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonOpretKundeActionPerformed(evt);
            }
        });

        jTextAreaVisKunder.setColumns(20);
        jTextAreaVisKunder.setRows(5);
        jScrollPane2.setViewportView(jTextAreaVisKunder);

        jLabel2.setText("Vis kunder:");

        jButtonHentKunder.setText("Hent");
        jButtonHentKunder.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonHentKunderActionPerformed(evt);
            }
        });

        jLabel7.setText("Navn:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonHentKunder))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldKundeNavn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonOpretKunde))
                .addContainerGap(382, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonHentKunder))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldKundeNavn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonOpretKunde)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(115, 115, 115))
        );

        jTabbedPane1.addTab("Opret Kunde", jPanel1);

        jScrollPane1.setViewportView(jListvareliste);

        jTextFieldAntalItems.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                jTextFieldAntalItemsKeyReleased(evt);
            }
        });

        jButtonTilføjvare.setText("Tilføj Vare");
        jButtonTilføjvare.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonTilføjvareActionPerformed(evt);
            }
        });
        jButtonTilføjvare.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                jButtonTilføjvareKeyReleased(evt);
            }
        });

        jScrollPane3.setViewportView(jListVareTilOrdre);

        jLabel3.setText("Vare liste:");

        jLabel4.setText("Antal vare:");

        jLabel5.setText("Kunde nummer:");

        jLabel6.setText("Vare til ordre:");

        jButtonSaveOrder.setText("Bekræft Ordre");
        jButtonSaveOrder.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonSaveOrderActionPerformed(evt);
            }
        });

        jButtonFjernVare.setText("Fjern Vare");
        jButtonFjernVare.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonFjernVareActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(jButtonTilføjvare, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jTextFieldAntalItems)
                    .addComponent(jButtonFjernVare, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(83, 83, 83)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelOrderSavedNotSaved, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(jButtonSaveOrder)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jTextFieldCustomerNo, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextFieldCustomerNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonSaveOrder))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldAntalItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonTilføjvare)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonFjernVare)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelOrderSavedNotSaved, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Bestilling", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOpretKundeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOpretKundeActionPerformed

        String navn = jTextFieldKundeNavn.getText();
        if (navn != null)
        {
            control.createCustomer(navn);
        } else if (navn == null)
        {
            JOptionPane.showMessageDialog(null, "Husk at skrive et navn");
        }
    }//GEN-LAST:event_jButtonOpretKundeActionPerformed

    private void jButtonHentKunderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHentKunderActionPerformed

        if (control.getCustomerlist() != null)
        {
            jTextAreaVisKunder.setText(control.customerToString());

        }


    }//GEN-LAST:event_jButtonHentKunderActionPerformed

    private void jButtonTilføjVareActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonTilføjVareActionPerformed
    {//GEN-HEADEREND:event_jButtonTilføjVareActionPerformed
    }//GEN-LAST:event_jButtonTilføjVareActionPerformed

    private void jButtonSaveOrderActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonSaveOrderActionPerformed
    {//GEN-HEADEREND:event_jButtonSaveOrderActionPerformed
        int kundeNo = Integer.parseInt(jTextFieldCustomerNo.getText());

//        ArrayList<Item> orderList = new ArrayList();
//        for (int j = 0; j < model2.size(); j++)
//        {
//            orderList.add((Item) model2.getElementAt(j));
//        }
        ArrayList<Customer> customerlist = control.getCustomerlist();
        for (int i = 0; i < customerlist.size(); i++)
        {

            if (customerlist.get(i).getCustomerID() == kundeNo)
            {
                control.createOrder(orderList, customerlist.get(i));
                model2.clear();
                jTextFieldCustomerNo.setText("");
            }

        }

        if(control.saveOrder() == true)
        {
            jLabelOrderSavedNotSaved.setText("Ordren blev gemt");
        }
        else
        {
            jLabelOrderSavedNotSaved.setText("Ordren blev ikke gemt");
        }
        orderList.clear();
        control.saveFreeItems(vareliste2);
    }//GEN-LAST:event_jButtonSaveOrderActionPerformed

    private void jButtonTilføjvareActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonTilføjvareActionPerformed
    {//GEN-HEADEREND:event_jButtonTilføjvareActionPerformed
        System.out.println("tilføj");
        int amount2 = Integer.parseInt(jTextFieldAntalItems.getText());
        boolean add = false;
        System.out.println(vareliste2.size());
        for (int i = 0; i < vareliste2.size(); i++)
        {
            System.out.println(vareliste2.size());
            if (vareliste2.get(i).toStringGUI().equals(jListvareliste.getSelectedValue()))
            {
                if (amount2 <= vareliste2.get(i).getItemAmount())
                {
                    int amount3 = (vareliste2.get(i).getItemAmount() - Integer.parseInt(jTextFieldAntalItems.getText()));
                    Item item = vareliste2.get(i);
                    Item item2 = vareliste2.get(i);
                    item.setItemAmount(amount2);

                    for (int h = 0; h < orderList.size(); h++)
                    {
                        if (orderList.get(h).getItemNo() == vareliste2.get(i).getItemNo())
                        {
                            orderList.get(h).setItemAmount(orderList.get(h).getItemAmount() + Integer.parseInt(jTextFieldAntalItems.getText()));
                            add = true;
                        }

                    }
                    if (add == false)
                    {
                        orderList.add(new Item(item.getItemNo(), item.getItemName(), item.getItemAmount()));
                    }
                    model2.clear();
                    for (int j = 0; j < orderList.size(); j++)
                    {
                        model2.addElement(orderList.get(j).toStringGUIReserved());
                        jTextFieldAntalItems.setText("");
                    }
                    item2.setItemAmount(amount3);
                    model1.clear();
                    for (int g = 0; g < vareliste2.size(); g++)
                    {
                        model1.addElement(vareliste2.get(g).toStringGUI());
                    }

                } else
                {
                    JOptionPane.showMessageDialog(null, "Antal Vare er for stort i forhold til det antal der er på lager");
                    break;
                }
            }

        }
    }//GEN-LAST:event_jButtonTilføjvareActionPerformed

    private void jButtonFjernVareActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonFjernVareActionPerformed
    {//GEN-HEADEREND:event_jButtonFjernVareActionPerformed
        for (int i = 0; i < model2.size(); i++)
        {
            if (jListVareTilOrdre.getSelectedValue().equals(model2.elementAt(i)))
            {
                model1.clear();
                for (int g = 0; g < vareliste2.size(); g++)
                {
                    if(orderList.get(i).getItemNo() == vareliste2.get(g).getItemNo())
                    {
                        vareliste2.get(g).setItemAmount(vareliste2.get(g).getItemAmount() + orderList.get(i).getItemAmount());
                    }
                    model1.addElement(vareliste2.get(g).toStringGUI());
                }
                orderList.remove(i);
            }
        }
        model2.removeElement(jListVareTilOrdre.getSelectedValue());
    }//GEN-LAST:event_jButtonFjernVareActionPerformed

    private void jButtonTilføjvareKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jButtonTilføjvareKeyReleased
    {//GEN-HEADEREND:event_jButtonTilføjvareKeyReleased
    }//GEN-LAST:event_jButtonTilføjvareKeyReleased

    private void jTextFieldAntalItemsKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTextFieldAntalItemsKeyReleased
    {//GEN-HEADEREND:event_jTextFieldAntalItemsKeyReleased
        try
        {
            if (jTextFieldAntalItems.getText() != null)
            {
                int amount = Integer.parseInt(jTextFieldAntalItems.getText());
            }
        } catch (NumberFormatException ex)
        {
            jTextFieldAntalItems.setText("");
            JOptionPane.showMessageDialog(null, "Antal Vare skal være større end 0 og et helt tal");
        }
    }//GEN-LAST:event_jTextFieldAntalItemsKeyReleased

    /**
     * @param args the command line arguments
     */
    public void visVareliste()
    {
        try
        {
            model1.clear();
            vareliste2 = control.getAvailableItems();
            for (int i = 0; i < vareliste2.size(); i++)
            {
                model1.addElement(vareliste2.get(i).toStringGUI());
            }
        } catch (NullPointerException ex)
        {
            System.out.println("Error in GUI - \"visVareListe\"");
        }

    }

    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new GUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonFjernVare;
    private javax.swing.JButton jButtonHentKunder;
    private javax.swing.JButton jButtonOpretKunde;
    private javax.swing.JButton jButtonSaveOrder;
    private javax.swing.JButton jButtonTilføjvare;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelOrderSavedNotSaved;
    private javax.swing.JList jListVareTilOrdre;
    private javax.swing.JList jListvareliste;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextAreaVisKunder;
    private javax.swing.JTextField jTextFieldAntalItems;
    private javax.swing.JTextField jTextFieldCustomerNo;
    private javax.swing.JTextField jTextFieldKundeNavn;
    // End of variables declaration//GEN-END:variables
}
