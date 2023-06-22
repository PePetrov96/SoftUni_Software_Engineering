package exam.model.dtos;

import com.google.gson.annotations.Expose;
import exam.model.enums.WarrantyType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LaptopCreateDTO {
    @Expose
    @Size(min = 8)
    private String macAddress; //length value higher than 8

    @Expose
    @DecimalMin(value = "1")
    private Double cpuSpeed; //positive floating-point numbers

    @Expose
    @Min(value = 8)
    @Max(value = 128)
    private Integer ram; //values that are more than or equal to 8 and less than or equal to 128

    @Expose
    @Min(value = 128)
    @Max(value = 1024)
    private Integer storage; //values that are more than or equal to 128 and less than or equal to 1024

    @Expose
    @Size(min = 10)
    private String description; //length value higher than or equal to 10

    @Expose
    @DecimalMin(value = "1")
    private BigDecimal price; //positive number

    @Expose
    private WarrantyType warrantyType;

    @Expose
    private LaptopShopCreateDTO shop;
}
