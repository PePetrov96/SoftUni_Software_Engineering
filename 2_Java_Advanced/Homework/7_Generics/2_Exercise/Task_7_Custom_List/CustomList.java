import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class CustomList<T extends Comparable<T>> {
    private final List<T> list;

    public CustomList() {
        this.list = new ArrayList<>();
    }

    public void add(T value) {
        this.list.add(value);
    }

    public void remove(int index) {
        checkIndex(index);
        this.list.remove(index);
    }

    public void swap(int index1, int index2) {
        checkIndex(index1); checkIndex(index2);
        Collections.swap(this.list, index1, index2);
    }

    public boolean contains(T element) {
        return this.list.contains(element);
    }

    public void forEach(Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }

    public long sumOfGreater(T element) {
        return list.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    public T getMax() {
        return this.list.stream().max(Comparator.naturalOrder()).orElse(null);
    }

    public T getMin() {
        return this.list.stream().min(Comparator.naturalOrder()).orElse(null);
    }

    public void printListToString() {
        forEach(System.out::println);
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= list.size()) {
            throw new IndexOutOfBoundsException();
        }
    }

}