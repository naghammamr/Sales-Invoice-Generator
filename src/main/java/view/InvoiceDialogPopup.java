package view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InvoiceDialogPopup extends JDialog {

    private JLabel customerNameFieldLabel;
    private JTextField customerNameTxtField;

    private JLabel invoiceDateFieldLabel;
    private JTextField invoiceDateTxtField;

    private JButton saveInvoiceBtn;
    private JButton cancelInvSavingBtn;

    public InvoiceDialogPopup(InvoiceFrame frame) {

        setLayout(new GridLayout(3, 2));
        setTitle("New Invoice");
        setSize(100, 400);
        setLocation(150, 100);

        customerNameFieldLabel = new JLabel("Customer Name: ");
        customerNameTxtField = new JTextField(45);

        invoiceDateFieldLabel = new JLabel("Invoice Date: ");
        invoiceDateTxtField = new JTextField(10); // DD-MM-YYYY

        saveInvoiceBtn = new JButton("Save");
        saveInvoiceBtn.setActionCommand("saveNewInvoice");

        cancelInvSavingBtn = new JButton("Cancel");
        cancelInvSavingBtn.setActionCommand("cancelSavingNewInvoice");

        saveInvoiceBtn.addActionListener(frame.getController());
        cancelInvSavingBtn.addActionListener(frame.getController());

        add(customerNameFieldLabel);
        add(customerNameTxtField);

        add(invoiceDateFieldLabel);
        add(invoiceDateTxtField);

        add(saveInvoiceBtn);
        add(cancelInvSavingBtn);

        pack();
    }


}
