package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author nagham
 */
public class LinesTable_TableModel extends AbstractTableModel {

    public LinesTable_TableModel(ArrayList<InvoiceLine> lines) {
        this.lines = lines;
    }
    private ArrayList<InvoiceLine> lines;
    private String[] itemsTableColumns = { "No.", "Item Name", "Item Price", "Count", "Item Total" }; //define the headers here to be easy in the modify.

    @Override
    public int getRowCount() {
        return lines.size();
    }

    @Override
    public int getColumnCount() {
        return itemsTableColumns.length;
    }

    @Override
    public String getColumnName(int column) {
        return itemsTableColumns[column]; //to get the column header name and display it from the array defined "invoicesTableColumns".
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceLine line = lines.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return line.getInvoice().getInvoiceNum();
            case 1:
                return line.getItemName();
            case 2:
                return line.getItemPrice();
            case 3:
                return line.getCount();
            case 4:
                return line.getItemTotal();
            default:
                return "No Items Found in this invoice!";
        }

    }

}