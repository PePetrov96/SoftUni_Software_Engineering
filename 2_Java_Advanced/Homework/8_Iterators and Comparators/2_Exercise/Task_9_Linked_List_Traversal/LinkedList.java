import java.util.Iterator;
import java.util.function.Consumer;

public class LinkedList<T> implements Iterable<T> {
    Node<T> head;
    private int length = 0;
    LinkedList() { this.head = null; }

    void add(T data) {
        Node<T> temp = new Node<>(data);
        if (this.head == null) {
            head = temp;
        } else {
            Node<T> X = head;
            while (X.next != null) {
                X = X.next;
            }
            X.next = temp;
        }
        length++;
    }

    void remove(T key) {
        Node<T> prev = new Node<>(null);
        prev.next = head;
        Node<T> next = head.next;
        Node<T> temp = head;
        boolean exists = false;

        if (head.data == key) {
            head = head.next;
            exists = true;
        }

        while (temp.next != null) {
            if (String.valueOf(temp.data).equals(String.valueOf(key))) {
                prev.next = next;
                exists = true;
                break;
            }
            prev = temp;
            temp = temp.next;
            next = temp.next;
        }

        if (!exists && String.valueOf(temp.data).equals(String.valueOf(key))) {
            prev.next = null;
            exists = true;
        }

        if (exists) {
            length--;
        }
    }

    int getSize() { return this.length; }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {

            Node<T> node = head;

            @Override
            public boolean hasNext() {
                try {
                    return node != null;
                } catch (NullPointerException e) {
                    return false;
                }
            }

            @Override
            public T next() {
                T value = node.data;
                node = node.next;
                return value;
            }
        };
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Node<T> current = this.head;

        while (current != null) {
            action.accept(current.data);
            current = current.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        forEach(item -> string.append(item).append(" "));
        return string.toString().trim();
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}