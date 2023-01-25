package cats;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HouseTests {
    public Cat cat;
    public House house;

    @Before
    public void initialize() {
        cat = new Cat("Ketty");
        house = new House("TheCrib", 3);
    }

    @Test
    public void cat_Initialized(){
        Assert.assertNotNull(cat);
        Assert.assertEquals("Ketty", cat.getName());
        Assert.assertTrue(cat.isHungry());
    }

    @Test
    public void house_Initialized(){
        Assert.assertNotNull(house);
        Assert.assertEquals("TheCrib", house.getName());
        Assert.assertEquals(3, house.getCapacity());
    }

    @Test
    public void can_Add_New_Cat_In_House(){
        Assert.assertEquals(0, house.getCount());
        house.addCat(cat);
        Assert.assertEquals(1, house.getCount());
    }

    @Test
    public void can_Remove_Cats_From_House(){
        Assert.assertEquals(0, house.getCount());
        house.addCat(cat);
        Assert.assertEquals(1, house.getCount());
        house.removeCat(cat.getName());
        Assert.assertEquals(0, house.getCount());
    }

    @Test
    public void can_Sell_Cat_In_House(){
        Assert.assertTrue(cat.isHungry());

        house.addCat(cat);
        Cat cat1 = house.catForSale(cat.getName());

        Assert.assertFalse(cat1.isHungry());
        Assert.assertEquals(cat1, cat);
    }

    @Test
    public void house_Statistics_Correct(){
        house.addCat(cat);
        house.addCat(cat);

        String actual = house.statistics();
        String expected = "The cat Ketty, Ketty is in the house TheCrib!";

        Assert.assertEquals(expected, actual);

    }

    @Test(expected = IllegalArgumentException.class)
    public void cannot_Add_Cats_Above_Limit_In_House(){
        house.addCat(cat);
        house.addCat(cat);
        house.addCat(cat);
        house.addCat(cat);
    }

    @Test(expected = NullPointerException.class)
    public void cannot_Set_Null_Name_For_House(){
        House house1 = new House(null, 1);
    }

    @Test(expected = NullPointerException.class)
    public void cannot_Set_Empty_Name_For_House(){
        House house1 = new House("   ", 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannot_Set_Negative_Capacity_For_House(){
        House house1 = new House("House", -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannot_Remove_Invalid_Cat_From_House(){
        house.removeCat("Ivan");
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannot_Sell_Invalid_Cat_From_House(){
        house.catForSale("Ivan");
    }
}
