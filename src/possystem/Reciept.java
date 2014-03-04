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
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Reciept {

    /**
     * * create variables
     */
    private Customer customer;
    private LineItem[] lineItem = new LineItem[0];
    private FakeDatabase db;
    NumberFormat nf = NumberFormat.getCurrencyInstance();
    Calendar today = Calendar.getInstance();
    String format = "M/d/yyy     hh:mm a";
    SimpleDateFormat sdf = new SimpleDateFormat(format);
    /**
     * * create finals to replace magic numbers
     */
    private static final String THANK_YOU = "Thank you for shopping at Khol's!";
    private static final String COME_AGAIN = "Come to see us again soon ";
    private static final String EXCLAMATION = "!";
    private static final String NEXT_LINE = "\n";
    private static final String STRING = "";
    private static final String FORMAT_BAR = " | ";
    private static final double ZERO_ZERO = 0.0;
    private static final String MINUS = "-";
    private static final String TAX = "Tax ";

    /**
     * * constructor (pass customerId)
     */
    public Reciept(String customerId) {
        this.db = new FakeDatabase();
        customer = lookupCustomerById(customerId);
    }

    /**
     * * locate customer by locating ID match using findCustomer * returns
     * customer
     */
    private Customer lookupCustomerById(String customerId) {
        customer = db.findCustomer(customerId);
        return customer;
    }

    /**
     * * adds an Item to LineItem
     */
    public void addLineItem(String productId, int qty) {
        LineItem item = new LineItem(db.findProduct(productId), qty);
        addToArray(item);
    }

    /**
     * * cycles through LineItem and adds them to an array
     */
    private void addToArray(LineItem item) {
        LineItem[] tempItems = new LineItem[lineItem.length + 1];
        System.arraycopy(lineItem, 0, tempItems, 0, lineItem.length);
        tempItems[lineItem.length] = item;
        lineItem = tempItems;
    }

    /**
     * * cycles through LineItem array and pulls the productName * returns
     * product name and quantity by string
     */
    private String getProductList() {
        String str = STRING;
        for (int i = 0; i < lineItem.length; i++) {
            str += lineItem[i].toString() + FORMAT_BAR + lineItem[i].getQtyPurchased() + NEXT_LINE;
        }
        return str;
    }

    /**
     * * cycles through LineItem array and gathers the total price before
     * discounts * are added * returns grand total before discounts are applied
     */
    public double getTotalBeforeDiscount() {
        double grandTotal = ZERO_ZERO;
        for (LineItem item : lineItem) {
            grandTotal += item.getSubTotal();
        }
        return grandTotal;
    }

    /**
     * * cycles through LineItem array and gathers the total price after
     * discounts * are applied * returns total after discounts are applied
     */
    public double getTotalAfterDiscount() {
        double grandDiscountTotal = ZERO_ZERO;
        for (LineItem item : lineItem) {
            grandDiscountTotal += item.getSubTotal();
        }
        return grandDiscountTotal;
    }

    /**
     * * This method gets the tax amount from total after the discount
     *
     *
     * @return taxCharge
     */
//        public double getTaxCharge() {
//            double taxCharge = ZERO_ZERO;
//            taxCharge = (customer.() * getTotalAfterDiscount());
//            return taxCharge;
//        }
    /**
     * * This method gets the grand total after discounts and tax have been
     * applied * @return grandTotal IF there is a tax to apply * ELSE return
     * calculated total after discount
     */
//        public double getTotalWithTax() {
//            double grandTotal = ZERO_ZERO;
//            if (customer.getTaxToApply() > 0) {
//                grandTotal += getTotalAfterDiscount() + (customer.getTaxToApply() * getTotalAfterDiscount());
//                return grandTotal;
//            } else {
//                return getTotalAfterDiscount();
//            }
//        }
    /**
     * * calculates amount saved * returns amount saved by applying discounts
     */
    public double getSavings() {
        double savings = ZERO_ZERO;
        savings += (getTotalBeforeDiscount() - getTotalAfterDiscount());
        return savings;
    }

    public String getTime() {
        return sdf.format(today.getTime());
    }

    /**
     * * adds information to Receipt output such as * products in the list,
     * total before discounts, savings, total after discounts * returns
     * accumulated output
     */
    public String getReceipt() {
        String output = THANK_YOU + NEXT_LINE + NEXT_LINE;
        output += getTime() + NEXT_LINE;
        output += getProductList();
        output += nf.format(getTotalBeforeDiscount()) + NEXT_LINE;
        output += MINUS + nf.format(getSavings()) + NEXT_LINE;
        output += nf.format(getTotalAfterDiscount()) + NEXT_LINE;
//            output += TAX + nf.format(getTaxCharge()) + NEXT_LINE;
//            output += nf.format(getTotalWithTax());
        output += NEXT_LINE + NEXT_LINE + COME_AGAIN + customer.getName() + EXCLAMATION;
        return output;
    }
}
