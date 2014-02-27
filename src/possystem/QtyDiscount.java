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
public class QtyDiscount implements DiscountStrategy {

    private double percent = .10;
    private double minQuantity = 5;

    public QtyDiscount(double percent, double qty) {
        setPercent(percent);
        setMinQuantity(minQuantity);
    }

    @Override
    public double getDiscountedTotal(double price, double qty) {
        double discountedTotal = price * qty;
        if (qty >= minQuantity) {
            discountedTotal = price * qty - getAmountSaved(price, qty);
        }
        return discountedTotal;
    }

    @Override
    public double getAmountSaved(double price, double qty) {
        double amtSaved = 0;
        if (qty >= minQuantity) {
            amtSaved = price * qty * percent;
        }
        return amtSaved;
    }

    public double getPercent() {
        return percent;
    }

    public final void setPercent(double percent) {
        this.percent = percent;
    }

    public double getMinQuantity() {
        return minQuantity;
    }

    public final void setMinQuantity(double minQuantity) {
        this.minQuantity = minQuantity;
    }
}
