public class Car {
    private String brand;
    private String model;
    private int horsePower = 500;
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getBrand() {
        return brand;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getModel() {
        return model;
    }
    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
    public int getHorsePower() {
        return horsePower;
    }
    public String carInfo() {
        return String.format("The car is: %s %s - %d HP.", getBrand(), getModel(), getHorsePower());
    }
}