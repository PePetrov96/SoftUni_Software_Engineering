import org.junit.Test;
import zoo.entities.animals.Animal;
import zoo.entities.animals.AquaticAnimal;
import zoo.entities.areas.Area;
import zoo.entities.areas.WaterArea;

public class TestOutPut {
    @Test
    public void checkOutput() {
        Area ocean = new WaterArea("Atlantic");
        Animal whale = new AquaticAnimal("Willy", "Whale", 2000);
        Animal shark = new AquaticAnimal("Kevin", "Shark", 1700);
        Animal ton = new AquaticAnimal("Mike", "ton", 1000);

        ocean.addAnimal(whale);
        ocean.addAnimal(shark);
        ocean.addAnimal(ton);

        System.out.println(ocean.getInfo());
        System.out.println(ocean.getInfo());
    }
}