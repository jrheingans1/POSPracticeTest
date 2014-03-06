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
public class ReceiptFactory {
    private ReceiptStrategy o;
    public static enum ReceiptStrategies {

        RECEIPT, INVOICE;
    }
    private static ReceiptFactory instance;

    public static ReceiptFactory getInstance() {
        if (instance == null) {
            instance = new ReceiptFactory();
        }
        return instance;
    }

    public ReceiptStrategy getReceiptStrategy(ReceiptStrategies outputType) {
        switch (outputType) {
            case RECEIPT:
                o = new Receipt();
                break;
            case INVOICE:
                o = new Invoice();
                break;
        }
        return o;
    }
    
    
}
