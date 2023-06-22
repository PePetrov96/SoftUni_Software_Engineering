package exam.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "town")
@XmlAccessorType(XmlAccessType.FIELD)
public class TownCreateDTO {
    @XmlElement(name = "name")
    @Size(min = 2)
    private String name; //character length value higher than or equal to 2

    @XmlElement(name = "population")
    @DecimalMin(value = "1")
    private Integer population; //must be positive, 0 as a value is exclusive

    @XmlElement(name = "travel-guide")
    @Size(min = 10)
    private String travelGuide; //character length value higher than or equal to 10
}
