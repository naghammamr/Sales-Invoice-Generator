package view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ItemDialogPopup extends JDialog {

    //{"No.", "Item Name", "Item Price", "Count", "Item Total"}; 
    private final JLabel itemNameLabel;
    private JTextField itemNameTxtField;

    private final JLabel itemPriceLabel;
    private JTextField itemPriceTxtField;

    private final JLabel itemCountLabel;
    private JTextField itemCountTxtField;

    private final JButton saveItemBtn;
    private JButton cancelsavingItemBtn;

    public ItemDialogPopup(InvoiceFrame frame) {

        // Dialog settings
        setLayout(new GridLayout(4, 2));
        setTitle("New Invoice Item");
        setLocation(250, 350);

        itemNameLabel = new JLabel("Item Name");
        itemNameTxtField = new JTextField(128);

        itemPriceLabel = new JLabel("Item's Price");
        itemPriceTxtField = new JTextField(10);

        itemCountLabel = new JLabel("Item's Count");
        itemCountTxtField = new JTextField(10);

        saveItemBtn = new JButton("Save");
        saveItemBtn.setActionCommand("saveNewInvoiceItem");

        cancelsavingItemBtn = new JButton("Cancel");
        cancelsavingItemBtn.setActionCommand("cancelSavingInvoiceItem");

        saveItemBtn.addActionListener(frame.getController());
        cancelsavingItemBtn.addActionListener(frame.getController());

        add(itemNameLabel);
        add(itemNameTxtField);

        add(itemPriceLabel);
        add(itemPriceTxtField);

        add(itemCountLabel);
        add(itemCountTxtField);

        add(saveItemBtn);
        add(cancelsavingItemBtn);

        pack();
    }

    public JTextField getNewItemNameTxt() {
        return itemNameTxtField;
    }

    public JTextField getNewItemPriceTxt() {
        return itemPriceTxtField;
    }

    public JTextField getNewItemCountTxt() {
        return itemCountTxtField;
    }
}
