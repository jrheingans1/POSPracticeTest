/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package possystem;

/**
 *
 * @author jrheingans1
 */
public class CashRegister {

    /**
     * * create variables
     */
    private Reciept receipt;
    private OutputStrategy output = OutputDivider.getInstance().getOutput(OutputDivider.OutputStrategies.GUI);

    /**
     * * constructor nothing passed
     */
    public CashRegister() {
    }

    /**
     * * startNewSale starts a new sale (pass customerId) * creates new Receipt
     * with customer ID
     */
    public void startNewSale(String customerId) {
        receipt = new Reciept(customerId);
    }

    /**
     * * add each item to receipt (pass productId and qty)
     */
    public void addItemToSale(String productId, int qty) {
        receipt.addLineItem(productId, qty);
    }

    /**
     * * method to finalizeSale * returns getReceipt from receipt class
     */
    public void produceOutput() {
        output.getOutput(receipt.getReceipt());
    }
}
