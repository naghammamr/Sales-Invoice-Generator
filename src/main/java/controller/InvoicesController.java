package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.InvoiceHeader;
import model.InvoiceLine;
import model.InvoicesTable_TableModel;
import model.LinesTable_TableModel;
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
        String performedAction = e.getActionCommand();

        switch (performedAction) {
            case "Load File":
                loadFile();
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
                
            case "Save File":
                saveFile();
                break;
        }
    }

    //load file function to upload the csv files to the tables.
    private void loadFile() {
        
        JFileChooser fileSelector = new JFileChooser();
        
        try {
            int result = fileSelector.showOpenDialog(frame);//open windows dialog in the frame
            
            if (result == JFileChooser.APPROVE_OPTION) 
            {
                File invoiceHeaderFile = fileSelector.getSelectedFile();
                Path invoiceHeaderPath = Paths.get(invoiceHeaderFile.getAbsolutePath());
                
                List<String> headerInvoices = Files.readAllLines(invoiceHeaderPath);

                ArrayList<InvoiceHeader> invoicesArray = new ArrayList<>();
                for (String headerInvoice : headerInvoices) 
                {
                    try {
                        String[] headerParts = headerInvoice.split(",");
                        int invoiceNo = Integer.parseInt(headerParts[0]);
                        String invoiceDate = headerParts[1];
                        String customterName = headerParts[2];

                        InvoiceHeader invoice = new InvoiceHeader(invoiceNo, invoiceDate, customterName);
                        invoicesArray.add(invoice);

                    } 
                    catch (Exception ex) 
                    {
                        //If the converted format is not correct
                        JOptionPane.showMessageDialog(
                                frame, "Invalid File Format!! Check the file and try again.",
                                "File Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

                // read Line/invoice items file
                result = fileSelector.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) 
                {
                    File invoiceLine_File = fileSelector.getSelectedFile();
                    Path invoiceLine_Path = Paths.get(invoiceLine_File.getAbsolutePath());

                    List<String> invoicesLine_Lines = Files.readAllLines(invoiceLine_Path);

                    for (String invoicesLine : invoicesLine_Lines) {
                        try {
                            String[] invoiceLineParts = invoicesLine.split(",");
                            int invoiceNo = Integer.parseInt(invoiceLineParts[0]);
                            String itemName = invoiceLineParts[1];
                            double itemPrice = Double.parseDouble(invoiceLineParts[2]);
                            int count = Integer.parseInt(invoiceLineParts[3]);
                            InvoiceHeader itemInvoiceNumber = null;
                            for (InvoiceHeader invoice : invoicesArray) {
                                if (invoice.getInvoiceNum() == invoiceNo) {
                                    itemInvoiceNumber = invoice;
                                    break;
                                }
                            }

                            InvoiceLine line = new InvoiceLine(itemInvoiceNumber, itemName, itemPrice, count);
                            itemInvoiceNumber.getInvoiceLines().add(line);
                        } 
                        catch (Exception ex) 
                        {
                            //If the converted format is not correct
                            JOptionPane.showMessageDialog(
                                    frame, "Invalid File Format and/or a not found invoice number exist!! Check the file and try again.",
                                    "File Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                frame.setInvoices(invoicesArray);

                InvoicesTable_TableModel invoicesTblModel = new InvoicesTable_TableModel(invoicesArray);
                
                frame.setInvoicesTblModel(invoicesTblModel);
                frame.getInvoicesTable().setModel(invoicesTblModel); //Set table model to invoices table.
                frame.getInvoicesTblModel().fireTableDataChanged(); // to make the table model updated due to data change.

            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(
                    frame, "Invalid File!! Only CSV Files are accepted.",
                    "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // value change method to view the items table when selecting an invoice from invoice table.
    @Override
    public void valueChanged(ListSelectionEvent e) {

        int selectedInvoice = frame.getInvoicesTable().getSelectedRow();

        if (selectedInvoice != -1) 
        {
            InvoiceHeader currentInvoice = frame.getInvoices().get(selectedInvoice);

            frame.getInvoiceNumber().setText("" + currentInvoice.getInvoiceNum()); // "" + is added because invoice number is integer.
            frame.getInvoiceDate().setText(currentInvoice.getInvoiceDate());
            frame.getCustomerName().setText(currentInvoice.getCustomerName());
            frame.getInvoiceTotal().setText("" + currentInvoice.getInvoiceTotal());// "" + is added because invoice number is double, so just make it string.

            LinesTable_TableModel linestblModel = new LinesTable_TableModel(currentInvoice.getInvoiceLines());
            
            frame.getItemsTable().setModel(linestblModel);
            linestblModel.fireTableDataChanged(); //update the table
            
        }
    }

    // a method to open dialog to save a new invoice in the invoices table
    // create invoice button
    private void createNewInvoice() {

        newInvoicePopup = new InvoiceDialogPopup(frame);
        newInvoicePopup.setVisible(true);
    }

    //invoice dialog save button - save button method to save a new invoice.
    private void saveNewInvoice() {

        int newInvoiceNumber = frame.getNewInvoiceNumber();
        String newInvoiceCustomerName = newInvoicePopup.getCustomerNameTxtField().getText(); //Get Entered customer name
        String newInvoiceDate = newInvoicePopup.getInvoiceDateTxtField().getText(); // Get entered date

        DateFormat dateValidaiton = new SimpleDateFormat("DD-MM-YYYY"); // date validation

        try {
            dateValidaiton.parse(newInvoiceDate);

            InvoiceHeader invoice = new InvoiceHeader(newInvoiceNumber, newInvoiceDate, newInvoiceCustomerName);

            frame.getInvoices().add(invoice); // add the new invoice to the invoice array and table model
            frame.getInvoicesTblModel().fireTableDataChanged(); // to update the table model

            newInvoicePopup.setVisible(false);
            newInvoicePopup.dispose(); // dispose the dialog to close the popup after clicking save button
            newInvoicePopup = null;
            
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(
                    frame, "Invalid Date Format! Please Enter the date in 'DD-MM-YYYY' format.",
                    "Validation Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    //Cancel button from the popup
    private void cancelSavingNewInvoice() {

        newInvoicePopup.setVisible(false);
        newInvoicePopup.dispose(); // dispose the dialog so it don't take a space in the memory
        newInvoicePopup = null;
    }

    // Delete invoice from the invoices table
    // Delete invoice button
    private void deleteInvoice() {

        int selectedInvoice = frame.getInvoicesTable().getSelectedRow(); // get selected row index.

        if (selectedInvoice != -1) 
        {
            frame.getInvoices().remove(selectedInvoice);
            frame.getInvoicesTblModel().fireTableDataChanged();// to update the table after the change
        }
    }

    // open dialog to save a new item in a saved invoice.
    //Add Item Button
    private void addNewInvoiceItem() {

        newItemPopup = new ItemDialogPopup(frame);
        newItemPopup.setVisible(true);

    }

    private void saveNewInvoiceItem() {

        // to make sure that the user is selecting an invoice.
        String newItemName = newItemPopup.getNewItemNameTxt().getText();
        double newItemPrice = Double.parseDouble(newItemPopup.getNewItemPriceTxt().getText());
        int newItemCount = Integer.parseInt(newItemPopup.getNewItemCountTxt().getText());

        int selectedInvoiceNumber = frame.getInvoicesTable().getSelectedRow();

        if (selectedInvoiceNumber != -1) {
            InvoiceHeader invoiceNumber = frame.getInvoices().get(selectedInvoiceNumber);

            InvoiceLine invLine = new InvoiceLine(invoiceNumber, newItemName, newItemPrice, newItemCount);
            invoiceNumber.getInvoiceLines().add(invLine);

            LinesTable_TableModel itemTblModel = (LinesTable_TableModel) frame.getItemsTable().getModel(); //casting
            itemTblModel.fireTableDataChanged(); //to update the table.

            frame.getInvoicesTblModel().fireTableDataChanged(); // to update the invoice total
        }

        newItemPopup.setVisible(false);
        newItemPopup.dispose(); // dispose the dialog to close the popup after clicking save button
        newItemPopup = null;
    }

    private void cancelSavingInvoiceItem() {

        newItemPopup.setVisible(false);
        newItemPopup.dispose(); // dispose the dialog so it don't take a space in the memory
        newItemPopup = null;
    }

    // delete an item from the invoices table
    private void deleteInvoiceItem() {
        
        int selectedInvoice = frame.getInvoicesTable().getSelectedRow();// get the selected invoice index.
        int selectedRow = frame.getItemsTable().getSelectedRow(); // get selected row index.

        if (selectedInvoice != 1 && selectedRow != -1) 
        {
            InvoiceHeader invoice = frame.getInvoices().get(selectedInvoice);
            invoice.getInvoiceLines().remove(selectedRow);

            LinesTable_TableModel lineTblModel = new LinesTable_TableModel(invoice.getInvoiceLines());
            frame.getItemsTable().setModel(lineTblModel);
            lineTblModel.fireTableDataChanged(); //update the table.
            
            //Update total invoice after deleting item
            InvoiceHeader currentInvoice = frame.getInvoices().get(selectedInvoice);
            frame.getInvoiceTotal().setText("" + currentInvoice.getInvoiceTotal());// "" + is added because invoice number is double, so just make it string.        
            frame.getInvoicesTblModel().fireTableDataChanged(); // to update the invoice total
            // end 
        }
    }

    private void saveFile() {

        ArrayList<InvoiceHeader> invoices = frame.getInvoices();

        String invoiceHeader = "";
        String invoiceItem = "";

        // loop for all items in the array and save it.
        for (InvoiceHeader invoice : invoices) {
            String convertedInvoices = invoice.convertInvoiceToCSV();

            invoiceHeader += convertedInvoices; // add new invoice
            invoiceHeader += "\n"; //add new line in the invoice header

            for (InvoiceLine invLine : invoice.getInvoiceLines()) {
                String convertedInvoiceLines = invLine.convertInvoiceItemToCSV();

                invoiceItem += convertedInvoiceLines; //add new item to the invoice array
                invoiceItem += "\n"; //add new line
            }
        }

        JFileChooser filechooser = new JFileChooser();
        int result = filechooser.showSaveDialog(frame);

        // Save the invoice header csv file
        if (result == JFileChooser.APPROVE_OPTION) {
            File invoiceFile = filechooser.getSelectedFile();
            try {
                FileWriter invoiceFileWriter = new FileWriter(invoiceFile); // open file stream
                invoiceFileWriter.write(invoiceHeader); // write the invoice data in the file.
                invoiceFileWriter.flush(); // clear the writer of any element.
                invoiceFileWriter.close(); // close the file 
            } catch (IOException ex) {
                Logger.getLogger(InvoicesController.class.getName()).log(Level.SEVERE, "IOException!!!", ex);
            }

            // save the items csv file
            result = filechooser.showSaveDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File invoiceItemFile = filechooser.getSelectedFile();
                try {
                    FileWriter invoiceItemsFileWriter = new FileWriter(invoiceItemFile); // open file stream
                    invoiceItemsFileWriter.write(invoiceItem); // write the invoice data in the file.
                    invoiceItemsFileWriter.flush(); // clear the writer of any element.
                    invoiceItemsFileWriter.close(); // close the file 
                } catch (IOException ex) {
                    Logger.getLogger(InvoicesController.class.getName()).log(Level.SEVERE, "IOException!!!", ex);
                }
            }

        }
    }

}
