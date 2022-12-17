//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package SIG_Model;

import SIG_Design.SIG_Frame;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class InvoiceHeaderTable extends AbstractTableModel {
    private ArrayList<InvoiceHeader> invoicesArr;

    public InvoiceHeaderTable(ArrayList<InvoiceHeader> invoicesArr) {
        this.invoicesArr = invoicesArr;
    }

    public int getRowCount() {
        return this.invoicesArr.size();
    }

    public int getColumnCount() {
        return 4;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceHeader invoiceHeader = (InvoiceHeader)this.invoicesArr.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return invoiceHeader.getNumber();
            case 1:
                return SIG_Frame.date.format(invoiceHeader.getDate());
            case 2:
                return invoiceHeader.getCustomerName();
            case 3:
                return invoiceHeader.getTotalInvoice();
            default:
                return null;
        }
    }

    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "No.";
            case 1:
                return "Date";
            case 2:
                return "Costumer";
            case 3:
                return "Total";
            default:
                return "";
        }
    }
}
