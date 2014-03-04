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
public class FakeDatabase {

    private Customer[] customers = {new Customer("1", "Josh Pretty", "1002 East Block", "Elgin", "IL", "34492"),
        new Customer("2", "Katy Purry", "800 West Palm Beach", "Madison", "WI", "53102"),
        new Customer("3", "Justin Bieber", "899 IwishIwasCool", "wannabe", "Ca", "11111")
    };

    Product[] products = {
        new Product("1", "Women's Sweatshirt", 19.95, new EasterHolidayDiscount(.30)),
        new Product("2", "Men's T-Shirt", 3.25, new QtyDiscount(.10, 3)),
        new Product("3", "Men's Shoes", 29.99, new NoDiscount()),
        new Product("4", "Woman's T-Shirt", 24.75, new NoDiscount()),
        new Product("5", "Women's Scarf", 5.00, new QtyDiscount(.50, 2))};

    public final Customer findCustomer(final String custId) {

        Customer customer = null;
        for (Customer c : customers) {
            if (custId.equals(c.getCustomerId())) {
                customer = c;
                break;
            }
        }
        return customer;
    }

    public final Product findProduct(final String prodId) {

        Product product = null;
        for (Product p : products) {
            if (prodId.equals(p.getProductId())) {
                product = p;
                break;
            }
        }
        return product;
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }
}
