import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Listy implements Iterable<String> {
    private List<String> items;

    private int counter = 0;

    public void Create(String... items) {
        if (items.length == 0) {
            this.items = new ArrayList<>();
        } else {
            this.items = new ArrayList<>(Arrays.asList(items));
        }
    }

    public boolean Move () {
        if (iterator().hasNext()) {
            iterator().next();
            return true;
        } else {
            return false;
        }
    }

    public void Print() {
        if (items.size() == 0 ) {
            throw new IllegalStateException("Invalid Operation!");
        } else {
            System.out.println(items.get(counter));
        }
    }

    public boolean HasNext() {
        return iterator().hasNext();
    }

    public void PrintAll() {
        if (items.size() == 0 ) {
            throw new IllegalStateException("Invalid Operation!");
        } else {
            System.out.println(String.join(" ", this.items));
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new ListyIterator();
    }

    private class ListyIterator implements Iterator<String> {

        @Override
        public boolean hasNext() {
            return counter+1 < items.size();
        }

        @Override
        public String next() {
            return items.get(++counter);
        }
    }
}