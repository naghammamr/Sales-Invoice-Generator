package model;

import java.util.ArrayList;

public class InvoiceHeader {

    private int invoiceNum; // PK (1:M)
    private String invoiceDate;
    private String customerName;
    private ArrayList<InvoiceLine> InvoiceLines;

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
}
