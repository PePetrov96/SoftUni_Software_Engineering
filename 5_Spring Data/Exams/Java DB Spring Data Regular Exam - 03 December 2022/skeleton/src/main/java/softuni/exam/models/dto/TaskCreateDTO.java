package softuni.exam.models.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "task")
@XmlAccessorType(XmlAccessType.FIELD)
public class TaskCreateDTO {
    @XmlElement(name = "date")
    @NotNull
    private String date;

    @XmlElement(name = "price")
    @DecimalMin(value = "1.00")
    @NotNull
    private BigDecimal price;

    @XmlElement(name = "car")
    @NotNull
    private TaskCarCreateDTO car;

    @XmlElement(name = "mechanic")
    @NotNull
    private TaskMechanicCreateDTO mechanic;

    @XmlElement(name = "part")
    @NotNull
    private TaskPartCreateDTO part;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public TaskCarCreateDTO getCar() {
        return car;
    }

    public void setCar(TaskCarCreateDTO car) {
        this.car = car;
    }

    public TaskMechanicCreateDTO getMechanic() {
        return mechanic;
    }

    public void setMechanic(TaskMechanicCreateDTO mechanic) {
        this.mechanic = mechanic;
    }

    public TaskPartCreateDTO getPart() {
        return part;
    }

    public void setPart(TaskPartCreateDTO part) {
        this.part = part;
    }
}
