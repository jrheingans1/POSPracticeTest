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

    private Customer customer;
    private LineItem[] lineItem = new LineItem[0];
    private FakeDatabase db;
    NumberFormat nf = NumberFormat.getCurrencyInstance();
    Calendar today = Calendar.getInstance();
    String format = "M/d/yyy     hh:mm a";
    SimpleDateFormat sdf = new SimpleDateFormat(format);

    private static final String THANK_YOU = "Thank you for shopping at Khol's!";
    private static final String COME_AGAIN = "Come to see us again soon ";
    private static final String EXCLAMATION = "!";
    private static final String NEXT_LINE = "\n";
    private static final String STRING = "";
    private static final String FORMAT_BAR = " | ";
    private static final double ZERO_ZERO = 0.0;
    private static final String MINUS = "-";
    private static final String TAX = "Tax ";

    public Reciept(String customerId) {
        this.db = new FakeDatabase();
        customer = lookupCustomerById(customerId);
    }

    private Customer lookupCustomerById(String customerId) {
        customer = db.findCustomer(customerId);
        return customer;
    }

    public void addLineItem(String productId, int qty) {
        LineItem item = new LineItem(db.findProduct(productId), qty);
        addToArray(item);
    }

    private void addToArray(LineItem item) {
        LineItem[] tempItems = new LineItem[lineItem.length + 1];
        System.arraycopy(lineItem, 0, tempItems, 0, lineItem.length);
        tempItems[lineItem.length] = item;
        lineItem = tempItems;
    }

    private String getProductList() {
        String str = STRING;
        for (int i = 0; i < lineItem.length; i++) {
            str += lineItem[i].toString() + FORMAT_BAR + lineItem[i].getQtyPurchased() + NEXT_LINE;
        }
        return str;
    }

    public double getTotalBeforeDiscount() {
        double grandTotal = ZERO_ZERO;
        for (LineItem item : lineItem) {
            grandTotal += item.getSubTotal();
        }
        return grandTotal;
    }

    public double getTotalAfterDiscount() {
        double grandDiscountTotal = ZERO_ZERO;
        for (LineItem item : lineItem) {
            grandDiscountTotal += item.getSubTotal();
        }
        return grandDiscountTotal;
    }

    public double getSavings() {
        double savings = ZERO_ZERO;
        savings += (getTotalBeforeDiscount() - getTotalAfterDiscount());
        return savings;
    }

    public String getTime() {
        return sdf.format(today.getTime());
    }

    public String getReceipt() {
        String output = THANK_YOU + NEXT_LINE + NEXT_LINE;
        output += getTime() + NEXT_LINE;
        output += getProductList();
        output += nf.format(getTotalBeforeDiscount()) + NEXT_LINE;
        output += MINUS + nf.format(getSavings()) + NEXT_LINE;
        output += nf.format(getTotalAfterDiscount()) + NEXT_LINE;
        output += NEXT_LINE + NEXT_LINE + COME_AGAIN + customer.getName() + EXCLAMATION;
        return output;
    }
}
