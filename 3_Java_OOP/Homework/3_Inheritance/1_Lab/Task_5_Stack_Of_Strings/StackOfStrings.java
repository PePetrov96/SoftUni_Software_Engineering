package Task_5_Stack_Of_Strings;

import java.util.ArrayList;

public class StackOfStrings {

    private final ArrayList<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String item) {
        this.data.add(item);
    }

    public String pop() {
        if (!isEmpty()) {
            return this.data.remove(this.data.size() - 1);
        }
        return null;
    }

    public String peek() {
        if (!isEmpty()) {
            return this.data.get(this.data.size() - 1);
        }
        return null;
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }
}