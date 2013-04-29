package presentation;

import domain.Control;
import domain.Customer;
import domain.Employee;
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
public class GUI extends javax.swing.JFrame
{

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
    ArrayList<Employee> emp = new ArrayList();

    /**
     * Creates new form GUI
     */
    public GUI()
    {
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
        jListVarePåLagerStatus.setModel(model5);
        VisÆndringer.setModel(model6);
        control.loadItemliste();
        control.loadAllOrders();
        control.checkDate();
        control.loadAllEmployees();
        visAlleItemListe();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldEfternavn = new javax.swing.JTextField();
        jButtonOpretKunde = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaVisKunder = new javax.swing.JTextArea();
        jButtonHentKunder = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jTextFieldAdresse = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldNr = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTextFieldPostnr = new javax.swing.JTextField();
        jTextFieldBy = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTextFieldFornavn = new javax.swing.JTextField();
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
        jLabel9 = new javax.swing.JLabel();
        jButtonHentVareListe = new javax.swing.JButton();
        jComboBoxDag = new javax.swing.JComboBox();
        jComboBoxMaaned = new javax.swing.JComboBox();
        jComboBoxAar = new javax.swing.JComboBox();
        jLabelLedigeMontore = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButtonHentOrdre = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListStatusListe = new javax.swing.JList();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextOrdreInformationer = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jCheckBoxBetalt = new javax.swing.JCheckBox();
        jButtonBekaeftBetaling = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jTextFieldAnsatFornavn = new javax.swing.JTextField();
        jTextFieldAnsatEfternavn = new javax.swing.JTextField();
        jButtonOpretAnsat = new javax.swing.JButton();
        jTextFieldAnsatTelefonNo = new javax.swing.JTextField();
        jTextFieldAnsatEmail = new javax.swing.JTextField();
        jTextFieldAnsatAnsatAdresse = new javax.swing.JTextField();
        jTextFieldAnsatPostNo = new javax.swing.JTextField();
        jTextFieldAnsatBy = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jComboBoxStillinger = new javax.swing.JComboBox();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextAreaVisAnsatte = new javax.swing.JTextArea();
        jLabel30 = new javax.swing.JLabel();
        jButtonHentAnsatte = new javax.swing.JButton();
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
        jSeparator2 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldPrice = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel1.setText("Opret ny kunde");

        jButtonOpretKunde.setText("Opret kunde");
        jButtonOpretKunde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOpretKundeActionPerformed(evt);
            }
        });

        jTextAreaVisKunder.setColumns(20);
        jTextAreaVisKunder.setRows(5);
        jScrollPane2.setViewportView(jTextAreaVisKunder);

        jButtonHentKunder.setText("Hent kunde liste");
        jButtonHentKunder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHentKunderActionPerformed(evt);
            }
        });

        jLabel7.setText("Fornavn:");

        jLabel13.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel13.setText("Vis eksisterende kunder");

        jLabel17.setText("Adresse:");

        jLabel18.setText("Email:");

        jLabel19.setText("Telefon nr:");

        jLabel20.setText("Post nr:");

        jLabel21.setText("By:");

        jLabel22.setText("Efternavn:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonOpretKunde, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel18)
                                                .addComponent(jLabel22)
                                                .addComponent(jLabel19))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextFieldEfternavn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextFieldNr, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldFornavn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldBy, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel20)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldPostnr, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(203, 203, 203))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonHentKunder, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldFornavn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jTextFieldAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jTextFieldEfternavn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPostnr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jTextFieldNr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOpretKunde)
                    .addComponent(jLabel18)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonHentKunder)
                .addContainerGap(121, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Opret Kunde", jPanel1);

        jScrollPane1.setViewportView(jListvareliste);

        jTextFieldAntalItems.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldAntalItemsKeyReleased(evt);
            }
        });

        jButtonTilføjvare.setText("Tilføj til ordre");
        jButtonTilføjvare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTilføjvareActionPerformed(evt);
            }
        });
        jButtonTilføjvare.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jButtonTilføjvareKeyReleased(evt);
            }
        });

        jScrollPane3.setViewportView(jListVareTilOrdre);

        jLabel3.setText("Vare liste:");

        jLabel4.setText("Antal vare:");

        jLabel5.setText("Kunde nummer:");

        jLabel6.setText("Vare til ordre:");

        jButtonSaveOrder.setText("Bekræft Ordre");
        jButtonSaveOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveOrderActionPerformed(evt);
            }
        });

        jButtonFjernVare.setText("Fjern fra ordre");
        jButtonFjernVare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFjernVareActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel9.setText("Dato:");

        jButtonHentVareListe.setText("Vælg dato");
        jButtonHentVareListe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHentVareListeActionPerformed(evt);
            }
        });

        jComboBoxDag.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dag", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        jComboBoxMaaned.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Måned", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        jComboBoxAar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "År", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelLedigeMontore, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jTextFieldAntalItems, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonTilføjvare, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jComboBoxDag, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBoxMaaned, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBoxAar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonHentVareListe)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabelOrderSavedNotSaved, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldCustomerNo, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                .addComponent(jButtonFjernVare, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                .addComponent(jButtonSaveOrder, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)))
                        .addGap(82, 82, 82))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonHentVareListe)
                    .addComponent(jComboBoxDag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxMaaned, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxAar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextFieldCustomerNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jButtonTilføjvare))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldAntalItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelLedigeMontore, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonFjernVare)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonSaveOrder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelOrderSavedNotSaved, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Bestilling", jPanel2);

        jButtonHentOrdre.setText("Indlæs alle ordre");
        jButtonHentOrdre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHentOrdreActionPerformed(evt);
            }
        });

        jListStatusListe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jListStatusListeMousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(jListStatusListe);

        jTextOrdreInformationer.setColumns(20);
        jTextOrdreInformationer.setRows(5);
        jScrollPane8.setViewportView(jTextOrdreInformationer);

        jLabel14.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel14.setText("Ordre");

        jLabel16.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel16.setText("Detaljer for valgte ordre");

        jCheckBoxBetalt.setText("Depositum modtaget");

        jButtonBekaeftBetaling.setText("Bekræft");
        jButtonBekaeftBetaling.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBekaeftBetalingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButtonHentOrdre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jCheckBoxBetalt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonBekaeftBetaling, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(177, 177, 177))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(124, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonHentOrdre)
                    .addComponent(jCheckBoxBetalt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonBekaeftBetaling)
                .addGap(63, 63, 63))
        );

        jTabbedPane1.addTab("Status", jPanel3);

        jButtonOpretAnsat.setText("Opret Ansat");
        jButtonOpretAnsat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOpretAnsatActionPerformed(evt);
            }
        });

        jLabel23.setText("By:");

        jLabel24.setText("Post nr:");

        jLabel25.setText("Adresse:");

        jLabel26.setText("Fornavn:");

        jLabel27.setText("Efternavn:");

        jLabel28.setText("Telefon nr:");

        jLabel29.setText("Email:");

        jComboBoxStillinger.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Montør", "Sælger", "Administrator" }));

        jTextAreaVisAnsatte.setColumns(20);
        jTextAreaVisAnsatte.setRows(5);
        jScrollPane5.setViewportView(jTextAreaVisAnsatte);

        jLabel30.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel30.setText("Vis eksisterende ansatte");

        jButtonHentAnsatte.setText("Hent ansatte liste");
        jButtonHentAnsatte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHentAnsatteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jComboBoxStillinger, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel26))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldAnsatFornavn)
                                    .addComponent(jTextFieldAnsatEfternavn)
                                    .addComponent(jTextFieldAnsatTelefonNo)
                                    .addComponent(jTextFieldAnsatEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))))
                        .addGap(95, 95, 95)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonOpretAnsat, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(jTextFieldAnsatAnsatAdresse)
                            .addComponent(jTextFieldAnsatPostNo)
                            .addComponent(jTextFieldAnsatBy)))
                    .addComponent(jLabel30)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButtonHentAnsatte, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxStillinger, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(jTextFieldAnsatAnsatAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(jTextFieldAnsatPostNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(jTextFieldAnsatBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonOpretAnsat))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(jTextFieldAnsatFornavn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(jTextFieldAnsatEfternavn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(jTextFieldAnsatTelefonNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(jTextFieldAnsatEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonHentAnsatte)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Opret Ansat", jPanel5);

        jScrollPane6.setViewportView(jListVarePåLagerStatus);

        jTextFieldÆndringAfVareAntal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldÆndringAfVareAntalActionPerformed(evt);
            }
        });
        jTextFieldÆndringAfVareAntal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldÆndringAfVareAntalKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel8.setText("Lager beholdning");

        jButtonBekræftÆndring.setText("Bekræft");
        jButtonBekræftÆndring.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBekræftÆndringActionPerformed(evt);
            }
        });

        TilføjÆndring.setText("Tilføj");
        TilføjÆndring.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TilføjÆndringActionPerformed(evt);
            }
        });

        FjernÆndring.setText("Fjern");
        FjernÆndring.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FjernÆndringActionPerformed(evt);
            }
        });

        VisÆndringer.setToolTipText("");
        jScrollPane7.setViewportView(VisÆndringer);

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel10.setText("Opret ny vare");

        jLabel11.setText("Vare navn");

        jLabel12.setText("Vare antal");

        jButtonLavNyVare.setText("Opret vare");
        jButtonLavNyVare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLavNyVareActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel15.setText("Ændringer");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jLabel2.setText("Vælg antal");

        jTextFieldPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPriceActionPerformed(evt);
            }
        });

        jLabel31.setText("Vare pris");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(TilføjÆndring, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldÆndringAfVareAntal, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(FjernÆndring, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(71, 71, 71)
                                        .addComponent(jLabel2))))
                            .addComponent(jLabel8)))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jButtonLavNyVare, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addGap(41, 41, 41)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel31)
                                    .addGap(27, 27, 27)
                                    .addComponent(jTextFieldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel12))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextFieldNyVareAntal, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldNyVareNavn, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButtonBekræftÆndring, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                    .addComponent(jLabel15))
                .addGap(47, 47, 47))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(54, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonBekræftÆndring))
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldÆndringAfVareAntal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TilføjÆndring)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FjernÆndring)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jTextFieldNyVareNavn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNyVareAntal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addGap(31, 31, 31)
                .addComponent(jButtonLavNyVare)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Lager Status", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOpretKundeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOpretKundeActionPerformed

        String fornavn = jTextFieldFornavn.getText();
        String efternavn = jTextFieldEfternavn.getText();
        String navn = fornavn + " " + efternavn;
        String adresse = jTextFieldAdresse.getText();
        String postnr = jTextFieldPostnr.getText();
        String by = jTextFieldBy.getText();
        String email = jTextFieldEmail.getText();
        String nr = jTextFieldNr.getText();

        if (navn.contains(" ") && !adresse.equals("") && postnr.length() == 4
                && !by.equals("") && email.contains("@") && nr.length() == 8)
        {
            control.createCustomer(navn, adresse, postnr, by, email, nr);
            control.saveCustomer();
            jTextFieldFornavn.setText("");
            jTextFieldEfternavn.setText("");
            jTextFieldAdresse.setText("");
            jTextFieldPostnr.setText("");
            jTextFieldBy.setText("");
            jTextFieldEmail.setText("");
            jTextFieldNr.setText("");
        } else
        {
            JOptionPane.showMessageDialog(null, "Udfyld alle felter");
        }
    }//GEN-LAST:event_jButtonOpretKundeActionPerformed

    private void jButtonHentKunderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHentKunderActionPerformed

        if (control.loadCustomerlist() != null)
        {
            jTextAreaVisKunder.setText(control.customerToString());
        }


    }//GEN-LAST:event_jButtonHentKunderActionPerformed

    private void jButtonTilføjVareActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonTilføjVareActionPerformed
    {//GEN-HEADEREND:event_jButtonTilføjVareActionPerformed
    }//GEN-LAST:event_jButtonTilføjVareActionPerformed

    private void jButtonSaveOrderActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonSaveOrderActionPerformed
    {//GEN-HEADEREND:event_jButtonSaveOrderActionPerformed
        if (jTextFieldCustomerNo.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Der mangler et kunde nummer");
        } else
        {
            int kundeNo = 0;
            try
            {
                kundeNo = Integer.parseInt(jTextFieldCustomerNo.getText());
            } catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, "KundeNo skal være hel tal");
            }
            Calendar cal = Calendar.getInstance();
            Date date = (Date) cal.getTime();
            String dag = jComboBoxDag.getSelectedItem().toString();
            String måned = jComboBoxMaaned.getSelectedItem().toString();
            String aar = jComboBoxAar.getSelectedItem().toString();
            String dato = aar + måned + dag;
            DateFormat newDate = new SimpleDateFormat("yMd");
            try
            {
                date = newDate.parse(dato);
            } catch (ParseException ex)
            {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            ArrayList<Customer> customerlist = control.loadCustomerlist();
            for (int i = 0; i < customerlist.size(); i++)
            {

                if (customerlist.get(i).getCustomerID() == kundeNo && kundeNo != 0)
                {
                    control.createOrder(orderList, customerlist.get(i), date);
                    modelVareTilOrdre.clear();
                    jTextFieldCustomerNo.setText("");
                }
            }
            try
            {
                if (control.varelisteTjek(orderList) == true)
                {
                    int ordreNummer = control.saveOrder();
                    jLabelOrderSavedNotSaved.setText("Ordre nummer: " + ordreNummer);
                    Employee employee1 = new Employee(emp.get(0).getEmployeeID(), date, ordreNummer);
                    Employee employee2 = new Employee(emp.get(1).getEmployeeID(), date, ordreNummer);
                    control.saveEmployeeWithDate(employee1);
                    control.saveEmployeeWithDate(employee2);
                    visVareliste();
                } else
                {
                    jLabelOrderSavedNotSaved.setText("Ordren blev ikke gemt");
                    visVareliste();
                }
            } catch (SQLException ex)
            {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            orderList.clear();
        }
    }//GEN-LAST:event_jButtonSaveOrderActionPerformed

    private void jButtonTilføjvareActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonTilføjvareActionPerformed
    {//GEN-HEADEREND:event_jButtonTilføjvareActionPerformed
        try
        {
            int amount2 = Integer.parseInt(jTextFieldAntalItems.getText());
            boolean add = false;
            for (int i = 0; i < vareliste2.size(); i++)
            {
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
                            orderList.add(new Item(item.getItemNo(), item.getItemName(), item.getItemAmount(), item.getPrice()));
                        }
                        modelVareTilOrdre.clear();
                        for (int j = 0; j < orderList.size(); j++)
                        {
                            modelVareTilOrdre.addElement(orderList.get(j).toStringGUIReserved());
                            jTextFieldAntalItems.setText("");
                        }
                        item2.setItemAmount(amount3);
                        modelvareliste.clear();
                        for (int g = 0; g < vareliste2.size(); g++)
                        {
                            modelvareliste.addElement(vareliste2.get(g).toStringGUI());
                        }

                    } else
                    {
                        JOptionPane.showMessageDialog(null, "Antal Vare er for stort i forhold til det antal der er på lager");
                        break;
                    }
                }

            }
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Husk at skrive antal");
        }
    }//GEN-LAST:event_jButtonTilføjvareActionPerformed

    private void jButtonFjernVareActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonFjernVareActionPerformed
    {//GEN-HEADEREND:event_jButtonFjernVareActionPerformed
        System.out.println("hej");
        int a = modelVareTilOrdre.size();
        for (int i = 0; i < modelVareTilOrdre.size(); i++)
        {
            try
            {
                if (jListVareTilOrdre.getSelectedValue().equals(modelVareTilOrdre.elementAt(i)))
                {
                    modelvareliste.clear();
                    for (int g = 0; g < vareliste2.size(); g++)
                    {
                        if (orderList.get(i).getItemNo() == vareliste2.get(g).getItemNo())
                        {
                            vareliste2.get(g).setItemAmount(vareliste2.get(g).getItemAmount() + orderList.get(i).getItemAmount());
                        }
                        modelvareliste.addElement(vareliste2.get(g).toStringGUI());
                        modelVareTilOrdre.removeElement(jListVareTilOrdre.getSelectedValue());
                    }
                    orderList.remove(i);
                }
            } catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, "Husk at vælge en vare at fjerne");
            }
        }
        if (a == 0)
        {
            JOptionPane.showMessageDialog(null, "Husk at hente Liste før du prøve at fjerne en vare");
        }
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

    private void jButtonHentOrdreActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonHentOrdreActionPerformed
    {//GEN-HEADEREND:event_jButtonHentOrdreActionPerformed
        StatusListe.clear();
        for (int i = 0; i < control.getOrderlist().size(); i++)
        {
            StatusListe.addElement(control.getOrderlist().get(i).toString());
        }
       
          
       
    }//GEN-LAST:event_jButtonHentOrdreActionPerformed

    private void jButtonBekræftÆndringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBekræftÆndringActionPerformed
        if (!it.isEmpty())
        {
            control.increaseAmount(it);
            visAlleItemListe();
            visVareliste();
            for (int i = 0; i < control.getItemList().size(); i++)
            {
                if (control.getItemList().get(i).getItemAmount() == 0)
                {
                    control.deleteItem(control.getItemList().get(i));
                    visAlleItemListe();
                    visVareliste();
                    if (i > control.getItemList().size())
                    {
                        break;
                    }
                }
            }
            model6.removeAllElements();

        } else
        {
            JOptionPane.showMessageDialog(null, "Husk at tilføj/fjern før du kan bekræftte");
        }

    }//GEN-LAST:event_jButtonBekræftÆndringActionPerformed

    private void FjernÆndringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FjernÆndringActionPerformed
        int plads = 0;
        if (jListVarePåLagerStatus.getSelectedValue() != null)
        {
            int antal = Integer.parseInt(jTextFieldÆndringAfVareAntal.getText());
            String selected = jListVarePåLagerStatus.getSelectedValue().toString();
            for (int i = 0; i < alleItemsList.size(); i++)
            {
                if (alleItemsList.get(i).toStringGUI().equals(selected))
                {
                    if (antal <= alleItemsList.get(i).getItemAmount())
                    {
                        Item v = alleItemsList.get(i);
                        v.setAmountTotal(v.getItemAmount() - antal);
                        it.add(v);
                        jTextFieldÆndringAfVareAntal.setText("");
                        visVareliste();
                        visAlleItemListe();
                        model6.add(plads, "Fjern af: " + v.getItemName() + " Antal: " + antal);
                        plads++;
                    }
                }
            }
        } else
        {
            JOptionPane.showMessageDialog(null, "Husk at vælge en vare");
        }
    }//GEN-LAST:event_FjernÆndringActionPerformed

    private void TilføjÆndringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TilføjÆndringActionPerformed
        int plads = 0;
        if (jListVarePåLagerStatus.getSelectedValue() != null)
        {
            int antal = Integer.parseInt(jTextFieldÆndringAfVareAntal.getText());
            String selected = jListVarePåLagerStatus.getSelectedValue().toString();
            for (int i = 0; i < alleItemsList.size(); i++)
            {
                if (alleItemsList.get(i).toStringGUI().equals(selected))
                {
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
        } else
        {
            JOptionPane.showMessageDialog(null, "Husk at vælge en vare");
        }

    }//GEN-LAST:event_TilføjÆndringActionPerformed

    private void jTextFieldÆndringAfVareAntalActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextFieldÆndringAfVareAntalActionPerformed
    {//GEN-HEADEREND:event_jTextFieldÆndringAfVareAntalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldÆndringAfVareAntalActionPerformed

    private void jButtonLavNyVareActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonLavNyVareActionPerformed
    {//GEN-HEADEREND:event_jButtonLavNyVareActionPerformed
        if (!jTextFieldNyVareNavn.getText().equals(""))
        {
            String vareNavn = jTextFieldNyVareNavn.getText();
            try
            {
                int vareAntal = Integer.parseInt(jTextFieldNyVareAntal.getText());
                int price = Integer.parseInt(jTextFieldPrice.getText());
                newItem.add(control.creatItem(0, vareNavn, vareAntal, price));
                control.saveNewItem(newItem);
                newItem.clear();
                visAlleItemListe();
            } catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, "VareAntal skal være et hel tal");
            }
            jTextFieldNyVareNavn.setText("");
            jTextFieldNyVareAntal.setText("");
            jTextFieldPrice.setText("");
        } else
        {
            JOptionPane.showMessageDialog(null, "Husk at skriv et navn");
        }
    }//GEN-LAST:event_jButtonLavNyVareActionPerformed

    private void jTextFieldÆndringAfVareAntalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldÆndringAfVareAntalKeyReleased
        try
        {
            if (jTextFieldÆndringAfVareAntal.getText() != null)
            {
                int amount = Integer.parseInt(jTextFieldÆndringAfVareAntal.getText());
            }
        } catch (NumberFormatException ex)
        {
            jTextFieldÆndringAfVareAntal.setText("");
            JOptionPane.showMessageDialog(null, "Ændring af vare skal være større end 0 og et helt tal");
        }
    }//GEN-LAST:event_jTextFieldÆndringAfVareAntalKeyReleased

    private void jListStatusListeMousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jListStatusListeMousePressed
    {//GEN-HEADEREND:event_jListStatusListeMousePressed
        String ab = "";

        for (int i = 0; i < control.getOrderlist().size(); i++)
        {
            if (control.getOrderlist().get(i).getState() == 1)
            {
                ab = "ja\n";
            } else
            {
                if (control.getOrderlist().get(i).getState() == 2)
                {
                    ab = "udløbet\n";
                } else
                {
                    ab = "nej\n";
                }
            }
            if (control.getOrderlist().get(i).toString().equals(jListStatusListe.getSelectedValue()))
            {
                jTextOrdreInformationer.setText("Kunde ID: " + control.getOrderlist().get(i).getCustomer().getCustomerID() + "\n"
                        + "Depositum Dato: " + control.getOrderlist().get(i).getDepositumDate() + "\n"
                        + "Bestillings Dato: " + control.getOrderlist().get(i).getBestillingsDate() + "\n"
                        + "Depositum modtaget: " + ab
                        + "Depositum beløb: " + control.getOrderlist().get(i).getDepositumPrice()
                        + control.getOrderlist().get(i).getItemlistString());
            }
        }
    }//GEN-LAST:event_jListStatusListeMousePressed

    private void jButtonHentVareListeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonHentVareListeActionPerformed
    {//GEN-HEADEREND:event_jButtonHentVareListeActionPerformed
//        Calendar cal = Calendar.getInstance();
        Date date;
        String dag = jComboBoxDag.getSelectedItem().toString();
        String måned = jComboBoxMaaned.getSelectedItem().toString();
        String aar = jComboBoxAar.getSelectedItem().toString();
        String dato = aar + måned + dag;
        DateFormat newDate = new SimpleDateFormat("yyyyMMdd");
//        ArrayList<Employee> emp = new ArrayList();
        try
        {
            date = newDate.parse(dato);
            emp = control.checkEmployee(date);
            
            jLabelLedigeMontore.setText("Der er " + emp.size() + " Montøre ledige");
            control.loadOrdersWithDate(date);
            visVareliste();
        } catch (ParseException ex)
        {
            JOptionPane.showMessageDialog(null, "Husk at skriv en Dato");
        }
    }//GEN-LAST:event_jButtonHentVareListeActionPerformed

    private void jButtonBekaeftBetalingActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonBekaeftBetalingActionPerformed
    {//GEN-HEADEREND:event_jButtonBekaeftBetalingActionPerformed
        if (jCheckBoxBetalt.isSelected())
        {
            for (int i = 0; i < control.getOrderlist().size(); i++)
            {
                if (jListStatusListe.getSelectedValue().toString().equals(control.getOrderlist().get(i).toString()))
                {
                    control.getOrderlist().get(i).setState(1);
                    control.updateOrder(control.getOrderlist().get(i));
                    StatusListe.clear();
                    jTextOrdreInformationer.setText("");
                    jCheckBoxBetalt.setSelected(false);
                    for (int j = 0; j < control.getOrderlist().size(); j++)
                    {
                        StatusListe.addElement(control.getOrderlist().get(j).toString());
                    }
                    break;

                }
            }
        }
    }//GEN-LAST:event_jButtonBekaeftBetalingActionPerformed

    private void jButtonOpretAnsatActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonOpretAnsatActionPerformed
    {//GEN-HEADEREND:event_jButtonOpretAnsatActionPerformed
        String stilling = jComboBoxStillinger.getSelectedItem().toString();
        String navn = jTextFieldAnsatFornavn.getText() + " " + jTextFieldAnsatEfternavn.getText();
        String telefonNo = jTextFieldAnsatTelefonNo.getText();
        String email = jTextFieldAnsatEmail.getText();
        String adresse = jTextFieldAnsatAnsatAdresse.getText();
        String postNo = jTextFieldAnsatPostNo.getText();
        String by = jTextFieldAnsatBy.getText();

        if (navn.contains(" ") && !adresse.equals("") && postNo.length() == 4
                && !by.equals("") && email.contains("@") && telefonNo.length() == 8)
        {
            control.createEmployee(navn, stilling, telefonNo, email, postNo, by, adresse);
            control.saveEmployee();
            jTextFieldAnsatFornavn.setText("");
            jTextFieldAnsatEfternavn.setText("");
            jTextFieldAnsatAnsatAdresse.setText("");
            jTextFieldAnsatPostNo.setText("");
            jTextFieldAnsatBy.setText("");
            jTextFieldAnsatEmail.setText("");
            jTextFieldAnsatTelefonNo.setText("");
        } else
        {
            JOptionPane.showMessageDialog(null, "Udfyld alle felter");
        }
    }//GEN-LAST:event_jButtonOpretAnsatActionPerformed

    private void jButtonHentAnsatteActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonHentAnsatteActionPerformed
    {//GEN-HEADEREND:event_jButtonHentAnsatteActionPerformed
         if (control.loadAllEmployees() != null)
        {
            jTextAreaVisAnsatte.setText(control.employeeToString());
        }
    }//GEN-LAST:event_jButtonHentAnsatteActionPerformed

    private void jTextFieldPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPriceActionPerformed

    /**
     * @param args the command line arguments
     */
    public void visVareliste()
    {
        try
        {
            modelvareliste.clear();
            vareliste2 = control.getAvailableItems();
            for (int i = 0; i < vareliste2.size(); i++)
            {
                modelvareliste.addElement(vareliste2.get(i).toStringGUI());
            }
        } catch (NullPointerException ex)
        {
            System.out.println("Error in GUI - \"visVareListe\"");
        }
    }

    public void visAlleItemListe()
    {
        try
        {
            model5.clear();
            alleItemsList = control.loadItemliste();
            for (int i = 0; i < alleItemsList.size(); i++)
            {
                model5.addElement(alleItemsList.get(i).toStringGUI());
            }
        } catch (NullPointerException ex)
        {
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
    private javax.swing.JButton FjernÆndring;
    private javax.swing.JButton TilføjÆndring;
    private javax.swing.JList VisÆndringer;
    private javax.swing.JButton jButtonBekaeftBetaling;
    private javax.swing.JButton jButtonBekræftÆndring;
    private javax.swing.JButton jButtonFjernVare;
    private javax.swing.JButton jButtonHentAnsatte;
    private javax.swing.JButton jButtonHentKunder;
    private javax.swing.JButton jButtonHentOrdre;
    private javax.swing.JButton jButtonHentVareListe;
    private javax.swing.JButton jButtonLavNyVare;
    private javax.swing.JButton jButtonOpretAnsat;
    private javax.swing.JButton jButtonOpretKunde;
    private javax.swing.JButton jButtonSaveOrder;
    private javax.swing.JButton jButtonTilføjvare;
    private javax.swing.JCheckBox jCheckBoxBetalt;
    private javax.swing.JComboBox jComboBoxAar;
    private javax.swing.JComboBox jComboBoxDag;
    private javax.swing.JComboBox jComboBoxMaaned;
    private javax.swing.JComboBox jComboBoxStillinger;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelLedigeMontore;
    private javax.swing.JLabel jLabelOrderSavedNotSaved;
    private javax.swing.JList jListStatusListe;
    private javax.swing.JList jListVarePåLagerStatus;
    private javax.swing.JList jListVareTilOrdre;
    private javax.swing.JList jListvareliste;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextAreaVisAnsatte;
    private javax.swing.JTextArea jTextAreaVisKunder;
    private javax.swing.JTextField jTextFieldAdresse;
    private javax.swing.JTextField jTextFieldAnsatAnsatAdresse;
    private javax.swing.JTextField jTextFieldAnsatBy;
    private javax.swing.JTextField jTextFieldAnsatEfternavn;
    private javax.swing.JTextField jTextFieldAnsatEmail;
    private javax.swing.JTextField jTextFieldAnsatFornavn;
    private javax.swing.JTextField jTextFieldAnsatPostNo;
    private javax.swing.JTextField jTextFieldAnsatTelefonNo;
    private javax.swing.JTextField jTextFieldAntalItems;
    private javax.swing.JTextField jTextFieldBy;
    private javax.swing.JTextField jTextFieldCustomerNo;
    private javax.swing.JTextField jTextFieldEfternavn;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldFornavn;
    private javax.swing.JTextField jTextFieldNr;
    private javax.swing.JTextField jTextFieldNyVareAntal;
    private javax.swing.JTextField jTextFieldNyVareNavn;
    private javax.swing.JTextField jTextFieldPostnr;
    private javax.swing.JTextField jTextFieldPrice;
    private javax.swing.JTextField jTextFieldÆndringAfVareAntal;
    private javax.swing.JTextArea jTextOrdreInformationer;
    // End of variables declaration//GEN-END:variables
}
