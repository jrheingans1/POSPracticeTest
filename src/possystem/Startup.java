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
public class Startup {

    public static void main(String[] args) {
        ReceiptStrategy receiptStrategy = receiptStrategy = ReceiptFactory.getInstance().getReceiptStrategy(ReceiptFactory.ReceiptStrategies.RECEIPT);
        OutputStrategy output = OutputFactory.getInstance().getOutput(OutputFactory.OutputStrategies.CONSOLE);
        
        CashRegister cr = new CashRegister();

        cr.startNewSale(output,receiptStrategy, "1");

        cr.addItemToSale("1", 2);

        cr.addItemToSale("3", 1);

        cr.addItemToSale("2", 4);

        cr.produceOutput();
    }
}
