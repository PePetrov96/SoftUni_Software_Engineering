package football;

import football.entities.field.ArtificialTurf;
import football.entities.field.Field;
import football.entities.field.NaturalGrass;
import football.entities.player.Men;
import football.entities.player.Player;
import football.entities.player.Women;
import org.junit.Before;
import org.junit.Test;

public class TestFields {
    Field field1;
    Player player1;
    Field field2;
    Player player2;

    @Before
    public void initialize() {
        field1 = new ArtificialTurf("Asd");
        player1 = new Women("Ivanka", "Bulgarian", 200);

        field2 = new NaturalGrass("Bsd");
        player2 = new Men("Ivan", "Bulgarian", 220);
    }

    @Test
    public void testClassName() {
        System.out.println(field1.getClass().getSimpleName());
        System.out.println(field2.getClass().getSimpleName());
    }
}
