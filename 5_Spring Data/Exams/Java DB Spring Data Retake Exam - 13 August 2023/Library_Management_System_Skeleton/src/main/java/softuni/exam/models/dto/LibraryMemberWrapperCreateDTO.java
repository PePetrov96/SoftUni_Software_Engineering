package softuni.exam.models.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter @Setter @NoArgsConstructor
@XmlRootElement(name = "member")
@XmlAccessorType(XmlAccessType.FIELD)
public class LibraryMemberWrapperCreateDTO {
    @XmlElement(name = "id")
    private Integer id;
}
