package softuni.exam.models.dto;

import softuni.exam.models.entity.enums.CarType;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarCreateDTO {
    @XmlElement(name = "carMake")
    @NotNull
    @Size(min = 2, max = 30)
    private String carMake;

    @XmlElement(name = "carModel")
    @NotNull
    @Size(min = 2, max = 30)
    private String carModel;

    @XmlElement(name = "year")
    @NotNull
    @Min(value = 1)
    private Integer year;

    @XmlElement(name = "plateNumber")
    @NotNull
    @Size(min = 2, max = 30)
    private String plateNumber;

    @XmlElement(name = "kilometers")
    @NotNull
    @Min(value = 1)
    private Integer kilometers;

    @XmlElement(name = "engine")
    @NotNull
    @DecimalMin(value = "1.00")
    private Double engine;

    @XmlElement(name = "carType")
    @NotNull
    private CarType carType;

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public Integer getKilometers() {
        return kilometers;
    }

    public void setKilometers(Integer kilometers) {
        this.kilometers = kilometers;
    }

    public Double getEngine() {
        return engine;
    }

    public void setEngine(Double engine) {
        this.engine = engine;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }
}