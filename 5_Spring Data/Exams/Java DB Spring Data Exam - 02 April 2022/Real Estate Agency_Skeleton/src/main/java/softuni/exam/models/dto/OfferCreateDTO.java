package softuni.exam.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.exam.models.dto.wrappers.AgentWrapper;
import softuni.exam.models.dto.wrappers.ApartmentWrapper;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "offer")
@XmlAccessorType(XmlAccessType.FIELD)
public class OfferCreateDTO {
    @XmlElement(name = "price")
    private BigDecimal price;

    @XmlElement
    private AgentWrapper agent;

    @XmlElement
    private ApartmentWrapper apartment;

    @XmlElement(name = "publishedOn")
    private String publishedOn;
}
