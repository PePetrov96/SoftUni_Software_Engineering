package softuni.exam.models.dto.wrappers;

import softuni.exam.models.dto.CarCreateDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarWrapper {
    @XmlElement(name = "car")
    private List<CarCreateDTO> cars;

    public List<CarCreateDTO> getCars() {
        return cars;
    }

    public void setCars(List<CarCreateDTO> cars) {
        this.cars = cars;
    }
}
