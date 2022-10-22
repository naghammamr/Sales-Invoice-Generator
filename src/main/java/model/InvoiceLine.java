package model;

public class InvoiceLine {

    private InvoiceHeader invoice;// M:1 (FK)
    private String itemName;
    private double itemPrice;
    private int count;

    public InvoiceLine() {
    }

    public InvoiceLine(InvoiceHeader invoice, String itemName, double itemprice, int count) 
    {
        this.invoice = invoice;
        this.itemName = itemName;
        this.itemPrice = itemprice;
        this.count = count;
    }

    public InvoiceHeader getInvoice() {
        return invoice;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) 
    {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getItemTotal() {
        return itemPrice * count;
    }

    @Override
    public String toString() {
        return "InvoiceLine{" + "invoiceNumber=" + invoice.getInvoiceNum() + ", itemName=" + itemName + ", itemprice=" + itemPrice + ", count=" + count + '}';
    }

    // will be used to save file
    public String convertInvoiceItemToCSV() {
        return invoice.getInvoiceNum() + "," + itemName + "," + itemPrice + "," + count;

    }

}
