import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 18, 2, -1);

        Integer minInt = ListUtils.getMin(list);
        Integer maxInt = ListUtils.getMax(list);

        System.out.println(minInt);
        System.out.println();
        System.out.println(maxInt);
    }
}