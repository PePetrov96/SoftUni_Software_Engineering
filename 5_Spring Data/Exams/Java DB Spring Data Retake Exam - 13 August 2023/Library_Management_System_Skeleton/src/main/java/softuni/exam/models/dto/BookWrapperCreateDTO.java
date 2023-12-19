package softuni.exam.models.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter @Setter @NoArgsConstructor
@XmlRootElement(name = "book")
@XmlAccessorType(XmlAccessType.FIELD)
public class BookWrapperCreateDTO {
    @XmlElement(name = "title")
    private String title;
}
