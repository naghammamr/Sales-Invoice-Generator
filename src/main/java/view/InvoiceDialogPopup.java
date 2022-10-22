package view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InvoiceDialogPopup extends JDialog {

    private final JLabel customerNameFieldLabel;
    private JTextField customerNameTxtField;

    private final JLabel invoiceDateFieldLabel;
    private JTextField invoiceDateTxtField;

    private final JButton saveInvoiceBtn;
    private final JButton cancelInvSavingBtn;

    public InvoiceDialogPopup(InvoiceFrame frame) {

        setLayout(new GridLayout(3, 2));
        setTitle("New Invoice");
        setLocation(250, 350);
        //setSize(new Dimension(100, 100));
        //setLocationRelativeTo(frame);

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

    public JTextField getCustomerNameTxtField() {
        return customerNameTxtField; // to use it in the controller to get the entered text in the text field.
    }

    public JTextField getInvoiceDateTxtField() {
        return invoiceDateTxtField; // to use it in the controller to get the entered text in the text field.
    }

}