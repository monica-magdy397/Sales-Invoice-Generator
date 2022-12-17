package SIG_Controller;

import SIG_Design.SIG_Frame;
import SIG_Model.InvoiceHeader;
import SIG_Model.InvoiceLine;
import SIG_Model.InvoiceLineTable;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SelectListenerForTable implements ListSelectionListener {
    private SIG_Frame frame;

    public SelectListenerForTable(SIG_Frame frame) {
        this.frame = frame;
    }

    public void valueChanged(ListSelectionEvent e) {
        int indexOfSelectedRow = this.frame.getjTable_Invoice().getSelectedRow();
        System.out.println("Invoice you selected is : " + indexOfSelectedRow);
        if (indexOfSelectedRow != -1) {
            InvoiceHeader selectedRow = (InvoiceHeader)this.frame.getInvoicesArr().get(indexOfSelectedRow);
            ArrayList<InvoiceLine> lines = selectedRow.getLines();
            InvoiceLineTable lineTable = new InvoiceLineTable(lines);
            this.frame.setLinesArr(lines);
            this.frame.getjTable_Items().setModel(lineTable);
            this.frame.getjTextField_CustomerName().setText(selectedRow.getCustomerName());
            this.frame.getjLabel_InvoiceNumber().setText(selectedRow.getNumber() + "");
            this.frame.getjLabel_InvoiceTotal().setText(selectedRow.getTotalInvoice() + "");
            this.frame.getjTextField_InvoiceDate().setText(SIG_Frame.date.format(selectedRow.getDate()));
        }

    }

    private void getLines() {
    }
}