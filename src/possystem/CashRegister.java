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

    private ReceiptStrategy receiptStrategy;
    private OutputStrategy output;

    public CashRegister() {
    }

    public void startNewSale(OutputStrategy output, ReceiptStrategy receiptStrategy, String customerId) {
        this.output = output;
        this.receiptStrategy = receiptStrategy;
        this.receiptStrategy.setCustomerId(customerId);
    }

    public void addItemToSale(String productId, int qty) {
        receiptStrategy.addLineItem(productId, qty);
    }

    public void produceOutput() {
        output.getOutput(receiptStrategy.getOutput());
    }
}
