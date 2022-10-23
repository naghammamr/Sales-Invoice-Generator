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
    //private final JLabel invoiceDateFormatLabel;

    private final JButton saveInvoiceBtn;
    private final JButton cancelInvSavingBtn;

    public InvoiceDialogPopup(InvoiceFrame mainFrame) {

        setLayout(new GridLayout(3, 3));
        setTitle("New Invoice");
        setLocation(350, 250);
        //setLocationRelativeTo(mainFrame);

        customerNameFieldLabel = new JLabel("Customer Name: ");
        customerNameTxtField = new JTextField(20);

        invoiceDateFieldLabel = new JLabel("Invoice Date: ");
        invoiceDateTxtField = new JTextField(10); // DD-MM-YYYY
        //invoiceDateFormatLabel = new JLabel("Date Format: DD-MM-YYYY ");

        saveInvoiceBtn = new JButton("Save");
        saveInvoiceBtn.setActionCommand("saveNewInvoice");

        cancelInvSavingBtn = new JButton("Cancel");
        cancelInvSavingBtn.setActionCommand("cancelSavingNewInvoice");

        saveInvoiceBtn.addActionListener(mainFrame.getController());
        cancelInvSavingBtn.addActionListener(mainFrame.getController());

        add(customerNameFieldLabel);
        add(customerNameTxtField);

        add(invoiceDateFieldLabel);
        add(invoiceDateTxtField);

        add(saveInvoiceBtn);
        add(cancelInvSavingBtn);

        pack();
    }

    public JTextField getCustomerNameText() {
        return customerNameTxtField; // to use it in the controller to get the entered text in the text field.
    }

    public JTextField getInvoiceDateText() {
        return invoiceDateTxtField; // to use it in the controller to get the entered text in the text field.
    }
}