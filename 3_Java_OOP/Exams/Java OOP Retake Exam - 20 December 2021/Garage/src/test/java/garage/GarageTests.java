package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class GarageTests {
    public Car car1;
    public Car car2;
    public Car car3;
    public Garage garage;

    @Before
    public void initialize(){
        car1 = new Car("BMW", 100, 600.0);
        car2 = new Car("VW", 200, 400.0);
        car3 = new Car("BMW", 300, 200.0);

        garage = new Garage();

        garage.addCar(car1);
        garage.addCar(car2);
        garage.addCar(car3);
    }

    @Test
    public void car_Successfully_Initialised(){
        Assert.assertEquals("BMW", car1.getBrand());
        Assert.assertEquals(100, car1.getMaxSpeed());
        Assert.assertEquals(600.0, car1.getPrice(), 600.0);
    }

    @Test
    public void garage_Successfully_Initialised(){
        Assert.assertNotNull(garage.getCars());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void garage_Collection_Unmodifiable(){
        garage.getCars().add(car1);
    }

    @Test
    public void garage_Count_Works(){
        Assert.assertEquals(3, garage.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannot_Add_Null_Car_In_Garage() {
        garage.addCar(null);
    }

    @Test
    public void garage_Find_All_Cars_With_Max_Speed_Above_Works(){
        List<Car> out = garage.findAllCarsWithMaxSpeedAbove(100);

        Assert.assertEquals(car2, out.get(0));
        Assert.assertEquals(car3, out.get(1));
    }

    @Test
    public void garage_Get_Most_Expensive_Car_Works(){
        Car out = garage.getTheMostExpensiveCar();

        Assert.assertEquals(car1, out);
    }

    @Test
    public void garage_Find_All_Cars_By_Brand_Works(){
        List<Car> out = garage.findAllCarsByBrand("BMW");

        Assert.assertEquals(car1, out.get(0));
        Assert.assertEquals(car3, out.get(1));
    }
}