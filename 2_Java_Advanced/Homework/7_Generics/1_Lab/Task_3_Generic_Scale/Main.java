public class Main {
    public static void main(String[] args) {
        Scale<String> strings = new Scale<>("Q", "a");
        Scale<Integer> integers = new Scale<>(5, 5);
        Scale<Double> doubles = new Scale<>(5.3, 5.0);

        System.out.println(strings.getHeavier());
        System.out.println();
        System.out.println(integers.getHeavier());
        System.out.println();
        System.out.println(doubles.getHeavier());
    }
}
