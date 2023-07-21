package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.*;

public class PartCreateDTO {
    @Expose
    @NotNull
    @Size(min = 2, max = 19)
    private String partName;

    @Expose
    @NotNull
    @DecimalMin(value = "10.00")
    @DecimalMax(value = "2000.00")
    private Double price;

    @Expose
    @NotNull
    @Min(value = 1)
    private Integer quantity;

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
