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

        cr.startNewSale("3");

        cr.addItemToSale("1", 2);

        cr.addItemToSale("3", 1);

        cr.addItemToSale("2", 4);

        cr.produceOutput();
    }
}
