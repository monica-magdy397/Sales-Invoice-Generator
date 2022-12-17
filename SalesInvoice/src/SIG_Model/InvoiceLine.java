//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package SIG_Model;

public class InvoiceLine {
    private InvoiceHeader header;
    private String itemName;
    private double price;
    private int count;

    public InvoiceLine() {
    }

    public InvoiceLine(InvoiceHeader header, String itemName, double price, int count) {
        this.header = header;
        this.itemName = itemName;
        this.price = price;
        this.count = count;
    }

    public InvoiceHeader getHeader() {
        return this.header;
    }

    public void setHeader(InvoiceHeader header) {
        this.header = header;
    }

    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getTotalLine() {
        return (double)this.count * this.price;
    }

    public String toString() {
        return this.header.getNumber() + "," + this.itemName + "," + this.price + "," + this.count;
    }
}
