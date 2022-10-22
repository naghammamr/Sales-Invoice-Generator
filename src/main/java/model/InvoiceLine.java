package model;

public class InvoiceLine {

    private InvoiceHeader invoice;// M:1 (FK)
    private String itemName;
    private double itemprice;
    private int count;

    public InvoiceLine() {
    }

    public InvoiceLine(InvoiceHeader invoice, String itemName, double itemprice, int count) {
        this.itemName = itemName;
        this.itemprice = itemprice;
        this.count = count;
        this.invoice = invoice;
    }

    public InvoiceHeader getInvoice() {
        return invoice;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemprice() {
        return itemprice;
    }

    public void setItemprice(double itemprice) {
        this.itemprice = itemprice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
