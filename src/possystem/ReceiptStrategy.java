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
public interface ReceiptStrategy {

    public abstract void addLineItem(String productId, int qty);

    public abstract double getSavings();

    public abstract String getTime();

    public abstract double getTotalAfterDiscount();

    public abstract double getTotalBeforeDiscount();
    
    public abstract String getOutput();
    
    public abstract void setCustomerId(String id);
    
}
