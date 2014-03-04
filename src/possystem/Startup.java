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
        CashRegister cr = new CashRegister();
        // start new sale, pass custId       
        cr.startNewSale("3");
        // add item, pass prodId and qty        
        cr.addItemToSale("1", 2);
        // add item, pass prodId and qty       
        cr.addItemToSale("4", 1);
        // add item, pass prodId and qty    
        cr.addItemToSale("5", 4);
        // finalize sale       
        cr.produceOutput();
    }
}
