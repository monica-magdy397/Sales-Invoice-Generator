//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package SIG_Controller;

import SIG_Design.SIG_Frame;
import SIG_Model.InvoiceHeader;
import SIG_Model.InvoiceHeaderTable;
import SIG_Model.InvoiceLine;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ActionListenerMenuItems implements ActionListener {
    private SIG_Frame frame;

    public ActionListenerMenuItems(SIG_Frame frame) {
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Load File":
                this.LoadFile();
                break;
            case "Save File":
                this.SaveFile();
        }

    }

    private void LoadFile() {
        JOptionPane.showMessageDialog(this.frame, "Please, select header file!", "Attension", 2);
        JFileChooser fileChooser = new JFileChooser();

        try {
            int choice = fileChooser.showOpenDialog(this.frame);
            if (choice == 0) {
                Path PathOfHeaderFile = Paths.get(fileChooser.getSelectedFile().getAbsolutePath());
                List<String> linesOfHeaderFile = Files.readAllLines(PathOfHeaderFile);
                ArrayList<InvoiceHeader> Headers = new ArrayList();
                Iterator var6 = linesOfHeaderFile.iterator();

                while(var6.hasNext()) {
                    String line = (String)var6.next();
                    String[] HeaderElements = line.split(",");
                    int code = Integer.parseInt(HeaderElements[0]);
                    Date invoiceDate = SIG_Frame.date.parse(HeaderElements[1]);
                    InvoiceHeader invHeader = new InvoiceHeader(code, invoiceDate, HeaderElements[2]);
                    Headers.add(invHeader);
                }

                this.frame.setInvoicesArr(Headers);
                System.out.println("Header file read");
                JOptionPane.showMessageDialog(this.frame, "Please, select lines file!", "Attension", 2);
                choice = fileChooser.showOpenDialog(this.frame);
                if (choice == 0) {
                    Path PathOfLineFile = Paths.get(fileChooser.getSelectedFile().getAbsolutePath());
                    List<String> linesOfLineFile = Files.readAllLines(PathOfLineFile);
                    new ArrayList();
                    Iterator var23 = linesOfLineFile.iterator();

                    while(var23.hasNext()) {
                        String lineOfLineFile = (String)var23.next();
                        String[] lineElements = lineOfLineFile.split(",");
                        int code = Integer.parseInt(lineElements[0]);
                        double price = Double.parseDouble(lineElements[2]);
                        int count = Integer.parseInt(lineElements[3]);
                        InvoiceHeader inv = this.frame.getInvoiceHeaderObject(code);
                        InvoiceLine line = new InvoiceLine(inv, lineElements[1], price, count);
                        inv.getLines().add(line);
                    }
                }

                InvoiceHeaderTable headerTable1 = new InvoiceHeaderTable(Headers);
                this.frame.setHeaderTable(headerTable1);
                this.frame.getjTable_Invoice().setModel(headerTable1);
                System.out.println("lines file read");
            }
        } catch (IOException var18) {
            JOptionPane.showMessageDialog(this.frame, var18.getMessage(), "Error", 0);
        } catch (ParseException var19) {
            JOptionPane.showMessageDialog(this.frame, var19.getMessage(), "Error", 0);
        }

        this.printInvoices();
    }

    private void SaveFile() {
        ArrayList<InvoiceHeader> headers = this.frame.getInvoicesArr();
        JOptionPane.showMessageDialog(this.frame, "(select/Create) file to save Invoices Header", "Attension", 2);
        JFileChooser fileChooser = new JFileChooser();

        try {
            int choice = fileChooser.showSaveDialog(this.frame);
            if (choice == 0) {
                File hFile = fileChooser.getSelectedFile();
                FileWriter hFileWriter = new FileWriter(hFile);
                String hStr = "";
                String lStr = "";
                int i = 0;
                int hSize = headers.size();
                Iterator var10 = headers.iterator();

                while(var10.hasNext()) {
                    InvoiceHeader header = (InvoiceHeader)var10.next();
                    ++i;
                    hStr = hStr + header.toString();
                    if (i != hSize) {
                        hStr = hStr + "\n";
                    }

                    int j = 0;
                    int lSize = header.getLines().size();

                    for(Iterator var14 = header.getLines().iterator(); var14.hasNext(); lStr = lStr + "\n") {
                        InvoiceLine line = (InvoiceLine)var14.next();
                        ++j;
                        lStr = lStr + line.toString();
                        if (j == lSize && i == hSize) {
                            break;
                        }
                    }
                }

                JOptionPane.showMessageDialog(this.frame, "(select/Create) file to save Lines Invoice", "Attension", 2);
                fileChooser.showSaveDialog(this.frame);
                File lFile = fileChooser.getSelectedFile();
                FileWriter lFileWriter = new FileWriter(lFile);
                hFileWriter.write(hStr);
                lFileWriter.write(lStr);
                hFileWriter.close();
                lFileWriter.close();
            }
        } catch (IOException var16) {
            JOptionPane.showMessageDialog(this.frame, var16.getMessage(), "Error", 0);
        }

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
