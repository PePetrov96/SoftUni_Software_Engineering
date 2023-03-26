package toyStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ToyStoryTest {
    private Toy toy1;
    private Toy toy2;
    private Toy toy3;
    private ToyStore toyStore;

    @Before
    public void initialize(){
        toy1 = new Toy("Lego", "1");
        toy2 = new Toy("Mego", "2");
        toy3 = new Toy("Neggo", "3");
        toyStore = new ToyStore();
    }

    @Test
    public void initialize_correctly_toys(){
        Assert.assertNotNull(toy1);
        Assert.assertEquals("Lego", toy1.getManufacturer());
        Assert.assertEquals("1", toy1.getToyId());

        Assert.assertNotNull(toy2);
        Assert.assertEquals("Mego", toy2.getManufacturer());
        Assert.assertEquals("2", toy2.getToyId());

        Assert.assertNotNull(toy1);
        Assert.assertEquals("Neggo", toy3.getManufacturer());
        Assert.assertEquals("3", toy3.getToyId());
    }

    @Test
    public void initialize_correctly_toyStore(){
        Assert.assertNotNull(toyStore);
        Assert.assertNull(toyStore.getToyShelf().get("A"));
        Assert.assertNull(toyStore.getToyShelf().get("B"));
        Assert.assertNull(toyStore.getToyShelf().get("C"));
        Assert.assertNull(toyStore.getToyShelf().get("D"));
        Assert.assertNull(toyStore.getToyShelf().get("E"));
        Assert.assertNull(toyStore.getToyShelf().get("F"));
        Assert.assertNull(toyStore.getToyShelf().get("G"));
    }

    @Test
    public void can_add_toys() throws OperationNotSupportedException {
        Assert.assertEquals("Toy:1 placed successfully!", toyStore.addToy("A", toy1));
        Assert.assertEquals("1",toyStore.getToyShelf().get("A").getToyId());
        Assert.assertNotNull(toyStore.getToyShelf().get("A"));
    }

    @Test
    public void can_remove_toys() throws OperationNotSupportedException {
        Assert.assertEquals("Toy:1 placed successfully!", toyStore.addToy("A", toy1));
        Assert.assertEquals("Remove toy:1 successfully!", toyStore.removeToy("A", toy1));
        Assert.assertNull(toyStore.getToyShelf().get("A"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void returns_unmodifiable_map(){
        toyStore.getToyShelf().put("Z", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannot_add_on_non_existing_shelf() throws OperationNotSupportedException {
        toyStore.addToy("Z", toy1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannot_add_on_non_empty_shelf() throws OperationNotSupportedException {
        toyStore.addToy("A", toy1);
        toyStore.addToy("A", toy2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannot_add_same_item_on_shelf() throws OperationNotSupportedException {
        toyStore.addToy("A", toy1);
        toyStore.addToy("A", toy1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannot_remove_from_non_existing_shelf() {
        toyStore.removeToy("Z", toy1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannot_remove_non_existing_toy_from_shelf() {
        toyStore.removeToy("A", toy1);
    }
}