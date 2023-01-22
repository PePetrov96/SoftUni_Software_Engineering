package petStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class PetStoreTests {
    public Animal dog;
    public PetStore petStore;

    @Before
    public void initialize() {
        dog = new Animal("dog", 30, 25.50);
        petStore = new PetStore();
    }

    @Test
    public void constructorsWorking() {
        Assert.assertNotNull(dog);
        Assert.assertNotNull(petStore);
    }

    @Test
    public void animal_Getters_Working() {
        Assert.assertEquals("dog", dog.getSpecie());
        Assert.assertEquals(30, dog.getMaxKilograms());
        Assert.assertEquals(25.50, dog.getPrice(), 25.50);
    }

    @Test
    public void petStore_List_Initialized() {
        Assert.assertEquals(0, petStore.getAnimals().size());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void petStore_List_Unmodifiable() {
        petStore.getAnimals().add(dog);
    }

    @Test
    public void petStore_Can_Add_Animals() {
        Assert.assertEquals(0, petStore.getCount());
        petStore.addAnimal(dog);
        Assert.assertEquals(1, petStore.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void petStore_Cannot_Add_Null_Animals() {
        petStore.addAnimal(null);
    }

    @Test
    public void petStore_Animal_By_Kilogram_Works() {
        Animal animal1 = new Animal("snake", 30, 25.50);
        Animal animal2 = new Animal("snake", 40, 35.50);
        Animal animal3 = new Animal("dog", 50, 45.50);
        Animal animal4 = new Animal("cat", 60, 55.50);
        Animal animal5 = new Animal("lizard", 70, 65.50);

        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);
        petStore.addAnimal(animal3);
        petStore.addAnimal(animal4);
        petStore.addAnimal(animal5);

        List<Animal> animalsList = petStore.findAllAnimalsWithMaxKilograms(55);

        Assert.assertEquals(2, animalsList.size());
        Assert.assertEquals(animal4, animalsList.get(0));
        Assert.assertEquals(animal5, animalsList.get(1));
    }

    @Test
    public void petStore_Animal_By_Species_Works() {
        Animal animal1 = new Animal("snake", 30, 25.50);
        Animal animal2 = new Animal("snake", 40, 35.50);
        Animal animal3 = new Animal("snake", 50, 45.50);
        Animal animal4 = new Animal("cat", 60, 55.50);
        Animal animal5 = new Animal("lizard", 70, 65.50);

        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);
        petStore.addAnimal(animal3);
        petStore.addAnimal(animal4);
        petStore.addAnimal(animal5);

        List<Animal> animalsList = petStore.findAllAnimalBySpecie("snake");

        Assert.assertEquals(3, animalsList.size());
        Assert.assertEquals(animal1, petStore.getAnimals().get(0));
        Assert.assertEquals(animal2, petStore.getAnimals().get(1));
        Assert.assertEquals(animal3, petStore.getAnimals().get(2));
    }

    @Test
    public void petStore_Get_Most_Expensive_Animal_Works() {
        Animal animal1 = new Animal("snake", 30, 25.50);
        Animal animal2 = new Animal("snake", 40, 35.50);
        Animal animal3 = new Animal("snake", 50, 45.50);
        Animal animal4 = new Animal("cat", 60, 55.50);
        Animal animal5 = new Animal("lizard", 70, 65.50);

        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);
        petStore.addAnimal(animal3);
        petStore.addAnimal(animal4);
        petStore.addAnimal(animal5);

        Animal mostExpensive = petStore.getTheMostExpensiveAnimal();

        Assert.assertEquals(animal5, mostExpensive);
    }
}