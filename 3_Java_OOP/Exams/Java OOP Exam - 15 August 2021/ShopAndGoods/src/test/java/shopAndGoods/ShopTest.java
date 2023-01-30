package shopAndGoods;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ShopTest {
    Goods good;
    Shop shop;

    @Before
    public void initialize() {
        good = new Goods("Bread", "QWERTY");
        shop = new Shop();
    }

    @Test
    public void good_Successfully_Initialized() {
        Assert.assertNotNull(good);
    }

    @Test
    public void check_Goods_Getters() {
        Assert.assertEquals("Bread", good.getName());
        Assert.assertEquals("QWERTY", good.getGoodsCode());
    }

    @Test
    public void shop_Successfully_Initialized() {
        Assert.assertNotNull(shop);
        Assert.assertNotNull(shop.getShelves());

        Assert.assertTrue(shop.getShelves().containsKey("Shelves1"));
        Assert.assertNull(shop.getShelves().get("Shelves1"));

        Assert.assertTrue(shop.getShelves().containsKey("Shelves2"));
        Assert.assertNull(shop.getShelves().get("Shelves2"));

        Assert.assertTrue(shop.getShelves().containsKey("Shelves3"));
        Assert.assertNull(shop.getShelves().get("Shelves3"));

        Assert.assertTrue(shop.getShelves().containsKey("Shelves4"));
        Assert.assertNull(shop.getShelves().get("Shelves4"));

        Assert.assertTrue(shop.getShelves().containsKey("Shelves5"));
        Assert.assertNull(shop.getShelves().get("Shelves5"));

        Assert.assertTrue(shop.getShelves().containsKey("Shelves6"));
        Assert.assertNull(shop.getShelves().get("Shelves6"));

        Assert.assertTrue(shop.getShelves().containsKey("Shelves7"));
        Assert.assertNull(shop.getShelves().get("Shelves7"));

        Assert.assertTrue(shop.getShelves().containsKey("Shelves8"));
        Assert.assertNull(shop.getShelves().get("Shelves8"));

        Assert.assertTrue(shop.getShelves().containsKey("Shelves9"));
        Assert.assertNull(shop.getShelves().get("Shelves9"));

        Assert.assertTrue(shop.getShelves().containsKey("Shelves10"));
        Assert.assertNull(shop.getShelves().get("Shelves10"));

        Assert.assertTrue(shop.getShelves().containsKey("Shelves11"));
        Assert.assertNull(shop.getShelves().get("Shelves11"));

        Assert.assertTrue(shop.getShelves().containsKey("Shelves12"));
        Assert.assertNull(shop.getShelves().get("Shelves12"));
    }

    @Test
    public void shop_Can_Add_New_Good_On_Shelf() throws OperationNotSupportedException {
        Assert.assertEquals("Goods: QWERTY is placed successfully!", shop.addGoods("Shelves1", good));
        Assert.assertNotNull(shop.getShelves().get("Shelves1"));
    }

    @Test
    public void shop_Can_Remove_Good_On_Shelf() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", good);
        Assert.assertEquals("Goods: QWERTY is removed successfully!", shop.removeGoods("Shelves1", good));
        Assert.assertNull(shop.getShelves().get("Shelves1"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shop_Returns_Unmodifiable_Map() {
        shop.getShelves().put("Shelves13", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannot_Add_Goods_To_Non_Existing_Shelf() throws OperationNotSupportedException {
        shop.addGoods("Shelves13", good);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannot_Add_Goods_To_Non_Null_Shelf() throws OperationNotSupportedException {
        shop.addGoods("Shelves12", good);

        Goods good2 = new Goods("Rice", "WERTY");

        shop.addGoods("Shelves12", good2);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void cannot_Add_Same_Good_Twice_On_Shelf() throws OperationNotSupportedException {
        shop.addGoods("Shelves12", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannot_Remove_Non_Existing_Good_From_Shelf() {
        shop.removeGoods("Shelves12", good);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannot_Remove_Incorrect_Good_From_Shelf() throws OperationNotSupportedException {
        Goods good1 = new Goods("Rice", "WERTY");
        shop.addGoods("Shelves1", good);
        shop.removeGoods("Shelves1", good1);
    }
}