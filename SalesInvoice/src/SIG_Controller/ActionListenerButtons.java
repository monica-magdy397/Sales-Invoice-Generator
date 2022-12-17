//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package SIG_Controller;

import SIG_Design.DialogForHeader;
import SIG_Design.DialogForLine;
import SIG_Design.SIG_Frame;
import SIG_Model.InvoiceHeader;
import SIG_Model.InvoiceLine;
import SIG_Model.InvoiceLineTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JOptionPane;

public class ActionListenerBtns implements ActionListener {
    private SIG_Frame frame;
    private DialogForHeader dialogForHeader;
    private DialogForLine dialogForLine;

    public ActionListenerBtns(SIG_Frame frame) {
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Create Invoice":
                this.CreateNewInvoice();
                break;
            case "Delete Invoice":
                this.DeleteInvoice();
                break;
            case "Add Item":
                this.Save();
                break;
            case "Delete Item":
                this.Cancel();
                break;
            case "OkCreatNewInvoice":
                this.OkCreatNewInvoice();
                break;
            case "CancelNewInvoice":
                this.CancelNewInvoice();
                break;
            case "OkCreatNewLine":
                this.OkCreateNewLine();
                break;
            case "CancelNewLine":
                this.CancelNewLine();
        }

    }

    private void CreateNewInvoice() {
        this.dialogForHeader = new DialogForHeader(this.frame);
        this.dialogForHeader.setVisible(true);
    }

    private void DeleteInvoice() {
        int indexOfSelectedRow = this.frame.getjTable_Invoice().getSelectedRow();
        if (indexOfSelectedRow != -1) {
            this.frame.getInvoicesArr().remove(indexOfSelectedRow);
            this.frame.getHeaderTable().fireTableDataChanged();
            this.frame.getjTable_Items().setModel(new InvoiceLineTable((ArrayList)null));
            this.frame.setLinesArr((ArrayList)null);
            this.frame.getjTextField_CustomerName().setText("");
            this.frame.getjLabel_InvoiceNumber().setText("");
            this.frame.getjLabel_InvoiceTotal().setText("");
            this.frame.getjTextField_InvoiceDate().setText("");
            this.printInvoices();
        }

    }

    private void Save() {
        this.dialogForLine = new DialogForLine(this.frame);
        this.dialogForLine.setVisible(true);
    }

    private void Cancel() {
        int indexOfSelectedRow = this.frame.getjTable_Items().getSelectedRow();
        int indexOfSelectedRowHeader = this.frame.getjTable_Invoice().getSelectedRow();
        if (indexOfSelectedRow != -1) {
            this.frame.getLinesArr().remove(indexOfSelectedRow);
            InvoiceLineTable lineTable = (InvoiceLineTable)this.frame.getjTable_Items().getModel();
            lineTable.fireTableDataChanged();
            this.frame.getHeaderTable().fireTableDataChanged();
            InvoiceHeader h = (InvoiceHeader)this.frame.getInvoicesArr().get(indexOfSelectedRow);
            this.frame.getjLabel_InvoiceTotal().setText(h.getTotalInvoice() + "");
        }

        this.frame.getjTable_Invoice().setRowSelectionInterval(indexOfSelectedRowHeader, indexOfSelectedRowHeader);
        this.printInvoices();
    }

    private void OkCreatNewInvoice() {
        this.dialogForHeader.setVisible(false);
        String S1 = this.dialogForHeader.getJTextFieldCustomerName().getText();
        String S2 = this.dialogForHeader.getJTextFieldInvoiceDate().getText();
        Date date = new Date();

        try {
            date = SIG_Frame.date.parse(S2);
        } catch (ParseException var7) {
            JOptionPane.showMessageDialog(this.frame, "Can't parse date", "Wrong Date Format", 0);
        }

        int num = 0;
        Iterator var5 = this.frame.getInvoicesArr().iterator();

        while(var5.hasNext()) {
            InvoiceHeader header = (InvoiceHeader)var5.next();
            if (header.getNumber() > num) {
                num = header.getNumber();
            }
        }

        ++num;
        InvoiceHeader newheader = new InvoiceHeader(num, date, S1);
        this.frame.getInvoicesArr().add(newheader);
        this.frame.getHeaderTable().fireTableDataChanged();
        this.dialogForHeader.dispose();
        this.dialogForHeader = null;
        this.printInvoices();
    }

    private void CancelNewInvoice() {
        this.dialogForHeader.setVisible(false);
        this.dialogForHeader.dispose();
        this.dialogForHeader = null;
    }

    private void OkCreateNewLine() {
        this.dialogForLine.setVisible(false);
        String s1 = this.dialogForLine.getJTextFielditemName().getText();
        String s2 = this.dialogForLine.getJTextFielditemCount().getText();
        String s3 = this.dialogForLine.getItemPriceField().getText();
        int count = 1;
        double price = 1.0;

        try {
            count = Integer.parseInt(s2);
        } catch (NumberFormatException var12) {
            JOptionPane.showMessageDialog(this.frame, "Enter valid Count ", "Invalid number format", 0);
        }

        try {
            price = Double.parseDouble(s3);
        } catch (NumberFormatException var11) {
            JOptionPane.showMessageDialog(this.frame, "Enter valid price", "Invalid number format", 0);
        }

        int indexOfSelectedRow = this.frame.getjTable_Invoice().getSelectedRow();
        if (indexOfSelectedRow != -1) {
            InvoiceHeader h = (InvoiceHeader)this.frame.getInvoicesArr().get(indexOfSelectedRow);
            InvoiceLine newline = new InvoiceLine(h, s1, price, count);
            this.frame.getLinesArr().add(newline);
            InvoiceLineTable lineTable = (InvoiceLineTable)this.frame.getjTable_Items().getModel();
            lineTable.fireTableDataChanged();
            this.frame.getHeaderTable().fireTableDataChanged();
            this.frame.getjLabel_InvoiceTotal().setText(h.getTotalInvoice() + "");
        }

        this.frame.getjTable_Invoice().setRowSelectionInterval(indexOfSelectedRow, indexOfSelectedRow);
        this.dialogForLine.dispose();
        this.dialogForLine = null;
        this.printInvoices();
    }

    private void CancelNewLine() {
        this.dialogForLine.setVisible(false);
        this.dialogForLine.dispose();
        this.dialogForLine = null;
    }

    private void printInvoices() {
        System.out.println("*****************");
        Iterator var1 = this.frame.getInvoicesArr().iterator();

        while(var1.hasNext()) {
            InvoiceHeader header = (InvoiceHeader)var1.next();
            System.out.println(header);
        }

        System.out.println("*****************");
    }
}
