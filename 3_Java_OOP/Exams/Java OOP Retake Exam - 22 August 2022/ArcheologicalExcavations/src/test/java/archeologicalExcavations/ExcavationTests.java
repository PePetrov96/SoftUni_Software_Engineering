package archeologicalExcavations;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExcavationTests {
    private Archaeologist archaeologist;
    private Excavation excavation;

    @Before
    public void initializeArcheologist() {
        archaeologist = new Archaeologist("Ivan", 200);
        excavation = new Excavation("MountEverest", 2);

        excavation.addArchaeologist(archaeologist);
    }

    @Test
    public void constructor_ShouldSetSuccessfullyValues() {
        Assert.assertEquals(2, excavation.getCapacity());
        Assert.assertEquals("MountEverest", excavation.getName());
    }

    @Test
    public void getCorrectCount() {
        Assert.assertEquals(1, excavation.getCount());
    }

    @Test
    public void getCorrectNameAndEnergy() {
        Assert.assertEquals("Ivan", archaeologist.getName());
        Assert.assertEquals(200.0, archaeologist.getEnergy(), 200.0);
    }

    @Test
    public void removesArcheologistAndReturnsTrue() {
        Assert.assertTrue(excavation.removeArchaeologist("Ivan"));
        Assert.assertEquals(0, excavation.getCount());
    }

    @Test
    public void removesArcheologistAndReturnsFalse() {
        Assert.assertFalse(excavation.removeArchaeologist("Gosho"));
        Assert.assertEquals(1, excavation.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotSetCapacityBelowZeroExcavation() {
        Excavation excavation2 = new Excavation("Test", -1);
    }

    @Test(expected = NullPointerException.class)
    public void cannotSetNameToEmptyExcavation() {
        Excavation excavation2 = new Excavation(" ", 1);
    }

    @Test(expected = NullPointerException.class)
    public void cannotSetNameToNullExcavation() {
        Excavation excavation2 = new Excavation(null, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotAddTheSameArcheologist() {
        archaeologist = new Archaeologist("Ivan", 200);
        excavation.addArchaeologist(archaeologist);
        excavation.addArchaeologist(archaeologist);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotGoOverTheCapacity() {
        Archaeologist archaeologist1 = new Archaeologist("Gosho", 200);
        Archaeologist archaeologist2 = new Archaeologist("Kiro", 200);

        excavation.addArchaeologist(archaeologist1);
        excavation.addArchaeologist(archaeologist2);
    }

    @Test
    public void getProperCount() {
        Assert.assertEquals(1, excavation.getCount());
    }

    @Test
    public void canCreateArchaeologist() {
        Archaeologist archaeologist1 = new Archaeologist("Ivan", 20);
        Assert.assertNotNull(archaeologist1 );
    }

    @Test(expected = IllegalArgumentException.class)
    public void addMethod_ShouldThrowsExceptionForDuplicateAstronaut() {
        Excavation excavation = new Excavation("Misionis", 2);
        Archaeologist archaeologist = new Archaeologist("Mike", 20);

        excavation.addArchaeologist(archaeologist);
        excavation.addArchaeologist(archaeologist);
    }
}