//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package SIG_Design;

import SIG_Controller.ActionListenerBtns;
import SIG_Controller.ActionListenerMenuItems;
import SIG_Controller.SelectListenerForTable;
import SIG_Model.InvoiceHeader;
import SIG_Model.InvoiceHeaderTable;
import SIG_Model.InvoiceLine;
import SIG_Model.InvoiceLineTable;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class SIG_Frame extends JFrame {
    private JButton jButton_Cancle;
    private JButton jButton_Create;
    private JButton jButton_Delete;
    private JButton jButton_Save;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel_CustomerName;
    private JLabel jLabel_InDate;
    private JLabel jLabel_InNumber;
    private JLabel jLabel_InTotal;
    private JLabel jLabel_InvoiceNumber;
    private JLabel jLabel_InvoiceTotal;
    private JMenu jMenu1;
    private JMenuBar jMenuBar1;
    private JMenuItem jMenuIteamLoadFile;
    private JMenuItem jMenuItemSavveFile;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JTable jTable2;
    private JTable jTable_Invoice;
    private JTable jTable_Items;
    private JTextField jTextField_CustomerName;
    private JTextField jTextField_InvoiceDate;
    private ActionListenerBtns listenerBtns = new ActionListenerBtns(this);
    private ActionListenerMenuItems listenerMenuItems = new ActionListenerMenuItems(this);
    private ArrayList<InvoiceHeader> invoicesArr;
    private InvoiceHeaderTable headerTable;
    public static SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
    private SelectListenerForTable selectListenerForTable = new SelectListenerForTable(this);
    private ArrayList<InvoiceLine> linesArr;
    private InvoiceLineTable lineTable;

    public SIG_Frame() {
        this.initComponents();
    }

    private void initComponents() {
        this.jScrollPane2 = new JScrollPane();
        this.jTable2 = new JTable();
        this.jScrollPane1 = new JScrollPane();
        this.jTable_Invoice = new JTable();
        this.jScrollPane3 = new JScrollPane();
        this.jTable_Items = new JTable();
        this.jButton_Create = new JButton();
        this.jButton_Create.addActionListener(this.listenerBtns);
        this.jButton_Delete = new JButton();
        this.jButton_Delete.addActionListener(this.listenerBtns);
        this.jButton_Save = new JButton();
        this.jButton_Save.addActionListener(this.listenerBtns);
        this.jButton_Cancle = new JButton();
        this.jButton_Cancle.addActionListener(this.listenerBtns);
        this.jLabel_InNumber = new JLabel();
        this.jLabel_InDate = new JLabel();
        this.jLabel_CustomerName = new JLabel();
        this.jLabel_InTotal = new JLabel();
        this.jTextField_InvoiceDate = new JTextField();
        this.jTextField_CustomerName = new JTextField();
        this.jLabel_InvoiceNumber = new JLabel();
        this.jLabel_InvoiceTotal = new JLabel();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.jMenuBar1 = new JMenuBar();
        this.jMenu1 = new JMenu();
        this.jMenuIteamLoadFile = new JMenuItem();
        this.jMenuItemSavveFile = new JMenuItem();
        this.jTable2.setModel(new DefaultTableModel(new Object[][]{{null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}}, new String[]{"Title 1", "Title 2", "Title 3", "Title 4"}));
        this.jScrollPane2.setViewportView(this.jTable2);
        this.setDefaultCloseOperation(3);
        this.setPreferredSize(new Dimension(800, 550));
        this.setSize(new Dimension(800, 550));
        this.getContentPane().setLayout(new AbsoluteLayout());
        this.jTable_Invoice.getSelectionModel().addListSelectionListener(this.selectListenerForTable);
        this.jScrollPane1.setViewportView(this.jTable_Invoice);
        this.getContentPane().add(this.jScrollPane1, new AbsoluteConstraints(18, 43, 350, 390));
        this.jTable_Items.setModel(new DefaultTableModel(new Object[0][], new String[0]));
        this.jScrollPane3.setViewportView(this.jTable_Items);
        this.getContentPane().add(this.jScrollPane3, new AbsoluteConstraints(390, 180, 350, 250));
        this.jButton_Create.setText("Create New Invoice");
        this.jButton_Create.addActionListener(new 1(this));
        this.getContentPane().add(this.jButton_Create, new AbsoluteConstraints(20, 450, -1, -1));
        this.jButton_Delete.setText("Delete Invoice");
        this.jButton_Delete.addActionListener(new 2(this));
        this.getContentPane().add(this.jButton_Delete, new AbsoluteConstraints(240, 450, -1, -1));
        this.jButton_Save.setText("Save");
        this.getContentPane().add(this.jButton_Save, new AbsoluteConstraints(420, 450, -1, -1));
        this.jButton_Cancle.setText("Cancel");
        this.getContentPane().add(this.jButton_Cancle, new AbsoluteConstraints(650, 450, -1, -1));
        this.jLabel_InNumber.setText("Invoice Number");
        this.getContentPane().add(this.jLabel_InNumber, new AbsoluteConstraints(390, 20, 88, -1));
        this.jLabel_InDate.setText("Invoice Date");
        this.getContentPane().add(this.jLabel_InDate, new AbsoluteConstraints(390, 50, 88, -1));
        this.jLabel_CustomerName.setText("Customer Name");
        this.getContentPane().add(this.jLabel_CustomerName, new AbsoluteConstraints(390, 80, 88, -1));
        this.jLabel_InTotal.setText("Invoice Total");
        this.getContentPane().add(this.jLabel_InTotal, new AbsoluteConstraints(390, 110, 110, -1));
        this.getContentPane().add(this.jTextField_InvoiceDate, new AbsoluteConstraints(500, 50, 176, -1));
        this.getContentPane().add(this.jTextField_CustomerName, new AbsoluteConstraints(500, 80, 196, -1));
        this.getContentPane().add(this.jLabel_InvoiceNumber, new AbsoluteConstraints(500, 20, 48, -1));
        this.getContentPane().add(this.jLabel_InvoiceTotal, new AbsoluteConstraints(500, 110, 44, -1));
        this.jLabel1.setText("Invoices Table");
        this.getContentPane().add(this.jLabel1, new AbsoluteConstraints(20, 10, 94, 32));
        this.jLabel2.setText("Invoices Items");
        this.getContentPane().add(this.jLabel2, new AbsoluteConstraints(390, 140, 94, 32));
        this.jMenu1.setText("File");
        this.jMenuIteamLoadFile.setText("Load File");
        this.jMenuIteamLoadFile.addActionListener(this.listenerMenuItems);
        this.jMenu1.add(this.jMenuIteamLoadFile);
        this.jMenuItemSavveFile.setText("Save File");
        this.jMenuItemSavveFile.addActionListener(this.listenerMenuItems);
        this.jMenuItemSavveFile.addActionListener(new 3(this));
        this.jMenu1.add(this.jMenuItemSavveFile);
        this.jMenuBar1.add(this.jMenu1);
        this.setJMenuBar(this.jMenuBar1);
        this.pack();
    }

    private void jButton_CreateActionPerformed(ActionEvent evt) {
    }

    private void jButton_DeleteActionPerformed(ActionEvent evt) {
    }

    private void jMenuItemSavveFileActionPerformed(ActionEvent evt) {
    }

    public static void main(String[] args) {
        try {
            UIManager.LookAndFeelInfo[] var1 = UIManager.getInstalledLookAndFeels();
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                UIManager.LookAndFeelInfo info = var1[var3];
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException var5) {
            Logger.getLogger(SIG_Frame.class.getName()).log(Level.SEVERE, (String)null, var5);
        } catch (InstantiationException var6) {
            Logger.getLogger(SIG_Frame.class.getName()).log(Level.SEVERE, (String)null, var6);
        } catch (IllegalAccessException var7) {
            Logger.getLogger(SIG_Frame.class.getName()).log(Level.SEVERE, (String)null, var7);
        } catch (UnsupportedLookAndFeelException var8) {
            Logger.getLogger(SIG_Frame.class.getName()).log(Level.SEVERE, (String)null, var8);
        }

        EventQueue.invokeLater(new 4());
    }

    public InvoiceLineTable getLineTable() {
        return this.lineTable;
    }

    public void setLineTable(InvoiceLineTable lineTable) {
        this.lineTable = lineTable;
    }

    public ArrayList<InvoiceLine> getLinesArr() {
        return this.linesArr;
    }

    public void setLinesArr(ArrayList<InvoiceLine> linesArr) {
        this.linesArr = linesArr;
    }

    public void setInvoicesArr(ArrayList<InvoiceHeader> invoicesArr) {
        this.invoicesArr = invoicesArr;
    }

    public ArrayList<InvoiceHeader> getInvoicesArr() {
        return this.invoicesArr;
    }

    public InvoiceHeader getInvoiceHeaderObject(int code) {
        Iterator var2 = this.invoicesArr.iterator();

        InvoiceHeader InvoiceHeaderObject;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            InvoiceHeaderObject = (InvoiceHeader)var2.next();
        } while(InvoiceHeaderObject.getNumber() != code);

        return InvoiceHeaderObject;
    }

    public InvoiceHeaderTable getHeaderTable() {
        return this.headerTable;
    }

    public void setHeaderTable(InvoiceHeaderTable headerTable) {
        this.headerTable = headerTable;
    }

    public JTable getjTable_Invoice() {
        return this.jTable_Invoice;
    }

    public JTable getjTable_Items() {
        return this.jTable_Items;
    }

    public JTextField getjTextField_CustomerName() {
        return this.jTextField_CustomerName;
    }

    public JTextField getjTextField_InvoiceDate() {
        return this.jTextField_InvoiceDate;
    }

    public JLabel getjLabel_InvoiceNumber() {
        return this.jLabel_InvoiceNumber;
    }

    public JLabel getjLabel_InvoiceTotal() {
        return this.jLabel_InvoiceTotal;
    }

    public ActionListenerBtns getListenerBtns() {
        return this.listenerBtns;
    }
}

