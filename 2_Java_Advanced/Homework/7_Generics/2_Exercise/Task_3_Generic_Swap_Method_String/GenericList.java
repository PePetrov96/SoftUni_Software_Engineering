import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class GenericList<T> {
    private final List<T> list;

    public GenericList() {
        this.list = new ArrayList<>();
    }

    public void add(T value) {
        this.list.add(value);
    }

    public void swap(int index1, int index2) {
        checkIndex(index1);
        checkIndex(index2);

        T element1 = this.list.get(index1);

        this.list.set(index1, this.list.get(index2));
        this.list.set(index2, element1);
    }
    public void forEach(Consumer<T> consumer) {
        for (int i = 0; i < list.size(); i++) {
            consumer.accept(list.get(i));
        }
    }

    public void printToString() {
        forEach(value -> System.out.println(value.getClass().getName() + ": " + value));
    }
    private void checkIndex(int index) {
        if (index < 0 || index >= list.size()) {
            throw new IndexOutOfBoundsException();
        }
    }
}