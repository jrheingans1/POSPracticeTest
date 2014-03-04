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

    private Reciept receipt;
    private final OutputStrategy output = OutputDivider.getInstance().getOutput(OutputDivider.OutputStrategies.GUI);

    public CashRegister() {
    }

    public void startNewSale(String customerId) {
        receipt = new Reciept(customerId);
    }

    public void addItemToSale(String productId, int qty) {
        receipt.addLineItem(productId, qty);
    }

    public void produceOutput() {
        output.getOutput(receipt.getReceipt());
    }
}
