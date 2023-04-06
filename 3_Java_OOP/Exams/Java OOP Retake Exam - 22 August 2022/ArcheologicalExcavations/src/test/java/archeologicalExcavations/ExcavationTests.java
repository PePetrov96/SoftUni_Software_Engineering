package archeologicalExcavations;

import org.junit.Assert;
import org.junit.Test;

public class ExcavationTests {
    private Archaeologist arch1 = new Archaeologist("Ivan", 200);
    private Archaeologist arch2 = new Archaeologist("Kiro", 100);
    private Archaeologist arch3 = new Archaeologist("Petko", 300);
    private Excavation excavation = new Excavation("Everest", 2);

    @Test
    public void excavation_correct_initializing(){
        Assert.assertEquals(0, excavation.getCount());
        Assert.assertEquals("Everest", excavation.getName());
        Assert.assertEquals(2, excavation.getCapacity());
    }

    @Test
    public void excavation_correct_get_count(){
        Assert.assertEquals(0, excavation.getCount());
        excavation.addArchaeologist(arch1);
        Assert.assertEquals(1, excavation.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void excavation_cannot_set_null_name(){
        Excavation excavation1 = new Excavation(null, 20);
    }

    @Test(expected = NullPointerException.class)
    public void excavation_cannot_set_empty_name(){
        Excavation excavation1 = new Excavation(" ", 20);
    }

    @Test(expected = IllegalArgumentException.class)
    public void excavation_cannot_set_negative_capacity(){
        Excavation excavation1 = new Excavation("Everest", -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void excavation_cannot_add_more_than_the_capacity(){
        excavation.addArchaeologist(arch1);
        excavation.addArchaeologist(arch2);
        excavation.addArchaeologist(arch3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void excavation_cannot_add_the_same_archeologist_twice(){
        excavation.addArchaeologist(arch1);
        excavation.addArchaeologist(arch1);
    }

    @Test
    public void excavation_remove_archeologist_(){
        excavation.addArchaeologist(arch1);
        Assert.assertTrue(excavation.removeArchaeologist(arch1.getName()));
        Assert.assertFalse(excavation.removeArchaeologist(arch1.getName()));
    }
}