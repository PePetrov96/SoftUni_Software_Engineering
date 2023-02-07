package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HeroRepositoryTests {
    private Hero hero;
    private HeroRepository heroRepository;

    @Before
    public void initialize(){
        hero = new Hero("Ivan", 100);
        heroRepository = new HeroRepository();
    }

    @Test
    public void successfully_Initialized_Hero(){
        Assert.assertNotNull(hero);
        Assert.assertEquals("Ivan", hero.getName());
        Assert.assertEquals(100, hero.getLevel());
    }

    @Test
    public void successfully_Initialized_HeroRepository(){
        Assert.assertNotNull(heroRepository);
        Assert.assertEquals(0, heroRepository.getCount());
        Assert.assertNotNull(heroRepository.getHeroes());
    }

    @Test
    public void create_Hero_Works(){
        String expected = "Successfully added hero Ivan with level 100";
        String actual = heroRepository.create(hero);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void remove_Hero_Works(){
        heroRepository.create(hero);

        Assert.assertTrue(heroRepository.remove("Ivan"));
        Assert.assertFalse(heroRepository.remove("Kiro"));
    }

    @Test
    public void get_Hero_With_Highest_Level_Works(){
        Hero hero1 = new Hero("Kiro", 100);
        Hero hero2 = new Hero("Misho", 200);
        Hero hero3 = new Hero("Best", 300);

        heroRepository.create(hero1);
        heroRepository.create(hero2);
        heroRepository.create(hero3);

        Hero best = heroRepository.getHeroWithHighestLevel();

        Assert.assertEquals(best, hero3);
    }

    @Test
    public void get_Hero_Works(){
        Hero test = heroRepository.getHero("Ivan");
        Assert.assertNull(test);

        heroRepository.create(hero);

        Hero test2 = heroRepository.getHero("Ivan");
        Assert.assertEquals(test2, hero);
    }

    @Test
    public void heroRepository_Count_Works(){
        Assert.assertEquals(0, heroRepository.getCount());
        heroRepository.create(hero);
        Assert.assertEquals(1, heroRepository.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void cannot_Remove_Null_Name(){
        heroRepository.remove(null);
    }

    @Test(expected = NullPointerException.class)
    public void cannot_Remove_Empty_Name(){
        heroRepository.remove(" ");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void heroRepository_Returns_Unmodifiable_Collection(){
        heroRepository.getHeroes().add(hero);
    }

    @Test(expected = NullPointerException.class)
    public void cannot_Add_Null_Hero(){
        heroRepository.create(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannot_Add_Existing_Hero(){
        heroRepository.create(hero);
        heroRepository.create(hero);
    }
}
