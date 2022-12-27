import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lake implements Iterable<Integer>{
    List<Integer> list;

    public Lake(String input) {
        this.list = new ArrayList<>(Arrays.stream(input.split("\\s*,\\s+")).map(Integer::parseInt).collect(Collectors.toList()));
    }

    public void jump() {
        List<Integer> result = new ArrayList<>();
        IntStream.range(0, this.list.size()).filter(i -> i % 2 == 0).forEach(i -> result.add(this.list.get(i)));
        IntStream.range(0, this.list.size()).filter(i -> i % 2 != 0).forEach(i -> result.add(this.list.get(i)));
        System.out.println(result.toString().replaceAll("[\\[\\]]",""));
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        for (int value : list) {
            action.accept(value);
        }
    }
}