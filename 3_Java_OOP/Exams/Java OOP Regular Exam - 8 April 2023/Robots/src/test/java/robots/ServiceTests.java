package robots;

import org.junit.Assert;
import org.junit.Test;

public class ServiceTests {
    public Robot robot1 = new Robot("Ivan");
    public Robot robot2 = new Robot("Kiro");
    public Robot robot3 = new Robot("Pesho");
    public Service service = new Service("Robocops", 2);

    @Test
    public void service_initialized_correctly(){
        Assert.assertEquals("Ivan", robot1.getName());
        Assert.assertTrue(robot1.isReadyForSale());

        Assert.assertEquals("Kiro", robot2.getName());
        Assert.assertTrue(robot2.isReadyForSale());

        Assert.assertEquals("Pesho", robot3.getName());
        Assert.assertTrue(robot3.isReadyForSale());

        Assert.assertEquals(2, service.getCapacity());
        Assert.assertEquals(0, service.getCount());
        Assert.assertEquals("Robocops", service.getName());
    }

    @Test
    public void adding_robots_to_service_registers_count(){
        Assert.assertEquals(0, service.getCount());
        service.add(robot1);
        Assert.assertEquals(1, service.getCount());
    }

    @Test
    public void removing_robots_to_service_registers_count(){
        Assert.assertEquals(0, service.getCount());
        service.add(robot1);
        Assert.assertEquals(1, service.getCount());
        service.remove(robot1.getName());
        Assert.assertEquals(0, service.getCount());
    }

    @Test
    public void can_set_robot_up_for_sale(){
        service.add(robot1);
        Assert.assertEquals(robot1, service.forSale(robot1.getName()));
        Assert.assertFalse(robot1.isReadyForSale());
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannot_add_more_robots_than_max_capacity(){
        service.add(robot1);
        service.add(robot2);
        service.add(robot3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannot_remove_non_existing_robot(){
        service.remove("Ivan");
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannot_sell_non_existing_robot(){
        service.forSale(robot1.getName());
    }

    @Test
    public void report_works_correctly(){
        service.add(robot1);
        service.add(robot2);
        Assert.assertEquals("The robot Ivan, Kiro is in the service Robocops!", service.report());
    }

    @Test(expected = NullPointerException.class)
    public void cannot_set_null_name_for_service(){
        Service service1 = new Service(null, 3);
    }

    @Test(expected = NullPointerException.class)
    public void cannot_set_empty_name_for_service(){
        Service service1 = new Service("  ", 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannot_set_negative_capacity_for_service(){
        Service service1 = new Service("Robots", -13);
    }
}