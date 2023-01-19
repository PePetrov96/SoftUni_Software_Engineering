package football;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FootballTeamTests {
    public FootballTeam footballTeam;
    public Footballer footballer;

    @Before
    public void initialize_Constructors() {
        this.footballTeam = new FootballTeam("Barcelona", 3);
        this.footballer = new Footballer("Messi");
    }

    @Test
    public void constructor_Successfully_Initialized() {
        Assert.assertNotNull(this.footballTeam);
        Assert.assertNotNull(this.footballer);
    }

    @Test
    public void team_Getters_Correct_Values() {
        Assert.assertEquals("Barcelona", this.footballTeam.getName());
        Assert.assertEquals(3, this.footballTeam.getVacantPositions());
    }

    @Test
    public void size_Register_With_Adding_And_Removing_Players() {
        Assert.assertEquals(0 , this.footballTeam.getCount());

        this.footballTeam.addFootballer(footballer);
        Assert.assertEquals(1 , this.footballTeam.getCount());

        this.footballTeam.removeFootballer(footballer.getName());
        Assert.assertEquals(0 , this.footballTeam.getCount());
    }

    @Test
    public void getters_Work() {
        Assert.assertEquals(footballTeam.getVacantPositions(), 3);
        Assert.assertEquals(footballTeam.getName(), "Barcelona");
    }

    @Test(expected = NullPointerException.class)
    public void cannot_Set_Null_Or_Empty_Name() {
        FootballTeam test = new FootballTeam("", 3);
        FootballTeam test2 = new FootballTeam(null, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannot_Negative_Count() {
        FootballTeam test = new FootballTeam("Barcelona", -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannot_Add_More_Than_The_Allowed_Amount_Of_Players() {
        this.footballTeam.addFootballer(footballer);
        this.footballTeam.addFootballer(footballer);
        this.footballTeam.addFootballer(footballer);
        this.footballTeam.addFootballer(footballer);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannot_Remove_Null_Player() {
        this.footballTeam.removeFootballer("Ronaldo");
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannot_Return_Null_Player() {
        this.footballTeam.footballerForSale("Ronaldo");
    }

    @Test
    public void selling_Footballers_Works() {
        Assert.assertTrue(this.footballer.isActive());

        this.footballTeam.addFootballer(this.footballer);
        this.footballTeam.footballerForSale("Messi");

        Assert.assertFalse(this.footballer.isActive());
    }

    @Test
    public void statistics_Work() {
        this.footballTeam.addFootballer(this.footballer);

        Assert.assertEquals("The footballer Messi is in the team Barcelona.", this.footballTeam.getStatistics());
    }
}