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
public class Customer {

    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private double qtyPurchased;

    public Customer(String name, String address, String city, String state, String zip, double qtyPurchased) {
        setName(name);
        setAddress(address);
        setCity(city);
        setState(state);
        setZip(zip);
        setQtyPurchased(qtyPurchased);
    }

    public final String getName() {
        return name;
    }

    public final void setName(final String name) {
        this.name = name;
    }

    public final String getAddress() {
        return address;
    }

    public final void setAddress(final String address) {
        this.address = address;
    }

    public final String getCity() {
        return city;
    }

    public final void setCity(final String city) {
        this.city = city;
    }

    public final String getState() {
        return state;
    }

    public final void setState(final String state) {
        this.state = state;
    }

    public final String getZip() {
        return zip;
    }

    public final void setZip(final String zip) {
        this.zip = zip;
    }

    public final double getQtyPurchased() {
        return qtyPurchased;
    }

    public final void setQtyPurchased(final double qtyPurchased) {
        this.qtyPurchased = qtyPurchased;
    }
}
