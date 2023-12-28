package springdatalab.models.service;


import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ShopServiceModel {

    private String name;
    private String address;
    private String town;

    public ShopServiceModel() {
    }

    @NotNull
    @NotEmpty
    @Length(min = 2, message = "Name length must be more than two characters!")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    @NotEmpty
    @Length(min = 2, message = "Address length must be more than two characters!")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @NotNull
    @NotEmpty
    @Length(min = 2, message = "Town name length must be more than two characters!")
    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
