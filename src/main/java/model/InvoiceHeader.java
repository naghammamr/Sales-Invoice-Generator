package model;

import java.util.ArrayList;

public class InvoiceHeader {

    private int invoiceNum; // PK (1:M)
    private String invoiceDate;
    private String customerName;
    private ArrayList<InvoiceLine> InvoiceItems;

    public InvoiceHeader() {
    }

    public InvoiceHeader(int invoiceNumber, String invoiceDate, String customerName) {
        this.invoiceNum = invoiceNumber;
        this.invoiceDate = invoiceDate;
        this.customerName = customerName;
    }

    public int getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(int invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public ArrayList<InvoiceLine> getInvoiceItems() {

        if (InvoiceItems == null) 
        {
            InvoiceItems = new ArrayList<>();
        }
        return InvoiceItems;
    }

    // to calculate the total of the invoice per line
    // (item price * total) --> getItemTotal(); from invoice line class model
    public double getInvoiceTotal() {
        double invoiceTotal = 0.0;
        for (InvoiceLine l : getInvoiceItems()) {
            invoiceTotal += l.getItemTotal();
        }
        return invoiceTotal;
    }

    @Override
    public String toString() {
        return "InvoiceHeader{" + "invoiceNumber=" + invoiceNum + ", invoiceDate=" + invoiceDate + ", customerName=" + customerName + '}';
    }

    // will be used to save file
    public String convertInvoiceToCSV() {
        return invoiceNum + "," + invoiceDate + "," + customerName;
    }

}
