package Task_3_Shopping_Spree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private final List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    public void buyProduct (Product product) {
        if (this.getMoney() < product.getCost()) {
            throw new IllegalArgumentException(String.format("%s can't afford %s%n", this.getName(), product.getName()));
        }
        this.products.add(product);
        this.setMoney(this.getMoney() - product.getCost());
        System.out.printf("%s bought %s%n", this.getName(), product.getName());
    }

    @Override
    public String toString() {
        if (this.getProducts().size() == 0) {
            return String.format("%s - Nothing bought", this.name);
        } else {
            return this.name +
                    " - " +
                    this.getProducts()
                            .stream()
                            .map(Product::toString)
                            .collect(Collectors.joining(", "));
        }
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    private List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }
}