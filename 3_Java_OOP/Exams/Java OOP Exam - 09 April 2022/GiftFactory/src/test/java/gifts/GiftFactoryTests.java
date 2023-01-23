package gifts;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GiftFactoryTests {
    Gift gift;
    GiftFactory giftFactory;

    @Before
    public void initialize() {
        gift = new Gift("present", 200.0);
        giftFactory = new GiftFactory();
    }

    @Test
    public void check_Constructor_Gift() {
        Assert.assertNotNull(gift);
        Assert.assertEquals("present", gift.getType());
        Assert.assertEquals(200.0, gift.getMagic(), 200.0);
    }

    @Test
    public void check_Constructor_GiftFactory() {
        Assert.assertNotNull(giftFactory);
        Assert.assertNotNull(giftFactory.getPresents());
        Assert.assertEquals(0, giftFactory.getCount());
    }

    @Test
    public void can_Add_New_Gift() {
        String match = String.format("Successfully added gift %s with magic %.2f.", gift.getType(), gift.getMagic());

        Assert.assertEquals(match, giftFactory.createGift(gift));

        Assert.assertEquals(gift, giftFactory.getPresent(gift.getType()));

        Assert.assertEquals(1, giftFactory.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannot_Add_Non_Unique_Gifts() {
        giftFactory.createGift(gift);
        giftFactory.createGift(gift);
    }

    @Test
    public void can_Remove_Gift() {
        giftFactory.createGift(gift);

        Assert.assertTrue(giftFactory.removeGift(gift.getType()));
        Assert.assertFalse(giftFactory.removeGift(gift.getType()));
    }

    @Test(expected = NullPointerException.class)
    public void cannot_Remove_Null_Gift() {
        giftFactory.removeGift(null);
    }

    @Test(expected = NullPointerException.class)
    public void cannot_Remove_Empty_Gift() {
        giftFactory.removeGift(" ");
    }

    @Test
    public void present_With_Least_Magic_Is_Correct() {
        Assert.assertNull(giftFactory.getPresentWithLeastMagic());

        Gift gift1 = new Gift("first", 200.0);
        Gift gift2 = new Gift("second", 400.0);
        Gift gift3 = new Gift("third", 100.0);

        giftFactory.createGift(gift1);
        giftFactory.createGift(gift2);
        giftFactory.createGift(gift3);

        Assert.assertEquals(gift3, giftFactory.getPresentWithLeastMagic());
    }

    @Test
    public void present_Is_Correct() {
        Assert.assertNull(giftFactory.getPresent("first"));

        Gift gift1 = new Gift("first", 200.0);
        Gift gift2 = new Gift("second", 400.0);
        Gift gift3 = new Gift("third", 100.0);

        giftFactory.createGift(gift1);
        giftFactory.createGift(gift2);
        giftFactory.createGift(gift3);

        Assert.assertEquals(gift2, giftFactory.getPresent("second"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void returns_Unmodifiable_Collection() {
        giftFactory.getPresents().add(gift);
    }
}