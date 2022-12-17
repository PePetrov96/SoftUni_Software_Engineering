import java.util.function.Consumer;

public class SmartArray {
    private static final int INITIAL_CAPACITY = 4;
    private int[] data;
    private int size;
    private int capacity;

    public SmartArray() {
        this.data = new int[INITIAL_CAPACITY]; //initializing an array with a size of [4] elements
        this.capacity = INITIAL_CAPACITY; //setting the capacity to the initial capacity
    }

    public int get(int index) {
        checkIndex(index); //throw the exception and stop the program if true
        return this.data[index]; //if exception isn't thrown, then return the index
    }

    public void add(int element) {
        if (this.size == this.capacity) { //check if the size is equal to the capacity
            this.resize(); //if it is - run the resize method
        }
        this.data[this.size++] = element; //the element is placed at the current size(index) and them the size(index) is increased
    }

    public int remove(int index) {
        checkIndex(index); //throw the exception and stop the program if true
        int removedItem = this.data[index]; //get the element we are trying to remove
        shiftLeft(index);//shift the array
        this.size--;//reduce the size by 1. all empty elements in an array are equal to 0. the capacity is still unchanged
        if (this.size <= this.capacity / 4) { //if the capacity is too large - shrink the array
            shrink();
        }
        return removedItem;
    }

    public void add(int index, int element) {
        checkIndex(index);
        if (index == this.size - 1) { //if we are to add the element at the last-1 index
            add(this.data[this.size - 1]); //just move the last element to the right
            this.data[this.size - 2] = element; //and add the new element to the last-1 index
        } else {
            this.size++; //increase the size (to accommodate for the new element being added)
            shiftRight(index); //shift all the elements to the right
            this.data[index] = element; //add the element at the index
        }
    }

    public boolean contains(int element) {
        for (int i = 0; i < this.size; i++) { //iterate through the array
            if (this.data[i] == element) { //if an element from the array matches the element
                return true; //return true
            }
        }
        return false; //otherwise - return false
    }

    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < this.size; i++) { //iterate through every element
            consumer.accept(this.data[i]); //and apply the consumer
        }
    }

    private void shiftRight(int index) {
        if ((this.size-1) == this.capacity) { //check if the size is equal to the capacity
            this.resize(); //if it is - run the resize method
        }
        for (int i = this.size - 1; i > index; i--) { //make each element equal to the one to its left
            this.data[i] = this.data[i-1];
        }
    }

    private void shrink() {
        this.capacity /= 2; //reduce the capacity to x2 times the size
        int[] copy = new int[this.capacity]; //make a new array with this capacity
        System.arraycopy(this.data, 0, copy, 0, this.capacity); //copy the main array to the new array (with the decreased capacity)
        this.data = copy; //the main array is equals itself with /2 times its size
    }

    private void shiftLeft(int index) {
        for (int i = index; i < this.size - 1; i++) {
            this.data[i] = this.data[i + 1]; //every element is equal to the element to its right
        }
        this.data[size - 1] = 0; //the last element will be equal to "0"
    }

    private void resize() {
        this.capacity *= 2; //increase the capacity to x2 times the size
        int[] copy = new int[this.capacity]; //make a new array this capacity
        System.arraycopy(this.data, 0, copy, 0, this.data.length); //copy the main array to the new array (with the increased capacity)
        this.data = copy; //the main array is equals itself with x2 times its size
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            String message = String.format("Index %d out of bounds for length %d", index, this.size); //custom message for the exception
            throw new IndexOutOfBoundsException(message); //throw the exception and print the custom message
        }
    }
}