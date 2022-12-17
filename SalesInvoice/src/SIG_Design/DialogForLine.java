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

public class DialogForLine extends JDialog {
    private JTextField JTextFielditemName = new JTextField(25);
    private JTextField JTextFielditemCount = new JTextField(25);
    private JTextField itemPriceField = new JTextField(25);
    private JLabel JLabelitemName = new JLabel("Item Name");
    private JLabel JLabelitemCount = new JLabel("Item Count");
    private JLabel JLabelitemPrice = new JLabel("Item Price");
    private JButton JButtonOk = new JButton("OK");
    private JButton JButtonCancel = new JButton("Cancel");

    public DialogForLine(SIG_Frame frame) {
        this.JButtonOk.setActionCommand("OkCreatNewLine");
        this.JButtonCancel.setActionCommand("CancelNewLine");
        this.JButtonOk.addActionListener(frame.getListenerBtns());
        this.JButtonCancel.addActionListener(frame.getListenerBtns());
        this.setLayout(new GridLayout(9, 6));
        this.add(this.JLabelitemName);
        this.add(this.JTextFielditemName);
        this.add(this.JLabelitemCount);
        this.add(this.JTextFielditemCount);
        this.add(this.JLabelitemPrice);
        this.add(this.itemPriceField);
        this.add(this.JButtonOk);
        this.add(this.JButtonCancel);
        this.pack();
    }

    public JTextField getJTextFielditemName() {
        return this.JTextFielditemName;
    }

    public JTextField getJTextFielditemCount() {
        return this.JTextFielditemCount;
    }

    public JTextField getItemPriceField() {
        return this.itemPriceField;
    }
}

