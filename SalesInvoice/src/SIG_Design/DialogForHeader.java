//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package SIG_Design;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DialogForHeader extends JDialog {
    private JTextField JTextFieldCustomerName = new JTextField(25);
    private JTextField JTextFieldInvoiceDate = new JTextField(25);
    private JLabel JLabelCustomerName = new JLabel("Customer Name");
    private JLabel JLabelInvoiceDate = new JLabel("Invoice Date");
    private JButton JButtonOk = new JButton("OK");
    private JButton JButtonCancel = new JButton("Cancel");

    public DialogForHeader(SIG_Frame frame) {
        this.JButtonOk.setActionCommand("OkCreatNewInvoice");
        this.JButtonCancel.setActionCommand("CancelNewInvoice");
        this.JButtonOk.addActionListener(frame.getListenerBtns());
        this.JButtonCancel.addActionListener(frame.getListenerBtns());
        this.setLayout(new GridLayout(8, 6));
        this.add(this.JLabelCustomerName);
        this.add(this.JTextFieldCustomerName);
        this.add(this.JLabelInvoiceDate);
        this.add(this.JTextFieldInvoiceDate);
        this.add(this.JButtonOk);
        this.add(this.JButtonCancel);
        this.pack();
    }

    public JTextField getJTextFieldCustomerName() {
        return this.JTextFieldCustomerName;
    }

    public JTextField getJTextFieldInvoiceDate() {
        return this.JTextFieldInvoiceDate;
    }
}

