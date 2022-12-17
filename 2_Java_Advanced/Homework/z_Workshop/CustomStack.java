import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class CustomStack {
    private static final int INITIAL_CAPACITY = 4;
    private int capacity;
    private int size;
    private int[] items;

    public CustomStack() {
        this.capacity = INITIAL_CAPACITY; //setting the capacity to the initial capacity
        this.items = new int[this.capacity]; //initializing an array with a size of [4] elements
    }

    public int getSize() {
        return this.size;
    }

    public void push(int element) {
        if (this.size == this.capacity) {
            resize();
        }
        this.items[size++] = element;
    }

    public int pop() {
        checkIndex(); //check if the list is empty and throw exception if it is
        int element = this.items[--this.size]; //get the element
        this.items[this.size] = 0; //remove the element
        if (this.size <= this.capacity / 4) { //if the capacity is too large - shrink the array
            shrink();
        }
        return element; //return the element
    }

    public int peek() {
        checkIndex(); //check if the list is empty and throw exception if it is
        return this.items[this.size-1]; //return the last element of the array
    }

    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < this.size; i++) { //iterate through every element
            consumer.accept(this.items[i]); //and apply the consumer
        }
    }
    private void resize() {
        this.capacity *= 2; //increase the capacity to x2 times the size
        int[] copy = new int[this.capacity]; //make a new array this capacity
        System.arraycopy(this.items, 0, copy, 0, this.items.length); //copy the main array to the new array (with the increased capacity)
        this.items = copy; //the main array is equals itself with x2 times its size
    }

    private void shrink() {
        this.capacity /= 2; //reduce the capacity to x2 times the size
        int[] copy = new int[this.capacity]; //make a new array with this capacity
        System.arraycopy(this.items, 0, copy, 0, this.capacity); //copy the main array to the new array (with the decreased capacity)
        this.items = copy; //the main array is equals itself with /2 times its size
    }
    private void checkIndex() {
        if (this.size == 0) {
            String message = "CustomStack is empty"; //custom message for the exception
            throw new NoSuchElementException(message); //throw the exception and print the custom message
        }
    }
}