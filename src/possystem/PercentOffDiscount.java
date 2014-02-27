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
public class PercentOffDiscount implements DiscountStrategy {

    private double percent = .10;

    public PercentOffDiscount(double percent) {
        setPercent(percent);
    }

    @Override
    public double getDiscountedTotal(double price, double qty) {
        return price * qty - getAmountSaved(price, qty);
    }

    @Override
    public double getAmountSaved(double price, double qty) {
        return price * qty * percent;
    }

    public double getPercent() {
        return percent;
    }

    public final void setPercent(double percent) {
        this.percent = percent;
    }
}
