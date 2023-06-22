package exam.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "shop")
@XmlAccessorType(XmlAccessType.FIELD)
public class ShopCreateDTO {
    @XmlElement(name = "address")
    @Size(min = 4)
    private String address; //length value higher than or equal to 4

    @XmlElement(name = "employee-count")
    @Min(value = 1)
    @Max(value = 50)
    private Integer employeeCount; //values that are between 1 and 50 inclusive

    @XmlElement(name = "income")
    @DecimalMin(value = "20000")
    private BigDecimal income; //number values that are more than or equal to 20000

    @XmlElement(name = "name")
    @Size(min = 4)
    private String name; //length value higher than or equal to 4

    @XmlElement(name = "shop-area")
    @Min(value = 150)
    private Integer shopArea; //values that are more than or equal to 150

    @XmlElement(name = "town")
    private ShopTownDTO town;
}
