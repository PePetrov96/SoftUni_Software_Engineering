package Task_2_Car_Shop_Extended;

public interface Rentable extends Car{
    Integer getMinRentDay();
    Double getPricePerDay();
}