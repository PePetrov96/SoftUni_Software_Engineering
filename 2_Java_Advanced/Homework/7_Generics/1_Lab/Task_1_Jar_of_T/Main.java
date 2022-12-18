public class Main {
    public static void main(String[] args) {
        Jar<String> deque = new Jar<>();

        deque.add("asd");
        System.out.println(deque.remove());

    }
}