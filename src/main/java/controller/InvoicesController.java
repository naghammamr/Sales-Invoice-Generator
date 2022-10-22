package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import view.InvoiceFrame;
import view.InvoiceDialogPopup;
import view.ItemDialogPopup;

public class InvoicesController implements ActionListener, ListSelectionListener {

    private InvoiceFrame frame;
    private InvoiceDialogPopup newInvoicePopup;
    private ItemDialogPopup newItemPopup;

    public InvoicesController(InvoiceFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        switch (actionCommand) {
            case "Load File":
                loadFile();
                break;

            case "Save File":
                saveFile();
                break;

            case "Create New Invoice":
                createNewInvoice();
                break;

            case "saveNewInvoice":
                saveNewInvoice();
                break;

            case "cancelSavingNewInvoice":
                cancelSavingNewInvoice();
                break;

            case "Delete Invoice":
                deleteInvoice();
                break;

            case "Add New Item":
                addNewInvoiceItem();
                break;

            case "saveNewInvoiceItem":
                saveNewInvoiceItem();
                break;

            case "cancelSavingInvoiceItem":
                cancelSavingInvoiceItem();
                break;

            case "Delete Item":
                deleteInvoiceItem();
                break;

        }
    }

    //load file function to upload the csv files to the tables.
    private void loadFile() {

    }

    // value change method to view the items table when selecting an invoice from invoice table.
    @Override
    public void valueChanged(ListSelectionEvent e) {
    }

    // a method to open dialog to save a new invoice in the invoices table
    // create invoice button
    private void createNewInvoice() {
        newInvoicePopup = new InvoiceDialogPopup(frame);
        newInvoicePopup.setVisible(true);
    }

    //invoice dialog save button - save button method to save a new invoice.
    private void saveNewInvoice() {

    }

    //Cancel button from the popup
    private void cancelSavingNewInvoice() {

        newInvoicePopup.setVisible(false);
        newInvoicePopup.dispose(); // dispose the dialog so it don't take a space in the memory
        newInvoicePopup = null;
    }

    // delete invoice from the invoices table
    //Delete invoice button
    private void deleteInvoice() {

    }

    // open dialog to save a new item in a saved invoice.
    //Add Item Button
    private void addNewInvoiceItem() {
        newItemPopup = new ItemDialogPopup(frame);
        newItemPopup.setVisible(true);

    }

    private void saveNewInvoiceItem() {
    }

    private void cancelSavingInvoiceItem() {
        newItemPopup.setVisible(false);
        newItemPopup.dispose(); // dispose the dialog so it don't take a space in the memory
        newItemPopup = null;
    }

    // delete an item from the invoices table
    private void deleteInvoiceItem() {
    }

    private void saveFile() {
    }

}
