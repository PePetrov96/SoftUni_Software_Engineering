package entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "bikes")
public class Bike extends Vehicle{
    private static final String type = "BIKE";

    public Bike() {
        super(type);
    }

    public Bike(String model, BigDecimal price, String fuelType) {
        this();

        super.setModel(model);
        super.setFuelType(fuelType);
        super.setPrice(price);
    }

}
