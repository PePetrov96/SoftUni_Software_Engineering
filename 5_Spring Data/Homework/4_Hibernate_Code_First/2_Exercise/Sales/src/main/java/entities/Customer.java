package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {
    private long id;
    private String name;
    private String email;
    private String creditCardNumber;
    private Set<Sale> sales = new HashSet<>();

    public Customer() {
    }

    public Customer(String name, String email, String creditCardNumber) {
        setName(name);
        setEmail(email);
        setCreditCardNumber(creditCardNumber);
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
    @Column(name = "email")
    public String getEmail() {
        return email;
    }
    @Column(name = "credit_card_number")
    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    @OneToMany(mappedBy = "customer")
    public Set<Sale> getSales() {
        return sales;
    }

    private void setId(long id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    private void setCreditCardNumber(String credit_card_number) {
        this.creditCardNumber = credit_card_number;
    }

    private void setSales(Set<Sale> sales) {
        this.sales = sales;
    }
}