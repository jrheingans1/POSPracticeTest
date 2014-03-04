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
public class NoDiscount implements DiscountStrategy {

    @Override
    public double getDiscountedTotal(double price, double qty) {
        return price * qty - getAmountSaved(price, qty);
    }

    @Override
    public double getAmountSaved(double price, double qty) {
        return price * qty;
    }
}
