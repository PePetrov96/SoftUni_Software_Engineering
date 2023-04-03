package toyStore;

import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ToyStoryTest {
    public Toy toy1 = new Toy("Lego", "123ABC");
    public Toy toy2 = new Toy("Dego", "456DEF");
    public ToyStore toyStore = new ToyStore();

    @Test
    public void toyStore_initialized_correctly(){
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
    public void toyStore_can_put_toy_on_shelf() throws OperationNotSupportedException {
        Assert.assertEquals("Toy:123ABC placed successfully!", toyStore.addToy("A", toy1));
    }
    @Test(expected = UnsupportedOperationException.class)
    public void toyStore_returns_unmodifiable_map(){
        toyStore.getToyShelf().put("Z", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void toyStore_cannot_add_toy_on_non_existing_shelf() throws OperationNotSupportedException {
        toyStore.addToy("Z", toy1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void toyStore_cannot_add_toy_on_non_empty_shelf() throws OperationNotSupportedException {
        toyStore.addToy("A", toy1);
        toyStore.addToy("A", toy2);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void toyStore_cannot_add_same_toy_twice_shelf() throws OperationNotSupportedException {
        toyStore.addToy("A", toy1);
        toyStore.addToy("B", toy1);
    }

    @Test
    public void toyStore_can_remove_toy_from_shelf() throws OperationNotSupportedException {
        toyStore.addToy("A", toy1);
        Assert.assertEquals("Remove toy:123ABC successfully!", toyStore.removeToy("A", toy1));
        Assert.assertNull(toyStore.getToyShelf().get("A"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void toyStore_cannot_remove_toy_from_non_existing_shelf() {
        toyStore.removeToy("Z", toy1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void toyStore_cannot_remove_non_existing_toy_from_shelf() {
        toyStore.removeToy("A", toy1);
    }
}