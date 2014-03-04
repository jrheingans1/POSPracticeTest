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

    private String CustomerId;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;

    public Customer(String customerId, String name, String address, String city, String state, String zip) {
        setCustomerId(customerId);
        setName(name);
        setAddress(address);
        setCity(city);
        setState(state);
        setZip(zip);

    }

    public final String getCustomerId() {
        return CustomerId;
    }

    public final void setCustomerId(String CustomerId) {
        this.CustomerId = CustomerId;
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

}
