package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FarmvilleTests {
    public Animal animal;
    public Farm farm;

    @Before
    public void initialize() {
        animal = new Animal("cow", 200);
        farm = new Farm("cityFarm", 3);
    }

    @Test
    public void check_If_Animal_Initialized_Correctly() {
        Assert.assertNotNull(animal);

        Assert.assertEquals("cow", animal.getType());
        Assert.assertEquals(200, animal.getEnergy(), 200);
    }

    @Test
    public void check_If_Farm_Initialized_Correctly() {
        Assert.assertNotNull(farm);

        Assert.assertEquals("cityFarm", farm.getName());
        Assert.assertEquals(3, farm.getCapacity());
        Assert.assertEquals(0, farm.getCount());
    }

    @Test
    public void can_Add_Animal_In_Farm() {
        Assert.assertEquals(0, farm.getCount());
        farm.add(animal);
        Assert.assertEquals(1, farm.getCount());
    }

    @Test
    public void return_True_On_Removing_Successfully_Animal_Farm() {
        farm.add(animal);
        Assert.assertTrue(farm.remove(animal.getType()));
        Assert.assertEquals(0, farm.getCount());
        Assert.assertFalse(farm.remove(animal.getType()));
    }

    @Test
    public void return_False_On_Removing_Unsuccessfully_Animal_Farm() {
        Assert.assertFalse(farm.remove(animal.getType()));
    }

    @Test(expected = NullPointerException.class)
    public void cannot_Set_Null_Name_For_Farm() {
        Farm farm1 = new Farm(null, 1);
    }

    @Test(expected = NullPointerException.class)
    public void cannot_Set_Empty_Name_For_Farm() {
        Farm farm1 = new Farm("   ", 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannot_Negative_Capacity_For_Farm() {
        Farm farm1 = new Farm("Farm", -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannot_Add_Duplicate_Animal_In_Farm() {
        farm.add(animal);
        farm.add(animal);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannot_Add_Above_Animals_Above_Limit_In_Farm() {
        Animal animal1 = new Animal("chicken", 100);
        Animal animal2 = new Animal("sheep", 200);
        Animal animal3 = new Animal("bull", 300);
        Animal animal4 = new Animal("roster", 400);

        farm.add(animal1);
        farm.add(animal2);
        farm.add(animal3);
        farm.add(animal4);
    }
}