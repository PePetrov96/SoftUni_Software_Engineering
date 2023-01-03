package Task_4_Random_Array_List;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<T> extends ArrayList<T>{
    private final Random rnd = new Random();

    public T getRandomElement() {
        int index = this.rnd.nextInt(super.size());
        T element = super.get(index);
        super.remove(index);
        return element;
    }
}