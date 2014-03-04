/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package possystem;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author jrheingans1
 */
public class EasterHolidayDiscount implements DiscountStrategy {

    private final Calendar startDate = Calendar.getInstance();
    private final Calendar endDate = Calendar.getInstance();
    private final Calendar currentDate = Calendar.getInstance();
    private double holidayPercent = .30;
    NumberFormat nf = NumberFormat.getCurrencyInstance();
//    Calendar today = Calendar.getInstance();
    String format = "M/d/yyy     hh:mm a";
    SimpleDateFormat sdf = new SimpleDateFormat(format);

    public EasterHolidayDiscount(double holidayPercent) {
        setHolidayPercent(holidayPercent);
        startDate.set(currentDate.get(Calendar.YEAR), Calendar.MARCH, 1);
        endDate.set(currentDate.get(Calendar.YEAR), Calendar.MARCH, 15);
    }

    @Override
    public double getDiscountedTotal(double price, double qty) {
        double discountedTotal = price * qty;
        if (currentDate.after(startDate) && currentDate.before(endDate)) {
            discountedTotal = price * qty - getAmountSaved(price, qty);
        } else {
        }
        return discountedTotal;
    }

    @Override
    public double getAmountSaved(double price, double qty) {
        double amtSaved = 0;
        if (currentDate.after(startDate) && currentDate.before(endDate)) {
            amtSaved = price * qty * holidayPercent;
        }
        return amtSaved;
    }

    public final double getHolidayPercent() {
        return holidayPercent;
    }

    public final void setHolidayPercent(double holidayPercent) {
        this.holidayPercent = holidayPercent;
    }

    public String getTime() {
        return sdf.format(currentDate.getTime());
    }

    @Override
    public String toString() {
        return getTime();
    }
}
