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
public class LineItem {

    private double qtyPurchased;
    private Product product;
    private double subTotal;

    public LineItem(Product product, double qtyPurchased) {
        setProduct(product);
        setQtyPurchased(qtyPurchased);
    }

    public final Product getProduct() {
        return product;
    }

    public final void setProduct(final Product product) {
        this.product = product;
    }

    public final double getQtyPurchased() {
        return qtyPurchased;
    }

    public final void setQtyPurchased(final double qtyPurchased) {
        this.qtyPurchased = qtyPurchased;
    }

    public double getSubTotal() {
        return product.getPrice() * this.getQtyPurchased();
    }

    public String toString() {
        return product.getProductId() + " " + product.getProductDescription()
                + " " + product.getPrice() + " " + this.getQtyPurchased()
                + " " + this.getSubTotal() + " "
                + product.getDiscountStrategy().getAmountSaved(product.getPrice(),
                        this.getQtyPurchased());
    }
//    public static void main(String[] args) {
//        Product product = new Product("A101", "Hat", 10.00, new PercentOffDiscount(.1));
//        
//        LineItem lineItem = new LineItem(product, 5);
//        
//        System.out.println(lineItem.toString());
//    }
}
