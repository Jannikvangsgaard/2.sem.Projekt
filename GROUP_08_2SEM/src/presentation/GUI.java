package presentation;

import domain.Control;
import domain.Customer;
import domain.Item;
import java.util.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Jannik
 */
public class GUI extends javax.swing.JFrame {

    Control control = new Control();
    DefaultListModel modelvareliste;
    DefaultListModel modelVareTilOrdre;
    DefaultListModel StatusListe;
    DefaultListModel model4;
    DefaultListModel model5;
    DefaultListModel model6;
    ArrayList<Item> orderList = new ArrayList();
    ArrayList<Item> vareliste2 = new ArrayList();
    ArrayList<Item> alleItemsList = new ArrayList();
    ArrayList<Item> it = new ArrayList();
    ArrayList<Item> newItem = new ArrayList();

    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
        modelvareliste = new DefaultListModel();
        modelVareTilOrdre = new DefaultListModel();
        StatusListe = new DefaultListModel();
        model4 = new DefaultListModel();
        model5 = new DefaultListModel();
        model6 = new DefaultListModel();
        jListvareliste.setModel(modelvareliste);
        jListVareTilOrdre.setModel(modelVareTilOrdre);
        jListStatusListe.setModel(StatusListe);
//        jListStatusInformation.setModel(model4);
        jListVarePåLagerStatus.setModel(model5);
        VisÆndringer.setModel(model6);

        control.loadItemliste();
//        control.reservedItem();
//        control.availableItems();
//        control.loadSingleOrder(1025);


//        control.loadAllOrders();
//        control.loadAvailableItems();

//        visVareliste();
        visAlleItemListe();

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
        jButtonTest = new javax.swing.JButton();
        jTextFieldDateÅr = new javax.swing.JTextField();
        jTextFieldDateDage = new javax.swing.JTextField();
        jTextFieldDatoMåned = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldTest = new javax.swing.JTextField();
        jButtonHentVareListe = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButtonHentOrdre = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListStatusListe = new javax.swing.JList();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextOrdreInformationer = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jListVarePåLagerStatus = new javax.swing.JList();
        jTextFieldÆndringAfVareAntal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButtonBekræftÆndring = new javax.swing.JButton();
        TilføjÆndring = new javax.swing.JButton();
        FjernÆndring = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        VisÆndringer = new javax.swing.JList();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldNyVareNavn = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldNyVareAntal = new javax.swing.JTextField();
        jButtonLavNyVare = new javax.swing.JButton();

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
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldKundeNavn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonOpretKunde)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonHentKunder)))
                .addContainerGap(443, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldKundeNavn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonOpretKunde)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonHentKunder)
                .addContainerGap(142, Short.MAX_VALUE))
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

        jButtonTest.setText("test");
        jButtonTest.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonTestActionPerformed(evt);
            }
        });

        jTextFieldDateÅr.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jTextFieldDateÅr.setText("År");
        jTextFieldDateÅr.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jTextFieldDateÅrMouseClicked(evt);
            }
        });

        jTextFieldDateDage.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jTextFieldDateDage.setText("Dage");
        jTextFieldDateDage.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jTextFieldDateDageMouseClicked(evt);
            }
        });

        jTextFieldDatoMåned.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jTextFieldDatoMåned.setText("Måned");
        jTextFieldDatoMåned.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jTextFieldDatoMånedMouseClicked(evt);
            }
        });

        jLabel9.setText("Dato:");

        jButtonHentVareListe.setText("Hent vareliste");
        jButtonHentVareListe.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonHentVareListeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextFieldDateDage, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldDatoMåned, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldDateÅr, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonHentVareListe))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4)
                                .addComponent(jButtonTilføjvare, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(jTextFieldAntalItems)
                                .addComponent(jButtonFjernVare))
                            .addComponent(jButtonTest)
                            .addComponent(jTextFieldTest, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(83, 83, 83)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButtonSaveOrder)
                                .addGap(41, 41, 41))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldCustomerNo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jLabelOrderSavedNotSaved, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(292, 292, 292)
                        .addComponent(jLabelOrderSavedNotSaved, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldDateDage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldDatoMåned, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldDateÅr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonHentVareListe))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jTextFieldCustomerNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(14, 14, 14)
                                        .addComponent(jButtonSaveOrder))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldAntalItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonTilføjvare)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonFjernVare)
                                .addGap(50, 50, 50)
                                .addComponent(jTextFieldTest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonTest)))))
                .addContainerGap(139, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Bestilling", jPanel2);

        jButtonHentOrdre.setText("Hent Ordre");
        jButtonHentOrdre.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonHentOrdreActionPerformed(evt);
            }
        });

        jListStatusListe.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                jListStatusListeMousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(jListStatusListe);

        jTextOrdreInformationer.setColumns(20);
        jTextOrdreInformationer.setRows(5);
        jScrollPane8.setViewportView(jTextOrdreInformationer);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonHentOrdre)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(245, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane8)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jButtonHentOrdre)
                .addContainerGap(156, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Status", jPanel3);

        jScrollPane6.setViewportView(jListVarePåLagerStatus);

        jTextFieldÆndringAfVareAntal.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jTextFieldÆndringAfVareAntalActionPerformed(evt);
            }
        });
        jTextFieldÆndringAfVareAntal.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                jTextFieldÆndringAfVareAntalKeyReleased(evt);
            }
        });

        jLabel8.setText("Ændring af vare");

        jButtonBekræftÆndring.setText("Bekræft");
        jButtonBekræftÆndring.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonBekræftÆndringActionPerformed(evt);
            }
        });

        TilføjÆndring.setText("Tilføj");
        TilføjÆndring.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                TilføjÆndringActionPerformed(evt);
            }
        });

        FjernÆndring.setText("Fjern");
        FjernÆndring.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                FjernÆndringActionPerformed(evt);
            }
        });

        VisÆndringer.setToolTipText("");
        jScrollPane7.setViewportView(VisÆndringer);

        jLabel10.setText("Ny vare");

        jLabel11.setText("Vare navn");

        jLabel12.setText("Vare antal");

        jButtonLavNyVare.setText("Lav vare");
        jButtonLavNyVare.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonLavNyVareActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jTextFieldNyVareNavn))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldNyVareAntal))
                            .addComponent(jButtonLavNyVare))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)))
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TilføjÆndring, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBekræftÆndring, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldÆndringAfVareAntal, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(FjernÆndring, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNyVareNavn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNyVareAntal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonLavNyVare))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane7)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextFieldÆndringAfVareAntal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(TilføjÆndring)
                            .addGap(18, 18, 18)
                            .addComponent(FjernÆndring)
                            .addGap(21, 21, 21)
                            .addComponent(jButtonBekræftÆndring))))
                .addContainerGap(210, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Lager Status", jPanel4);

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
        if (!jTextFieldKundeNavn.getText().equals("")) {
            control.createCustomer(navn);
            jTextFieldKundeNavn.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Husk at skrive et navn");
        }
    }//GEN-LAST:event_jButtonOpretKundeActionPerformed

    private void jButtonHentKunderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHentKunderActionPerformed

        if (control.getCustomerlist() != null) {
            jTextAreaVisKunder.setText(control.customerToString());
        }


    }//GEN-LAST:event_jButtonHentKunderActionPerformed

    private void jButtonTilføjVareActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonTilføjVareActionPerformed
    {//GEN-HEADEREND:event_jButtonTilføjVareActionPerformed
    }//GEN-LAST:event_jButtonTilføjVareActionPerformed

    private void jButtonSaveOrderActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonSaveOrderActionPerformed
    {//GEN-HEADEREND:event_jButtonSaveOrderActionPerformed
        if (jTextFieldCustomerNo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Der mangler et kunde nummer");
        } else {
            int kundeNo = 0;
            try {
                kundeNo = Integer.parseInt(jTextFieldCustomerNo.getText());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "KundeNo skal være hel tal");
            }
            Calendar cal = Calendar.getInstance();
            Date date = (Date) cal.getTime();
            String dag = jTextFieldDateDage.getText();
            String måned = jTextFieldDatoMåned.getText();
            String aar = jTextFieldDateÅr.getText();
            String dato = aar + måned + dag;
            DateFormat newDate = new SimpleDateFormat("yyyyMMdd");
            try {
                date = newDate.parse(dato);
            } catch (ParseException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            ArrayList<Customer> customerlist = control.getCustomerlist();
            for (int i = 0; i < customerlist.size(); i++) {

                if (customerlist.get(i).getCustomerID() == kundeNo && kundeNo != 0) {
                    control.createOrder(orderList, customerlist.get(i), date);
                    modelVareTilOrdre.clear();
                    jTextFieldCustomerNo.setText("");
                    jTextFieldDateDage.setText("Dage");
                    jTextFieldDatoMåned.setText("Måned");
                    jTextFieldDateÅr.setText("År");
                }
            }
            try {
                if (control.varelisteTjek(orderList) == true) {
                    control.saveOrder();
                    jLabelOrderSavedNotSaved.setText("Ordren blev gemt");
//                    control.saveFreeItems(vareliste2);
                    visVareliste();
                } else {
                    jLabelOrderSavedNotSaved.setText("Ordren blev ikke gemt");
                    visVareliste();
                }
            } catch (SQLException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            orderList.clear();
        }
    }//GEN-LAST:event_jButtonSaveOrderActionPerformed

    private void jButtonTilføjvareActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonTilføjvareActionPerformed
    {//GEN-HEADEREND:event_jButtonTilføjvareActionPerformed
        try {
            int amount2 = Integer.parseInt(jTextFieldAntalItems.getText());
            boolean add = false;
            for (int i = 0; i < vareliste2.size(); i++) {
                if (vareliste2.get(i).toStringGUI().equals(jListvareliste.getSelectedValue())) {
                    if (amount2 <= vareliste2.get(i).getItemAmount()) {
                        int amount3 = (vareliste2.get(i).getItemAmount() - Integer.parseInt(jTextFieldAntalItems.getText()));
                        Item item = vareliste2.get(i);
                        Item item2 = vareliste2.get(i);
                        item.setItemAmount(amount2);

                        for (int h = 0; h < orderList.size(); h++) {
                            if (orderList.get(h).getItemNo() == vareliste2.get(i).getItemNo()) {
                                orderList.get(h).setItemAmount(orderList.get(h).getItemAmount() + Integer.parseInt(jTextFieldAntalItems.getText()));
                                add = true;
                            }
                        }
                        if (add == false) {
                            orderList.add(new Item(item.getItemNo(), item.getItemName(), item.getItemAmount()));
                        }
                        modelVareTilOrdre.clear();
                        for (int j = 0; j < orderList.size(); j++) {
                            modelVareTilOrdre.addElement(orderList.get(j).toStringGUIReserved());
                            jTextFieldAntalItems.setText("");
                        }
                        item2.setItemAmount(amount3);
                        modelvareliste.clear();
                        for (int g = 0; g < vareliste2.size(); g++) {
                            modelvareliste.addElement(vareliste2.get(g).toStringGUI());
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Antal Vare er for stort i forhold til det antal der er på lager");
                        break;
                    }
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Husk at skrive antal");
        }
    }//GEN-LAST:event_jButtonTilføjvareActionPerformed

    private void jButtonFjernVareActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonFjernVareActionPerformed
    {//GEN-HEADEREND:event_jButtonFjernVareActionPerformed
        System.out.println("hej");
        int a = modelVareTilOrdre.size();
        for (int i = 0; i < modelVareTilOrdre.size(); i++) {
            try {
                if (jListVareTilOrdre.getSelectedValue().equals(modelVareTilOrdre.elementAt(i))) {
                    modelvareliste.clear();
                    for (int g = 0; g < vareliste2.size(); g++) {
                        if (orderList.get(i).getItemNo() == vareliste2.get(g).getItemNo()) {
                            vareliste2.get(g).setItemAmount(vareliste2.get(g).getItemAmount() + orderList.get(i).getItemAmount());
                        }
                        modelvareliste.addElement(vareliste2.get(g).toStringGUI());
                        modelVareTilOrdre.removeElement(jListVareTilOrdre.getSelectedValue());
                    }
                    orderList.remove(i);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Husk at vælge en vare at fjerne");
            }
        }
        if (a==0){
            JOptionPane.showMessageDialog(null, "Husk at hente Liste før du prøve at fjerne en vare");
        }
    }//GEN-LAST:event_jButtonFjernVareActionPerformed

    private void jButtonTilføjvareKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jButtonTilføjvareKeyReleased
    {//GEN-HEADEREND:event_jButtonTilføjvareKeyReleased
    }//GEN-LAST:event_jButtonTilføjvareKeyReleased

    private void jTextFieldAntalItemsKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTextFieldAntalItemsKeyReleased
    {//GEN-HEADEREND:event_jTextFieldAntalItemsKeyReleased
        try {
            if (jTextFieldAntalItems.getText() != null) {
                int amount = Integer.parseInt(jTextFieldAntalItems.getText());
            }
        } catch (NumberFormatException ex) {
            jTextFieldAntalItems.setText("");
            JOptionPane.showMessageDialog(null, "Antal Vare skal være større end 0 og et helt tal");
        }
    }//GEN-LAST:event_jTextFieldAntalItemsKeyReleased

    private void jButtonHentOrdreActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonHentOrdreActionPerformed
    {//GEN-HEADEREND:event_jButtonHentOrdreActionPerformed
        StatusListe.clear();
        for (int i = 0; i < control.getOrderlist().size(); i++) {
            StatusListe.addElement(control.getOrderlist().get(i).toString());
        }
        Calendar cal = Calendar.getInstance();
        Date date = (Date) cal.getTime();
        if (StatusListe.isEmpty()) {
            try {
                control.loadAllOrders();
                control.loadOrdersWithDate(date);
                for (int i = 0; i < control.getOrderlist().size(); i++) {
                    StatusListe.addElement(control.getOrderlist().get(i).toString());
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "pik??");
            }
        }

    }//GEN-LAST:event_jButtonHentOrdreActionPerformed

    private void jButtonTestActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonTestActionPerformed
    {//GEN-HEADEREND:event_jButtonTestActionPerformed
//        try
//        {
//            control.commit();
//        } catch (SQLException ex)
//        {
//            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
//        }
        for (int i = 0; i < control.getOrderlist().size(); i++) {
            jTextFieldTest.setText("" + control.getOrderlist().get(i).getBestillingsDate());
        }
    }//GEN-LAST:event_jButtonTestActionPerformed

    private void jButtonBekræftÆndringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBekræftÆndringActionPerformed
        if (!it.isEmpty()){
        control.increaseAmount(it);
        visAlleItemListe();
        visVareliste();
        model6.removeAllElements();
        } else{
            JOptionPane.showMessageDialog(null, "Husk at tilføj/fjern før du kan bekræftte");
    }

    }//GEN-LAST:event_jButtonBekræftÆndringActionPerformed

    private void FjernÆndringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FjernÆndringActionPerformed
        int plads = 0;
        if (jListVarePåLagerStatus.getSelectedValue() != null) {
            System.out.println("HEJHEJHEJEHJ" + jListVarePåLagerStatus.getSelectedValue().toString());
            int antal = Integer.parseInt(jTextFieldÆndringAfVareAntal.getText());
            String selected = jListVarePåLagerStatus.getSelectedValue().toString();
            for (int i = 0; i < alleItemsList.size(); i++) {
                if (alleItemsList.get(i).toStringGUI().equals(selected)) {
                    if (antal <= alleItemsList.get(i).getItemAmount()) {
                        Item v = alleItemsList.get(i);
                        v.setAmountTotal(v.getItemAmount() + antal);
                        it.add(v);
                        jTextFieldÆndringAfVareAntal.setText("");
                        visVareliste();
                        visAlleItemListe();
                        model6.add(plads, "Fjern af: " + v.getItemName() + " Antal: " + antal);
                        plads++;
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Husk at vælge en vare");
        }
    }//GEN-LAST:event_FjernÆndringActionPerformed

    private void TilføjÆndringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TilføjÆndringActionPerformed
        int plads = 0;
        if (jListVarePåLagerStatus.getSelectedValue() != null) {
            int antal = Integer.parseInt(jTextFieldÆndringAfVareAntal.getText());
            String selected = jListVarePåLagerStatus.getSelectedValue().toString();
            for (int i = 0; i < alleItemsList.size(); i++) {
                if (alleItemsList.get(i).toStringGUI().equals(selected)) {
                    Item v = alleItemsList.get(i);
                    v.setAmountTotal(v.getItemAmount() + antal);
                    it.add(v);
                    jTextFieldÆndringAfVareAntal.setText("");
                    visVareliste();
                    visAlleItemListe();
                    model6.add(plads, "Tilføj af: " + v.getItemName() + " Antal: " + antal);
                    plads++;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Husk at vælge en vare");
        }

    }//GEN-LAST:event_TilføjÆndringActionPerformed

    private void jTextFieldDateDageMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTextFieldDateDageMouseClicked
    {//GEN-HEADEREND:event_jTextFieldDateDageMouseClicked
        jTextFieldDateDage.setText("");
    }//GEN-LAST:event_jTextFieldDateDageMouseClicked

    private void jTextFieldDatoMånedMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTextFieldDatoMånedMouseClicked
    {//GEN-HEADEREND:event_jTextFieldDatoMånedMouseClicked
        jTextFieldDatoMåned.setText("");
    }//GEN-LAST:event_jTextFieldDatoMånedMouseClicked

    private void jTextFieldDateÅrMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTextFieldDateÅrMouseClicked
    {//GEN-HEADEREND:event_jTextFieldDateÅrMouseClicked
        jTextFieldDateÅr.setText("");
    }//GEN-LAST:event_jTextFieldDateÅrMouseClicked

    private void jTextFieldÆndringAfVareAntalActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextFieldÆndringAfVareAntalActionPerformed
    {//GEN-HEADEREND:event_jTextFieldÆndringAfVareAntalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldÆndringAfVareAntalActionPerformed

    private void jButtonLavNyVareActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonLavNyVareActionPerformed
    {//GEN-HEADEREND:event_jButtonLavNyVareActionPerformed
        if (!jTextFieldNyVareNavn.getText().equals("")) {
            String vareNavn = jTextFieldNyVareNavn.getText();
            try{
            int vareAntal = Integer.parseInt(jTextFieldNyVareAntal.getText());
            newItem.add(control.creatItem(0, vareNavn, vareAntal));
            control.saveNewItem(newItem);
            newItem.clear();
            visAlleItemListe();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "VareAntal skal være et hel tal");
            }
            jTextFieldNyVareNavn.setText("");
            jTextFieldNyVareAntal.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Husk at skriv et navn");
        }
    }//GEN-LAST:event_jButtonLavNyVareActionPerformed

    private void jTextFieldÆndringAfVareAntalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldÆndringAfVareAntalKeyReleased
        try {
            if (jTextFieldÆndringAfVareAntal.getText() != null) {
                int amount = Integer.parseInt(jTextFieldÆndringAfVareAntal.getText());
            }
        } catch (NumberFormatException ex) {
            jTextFieldÆndringAfVareAntal.setText("");
            JOptionPane.showMessageDialog(null, "Ændring af vare skal være større end 0 og et helt tal");
        }
    }//GEN-LAST:event_jTextFieldÆndringAfVareAntalKeyReleased

    private void jListStatusListeMousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jListStatusListeMousePressed
    {//GEN-HEADEREND:event_jListStatusListeMousePressed
        String ab = "";
        
        for (int i = 0; i < control.getOrderlist().size(); i++) {
            if (control.getOrderlist().get(i).getState()==1){
                         ab = "ja\n";
} else {        
                if (control.getOrderlist().get(i).getState()==2){
                ab ="udløbet\n";
            } else {
                    ab ="nej\n";
                }
            }
            if (control.getOrderlist().get(i).toString().equals(jListStatusListe.getSelectedValue())) {
                jTextOrdreInformationer.setText("Kunde ID: " +control.getOrderlist().get(i).getCustomer().getCustomerID() + "\n"
                        + "Depositum Dato: " + control.getOrderlist().get(i).getDepositumDate() + "\n"
                        +  "Bestillings Dato: " +control.getOrderlist().get(i).getBestillingsDate() + "\n"
                        +  "Depositum modtaget: " + ab        
                        + control.getOrderlist().get(i).getItemlistString());
            }
        }
    }//GEN-LAST:event_jListStatusListeMousePressed

    private void jButtonHentVareListeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonHentVareListeActionPerformed
    {//GEN-HEADEREND:event_jButtonHentVareListeActionPerformed
        Calendar cal = Calendar.getInstance();
        Date date = (Date) cal.getTime();
        String dag = jTextFieldDateDage.getText();
        String måned = jTextFieldDatoMåned.getText();
        String aar = jTextFieldDateÅr.getText();
        String dato = aar + måned + dag;
        DateFormat newDate = new SimpleDateFormat("yyyyMMdd");
        try {
            date = newDate.parse(dato);
            control.loadAllOrders();
            control.loadOrdersWithDate(date);
            visVareliste();
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Husk at skriv en Dato");
        }
    }//GEN-LAST:event_jButtonHentVareListeActionPerformed

    /**
     * @param args the command line arguments
     */
    public void visVareliste() {
        try {
            modelvareliste.clear();
//            control.loadItemliste();
            control.loadAllOrders();
            control.reservedItem();
            control.availableItems();
            vareliste2 = control.getAvailableItems();
            for (int i = 0; i < vareliste2.size(); i++) {
                modelvareliste.addElement(vareliste2.get(i).toStringGUI());
            }
        } catch (NullPointerException ex) {
            System.out.println("Error in GUI - \"visVareListe\"");
        }
    }

    public void visAlleItemListe() {
        try {
            model5.clear();
            alleItemsList = control.loadItemliste();
            for (int i = 0; i < alleItemsList.size(); i++) {
                model5.addElement(alleItemsList.get(i).toStringGUI());
            }
        } catch (NullPointerException ex) {
            System.out.println("Error in GUI - \"visAlleItemListe\"");
        }
    }

//    public boolean varelisteTjek()
//    {
//        ArrayList tjek = control.getAvailableItems();
//        boolean status = false;
//        for (int i = 0; i < tjekListe.size(); i++)
//        {
//            for (int j = 0; j < tjek.size(); j++)
//            {
//                if (control.getAvailableItems().get(j).getItemNo() == tjekListe.get(i).getItemNo())
//                {
//                    if (control.getAvailableItems().get(j).getItemAmount() > tjekListe.get(i).getItemAmount())
//                    {
//                        status = true;
//                    } else
//                    {
//                        status = false;
//                    }
//                }
//            }
//        }
//        return status;
//    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton FjernÆndring;
    private javax.swing.JButton TilføjÆndring;
    private javax.swing.JList VisÆndringer;
    private javax.swing.JButton jButtonBekræftÆndring;
    private javax.swing.JButton jButtonFjernVare;
    private javax.swing.JButton jButtonHentKunder;
    private javax.swing.JButton jButtonHentOrdre;
    private javax.swing.JButton jButtonHentVareListe;
    private javax.swing.JButton jButtonLavNyVare;
    private javax.swing.JButton jButtonOpretKunde;
    private javax.swing.JButton jButtonSaveOrder;
    private javax.swing.JButton jButtonTest;
    private javax.swing.JButton jButtonTilføjvare;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelOrderSavedNotSaved;
    private javax.swing.JList jListStatusListe;
    private javax.swing.JList jListVarePåLagerStatus;
    private javax.swing.JList jListVareTilOrdre;
    private javax.swing.JList jListvareliste;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextAreaVisKunder;
    private javax.swing.JTextField jTextFieldAntalItems;
    private javax.swing.JTextField jTextFieldCustomerNo;
    private javax.swing.JTextField jTextFieldDateDage;
    private javax.swing.JTextField jTextFieldDateÅr;
    private javax.swing.JTextField jTextFieldDatoMåned;
    private javax.swing.JTextField jTextFieldKundeNavn;
    private javax.swing.JTextField jTextFieldNyVareAntal;
    private javax.swing.JTextField jTextFieldNyVareNavn;
    private javax.swing.JTextField jTextFieldTest;
    private javax.swing.JTextField jTextFieldÆndringAfVareAntal;
    private javax.swing.JTextArea jTextOrdreInformationer;
    // End of variables declaration//GEN-END:variables
}
