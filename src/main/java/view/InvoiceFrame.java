package view;

import java.util.ArrayList;
import controller.InvoicesController;
import javax.swing.JLabel;
import javax.swing.JTable;
import model.InvoiceHeader;
import model.InvoicesTable_TableModel;

/**
 *
 * @author nagham
 */
public class InvoiceFrame extends javax.swing.JFrame {

    public InvoiceFrame() {
        initComponents();
    }

    private InvoicesController controller = new InvoicesController(this);

    public InvoicesController getController() {
        return controller;
    }

    // Invoices Header - Start
    private ArrayList<InvoiceHeader> invoicesArray;

    public ArrayList<InvoiceHeader> getInvoicesArray() {
        return invoicesArray;
    }

    public void setInvoicesArray(ArrayList<InvoiceHeader> invArray) {
        this.invoicesArray = invArray;
    }
    // Invoices Header - End

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jPanelLeft = new javax.swing.JPanel();
        newInvoiceBtn = new javax.swing.JButton();
        newInvoiceBtn.addActionListener(controller);

        deleteInvoicesBtn = new javax.swing.JButton();
        deleteInvoicesBtn.addActionListener(controller);

        jScrollPane1 = new javax.swing.JScrollPane();
        leftInvoicesTable = new javax.swing.JTable();
        leftInvoicesTable.getSelectionModel().addListSelectionListener(controller);
        InvoicesTableHeader = new javax.swing.JLabel();
        jPanelRight = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ItemsTable = new javax.swing.JTable();
        invoiceNumLabel = new javax.swing.JLabel();
        invoiceNumberTxt = new javax.swing.JLabel();
        invoiceDateLabel = new javax.swing.JLabel();
        customerLabel = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        invoiceTotalTxt = new javax.swing.JLabel();
        invoicesItemTableHeader = new javax.swing.JLabel();
        saveInvoicesItemsBtn = new javax.swing.JButton();
        saveInvoicesItemsBtn.addActionListener(controller);

        cancelInvoiceItemBtn = new javax.swing.JButton();
        cancelInvoiceItemBtn.addActionListener(controller);
        invoiceDateTxt = new javax.swing.JLabel();
        customerNameTxt = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        loadFileMenuItem = new javax.swing.JMenuItem();
        loadFileMenuItem.addActionListener(controller);
        saveFileMenuItem = new javax.swing.JMenuItem();
        saveFileMenuItem.addActionListener(controller);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 310, -1, -1));

        newInvoiceBtn.setText("Create New Invoice");
        newInvoiceBtn.setToolTipText("Click after uploading the invoices");
        newInvoiceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newInvoiceBtnActionPerformed(evt);
            }
        });

        deleteInvoicesBtn.setText("Delete Invoice");
        deleteInvoicesBtn.setToolTipText("Click after uploading the invoices");

        leftInvoicesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(leftInvoicesTable);

        InvoicesTableHeader.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        InvoicesTableHeader.setLabelFor(InvoicesTableHeader);
        InvoicesTableHeader.setText("Invoices Table");

        javax.swing.GroupLayout jPanelLeftLayout = new javax.swing.GroupLayout(jPanelLeft);
        jPanelLeft.setLayout(jPanelLeftLayout);
        jPanelLeftLayout.setHorizontalGroup(
            jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLeftLayout.createSequentialGroup()
                .addGroup(jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLeftLayout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(newInvoiceBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteInvoicesBtn))
                    .addGroup(jPanelLeftLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLeftLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(InvoicesTableHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanelLeftLayout.setVerticalGroup(
            jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLeftLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(InvoicesTableHeader)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newInvoiceBtn)
                    .addComponent(deleteInvoicesBtn))
                .addGap(31, 31, 31))
        );

        getContentPane().add(jPanelLeft, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 570));

        jPanelRight.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        ItemsTable.setAutoCreateRowSorter(true);
        ItemsTable.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        ItemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        ItemsTable.setToolTipText("");
        ItemsTable.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane3.setViewportView(ItemsTable);
        ItemsTable.getAccessibleContext().setAccessibleName("");

        invoiceNumLabel.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        invoiceNumLabel.setText("Invoice Number:");

        invoiceNumberTxt.setToolTipText("Current Invoice Number");

        invoiceDateLabel.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        invoiceDateLabel.setText("Invoice Date:");

        customerLabel.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        customerLabel.setText("Customer Name:");

        totalLabel.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        totalLabel.setText("Invoice Total:");

        invoicesItemTableHeader.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        invoicesItemTableHeader.setText("Invoices Items");

        saveInvoicesItemsBtn.setText("Add New Item");
        saveInvoicesItemsBtn.setToolTipText("Click after selecting the invoice");
        saveInvoicesItemsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveInvoicesItemsBtnActionPerformed(evt);
            }
        });

        cancelInvoiceItemBtn.setText("Delete Item");
        cancelInvoiceItemBtn.setToolTipText("select item first");
        cancelInvoiceItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelInvoiceItemBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelRightLayout = new javax.swing.GroupLayout(jPanelRight);
        jPanelRight.setLayout(jPanelRightLayout);
        jPanelRightLayout.setHorizontalGroup(
            jPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRightLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRightLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
                    .addGroup(jPanelRightLayout.createSequentialGroup()
                        .addGroup(jPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(invoicesItemTableHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelRightLayout.createSequentialGroup()
                                .addGroup(jPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(customerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(jPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(customerNameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(invoiceTotalTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanelRightLayout.createSequentialGroup()
                                .addComponent(invoiceDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(invoiceDateTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanelRightLayout.createSequentialGroup()
                                .addComponent(invoiceNumLabel)
                                .addGap(18, 18, 18)
                                .addComponent(invoiceNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(16, 16, 16))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRightLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveInvoicesItemsBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelInvoiceItemBtn)
                .addGap(167, 167, 167))
        );
        jPanelRightLayout.setVerticalGroup(
            jPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRightLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRightLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(invoiceNumberTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(invoiceNumLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(invoiceDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(invoiceDateTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(customerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .addComponent(customerNameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(invoiceTotalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(invoicesItemTableHeader)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveInvoicesItemsBtn)
                    .addComponent(cancelInvoiceItemBtn))
                .addGap(29, 29, 29))
        );

        getContentPane().add(jPanelRight, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 510, 570));

        jMenuBar1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        fileMenu.setText("File");

        loadFileMenuItem.setText("Load File");
        loadFileMenuItem.setToolTipText("load invoices file");
        loadFileMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadFileMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(loadFileMenuItem);

        saveFileMenuItem.setText("Save File");
        saveFileMenuItem.setToolTipText("Save current invoices");
        fileMenu.add(saveFileMenuItem);

        jMenuBar1.add(fileMenu);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadFileMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadFileMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loadFileMenuItemActionPerformed

    private void newInvoiceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newInvoiceBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newInvoiceBtnActionPerformed

    private void cancelInvoiceItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelInvoiceItemBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelInvoiceItemBtnActionPerformed

    private void saveInvoicesItemsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveInvoicesItemsBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveInvoicesItemsBtnActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) 
            {
                if ("Nimbus".equals(info.getName())) 
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() {
                new InvoiceFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel InvoicesTableHeader;
    private javax.swing.JTable ItemsTable;
    private javax.swing.JButton cancelInvoiceItemBtn;
    private javax.swing.JLabel customerLabel;
    private javax.swing.JLabel customerNameTxt;
    private javax.swing.JButton deleteInvoicesBtn;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JLabel invoiceDateLabel;
    private javax.swing.JLabel invoiceDateTxt;
    private javax.swing.JLabel invoiceNumLabel;
    private javax.swing.JLabel invoiceNumberTxt;
    private javax.swing.JLabel invoiceTotalTxt;
    private javax.swing.JLabel invoicesItemTableHeader;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanelLeft;
    private javax.swing.JPanel jPanelRight;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable leftInvoicesTable;
    private javax.swing.JMenuItem loadFileMenuItem;
    private javax.swing.JButton newInvoiceBtn;
    private javax.swing.JMenuItem saveFileMenuItem;
    private javax.swing.JButton saveInvoicesItemsBtn;
    private javax.swing.JLabel totalLabel;
    // End of variables declaration//GEN-END:variables

    // Table Model - Start
    private InvoicesTable_TableModel invoicesTblModel;//table model to display uploaded file data in the table.

    public InvoicesTable_TableModel getInvoicesTblModel() {
        return invoicesTblModel;
    }

    public void setInvoicesTblModel(InvoicesTable_TableModel invoicesTblModel) {
        this.invoicesTblModel = invoicesTblModel;
    }
    // Table Model - End

    //Invoices Table getter method
    public JTable getInvoicesTable() {
        return leftInvoicesTable;
    }

    //Invoices Lines Table getter method
    public JTable getItemsTable() {
        return ItemsTable;
    }

    //Invoices Table 4 Labels getter methods - Start
    public JLabel getInvoiceNumber() {
        return invoiceNumberTxt;
    }

    public JLabel getCustomerName() {
        return customerNameTxt;
    }

    public JLabel getInvoiceDate() {
        return invoiceDateTxt;
    }

    public JLabel getInvoiceTotal() {
        return invoiceTotalTxt;
    }
    //Invoices Table 4 Labels getter methods - End

    public int getNewInvoiceNumber() {

        int invoiceNumber = 0;
        for (InvoiceHeader invoice : invoicesArray) {
            if (invoice.getInvoiceNum() > invoiceNumber) {
                invoiceNumber = invoice.getInvoiceNum();
            }
        }

        return ++invoiceNumber;
    }
}