package magicGame;

import org.junit.Assert;
import org.junit.Test;

public class MagicianTests {
    public Magic magic1 = new Magic("Fireball", 10);
    public Magic magic2 = new Magic("Iceball", 20);
    public Magic magic3 = new Magic("Necroblast", 15);

    public Magician magician = new Magician("Kiro", 200);

    @Test
    public void magician_initialized_correctly(){
        Assert.assertNotNull(magician.getMagics());
        Assert.assertEquals(0, magician.getMagics().size());

    }

    @Test
    public void magician_get_username_correct(){
        Assert.assertEquals("Kiro", magician.getUsername());
    }

    @Test
    public void magician_get_health_correct(){
        Assert.assertEquals(200, magician.getHealth());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void magician_returns_unmodifiable_List_of_magics(){
        magician.getMagics().add(magic1);
    }

    @Test
    public void magician_can_add_magic(){
        magician.addMagic(magic1);
        Assert.assertEquals(magic1, magician.getMagic("Fireball"));
        Assert.assertEquals(1, magician.getMagics().size());
    }

    @Test
    public void magician_can_remove_magic(){
        magician.addMagic(magic1);
        Assert.assertEquals(magic1, magician.getMagic("Fireball"));
        Assert.assertEquals(1, magician.getMagics().size());

        Assert.assertTrue(magician.removeMagic(magic1));
        Assert.assertEquals(0, magician.getMagics().size());
    }

    @Test
    public void magician_get_magic_correct(){
        magician.addMagic(magic1);
        Assert.assertEquals(magic1, magician.getMagic("Fireball"));
        Assert.assertNull(magician.getMagic("Iceball123"));
    }

    @Test
    public void magician_takes_damage_correct(){
        Assert.assertEquals(200,magician.getHealth());
        magician.takeDamage(100);
        Assert.assertEquals(100,magician.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void magician_dies_correct(){
        magician.takeDamage(300);
        magician.takeDamage(1);
    }

    @Test(expected = NullPointerException.class)
    public void magician_cannot_set_null_name(){
        Magician magician1 = new Magician(null, 200);
    }

    @Test(expected = NullPointerException.class)
    public void magician_cannot_set_empty_name(){
        Magician magician1 = new Magician("   ", 200);
    }

    @Test(expected = NullPointerException.class)
    public void magician_cannot_add_null_magic(){
        magician.addMagic(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void magician_cannot_set_negative_health(){
        Magician magician1 = new Magician("Ivan", -10);
    }
}