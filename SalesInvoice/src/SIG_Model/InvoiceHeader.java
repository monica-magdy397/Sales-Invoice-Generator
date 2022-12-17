//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package SIG_Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class InvoiceHeader {
    private int number;
    private Date date;
    private String customerName;
    private ArrayList<InvoiceLine> lines;
    private DateFormat d = new SimpleDateFormat("dd-MM-yyyy");

    public InvoiceHeader() {
    }

    public InvoiceHeader(int number, Date date, String customerName) {
        this.number = number;
        this.date = date;
        this.customerName = customerName;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public ArrayList<InvoiceLine> getLines() {
        if (this.lines == null) {
            this.lines = new ArrayList();
        }

        return this.lines;
    }

    public void setLines(ArrayList<InvoiceLine> lines) {
        this.lines = lines;
    }

    public double getTotalInvoice() {
        double total = 0.0;

        for(int i = 0; i < this.getLines().size(); ++i) {
            total += ((InvoiceLine)this.lines.get(i)).getTotalLine();
        }

        return total;
    }

    public String toString() {
        return this.number + "," + this.d.format(this.date) + "," + this.customerName;
    }
}
