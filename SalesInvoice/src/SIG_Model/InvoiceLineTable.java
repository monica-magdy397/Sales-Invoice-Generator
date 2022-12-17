//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package SIG_Model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class InvoiceLineTable extends AbstractTableModel {
    private ArrayList<InvoiceLine> linesArr;

    public InvoiceLineTable(ArrayList<InvoiceLine> linesArr) {
        this.linesArr = linesArr;
    }

    public int getRowCount() {
        return this.linesArr == null ? 0 : this.linesArr.size();
    }

    public int getColumnCount() {
        return 5;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceLine Row = (InvoiceLine)this.linesArr.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Row.getHeader().getNumber();
            case 1:
                return Row.getItemName();
            case 2:
                return Row.getPrice();
            case 3:
                return Row.getCount();
            case 4:
                return Row.getTotalLine();
            default:
                return null;
        }
    }

    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "No.";
            case 1:
                return "Item Nme";
            case 2:
                return "Item Price";
            case 3:
                return "Count";
            case 4:
                return "Item Total";
            default:
                return "";
        }
    }
}

