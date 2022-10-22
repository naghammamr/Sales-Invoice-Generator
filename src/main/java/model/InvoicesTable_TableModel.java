package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author nagham
 */
public class InvoicesTable_TableModel extends AbstractTableModel {

    //array list of invoices (from the invoices frame)
    private ArrayList<InvoiceHeader> invoices;
    private String[] invoicesTableColumns = { "No.", "Date", "Customer", "Total" }; //define the headers here to be easy in the modify.

    public InvoicesTable_TableModel(ArrayList<InvoiceHeader> invoices) {
        this.invoices = invoices;
    }

    @Override
    public int getColumnCount() {
        return invoicesTableColumns.length; // didn't make it static (4) to make the app reusable in the future, to be able to modify it with any headers count.
    }

    @Override
    public String getColumnName(int column) {
        return invoicesTableColumns[column]; //to get the column header name and display it from the array defined "invoicesTableColumns".
    }

    @Override
    public int getRowCount() {
        return invoices.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //rowIndex is the index of invoices arraylist.
        //columnIndex is the index of object items.
        InvoiceHeader invoice = invoices.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return invoice.getInvoiceNum();
            case 1:
                return invoice.getInvoiceDate();
            case 2:
                return invoice.getCustomerName();
            case 3:
                return invoice.getInvoiceTotal();
            default:
                return "Not Found Index";
        }
    }

}
