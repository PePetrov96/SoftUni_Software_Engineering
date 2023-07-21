package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "mechanic")
@XmlAccessorType(XmlAccessType.FIELD)
public class TaskMechanicCreateDTO {
    @XmlElement(name = "firstName")
    private String firstName;

    public TaskMechanicCreateDTO(String firstName) {
        this.firstName = firstName;
    }

    public TaskMechanicCreateDTO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
