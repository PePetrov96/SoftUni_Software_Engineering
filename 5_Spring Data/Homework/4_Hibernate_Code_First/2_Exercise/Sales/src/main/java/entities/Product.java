package entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    private long id;
    private String name;
    private int quantity;
    private BigDecimal price;
    private Set<Sale> sales = new HashSet<>();

    public Product() {
    }

    public Product(String name, int quantity, BigDecimal price) {
        setName(name);
        setQuantity(quantity);
        setPrice(price);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    @OneToMany(mappedBy = "product")
    public Set<Sale> getSales() {
        return sales;
    }

    private void setId(long id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private void setPrice(BigDecimal price) {
        this.price = price;
    }

    private void setSales(Set<Sale> sales) {
        this.sales = sales;
    }
}