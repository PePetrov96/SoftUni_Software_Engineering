package entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sale")
public class Sale {
    private long id;
    private Product product;
    private Customer customer;
    private StoreLocation storeLocation;
    private LocalDateTime date;

    public Sale() {}

    public Sale(Product product, Customer customer, StoreLocation storeLocation, LocalDateTime date) {
        setProduct(product);
        setCustomer(customer);
        setStoreLocation(storeLocation);
        setDate(date);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    @ManyToOne
    public Product getProduct() {
        return product;
    }

    @ManyToOne
    public Customer getCustomer() {
        return customer;
    }

    @ManyToOne
    public StoreLocation getStoreLocation() {
        return storeLocation;
    }

    public LocalDateTime getDate() {
        return date;
    }

    private void setId(long id) {
        this.id = id;
    }

    private void setProduct(Product product) {
        this.product = product;
    }

    private void setCustomer(Customer customer) {
        this.customer = customer;
    }

    private void setStoreLocation(StoreLocation store_location) {
        this.storeLocation = store_location;
    }

    private void setDate(LocalDateTime date) {
        this.date = date;
    }
}