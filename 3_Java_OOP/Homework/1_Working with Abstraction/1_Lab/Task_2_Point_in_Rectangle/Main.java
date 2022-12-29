import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static Point bottomLeft = new Point();
    static Point topRight = new Point();
    static Rectangle rectangle;
    static Point pointToCheck = new Point();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        initialize(Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray());

        int n = Integer.parseInt(reader.readLine());

        for (int cycles = 0; cycles < n; cycles++) {

            int[] input = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            pointToCheck.setX(input[0]);
            pointToCheck.setY(input[1]);

            System.out.println(rectangle.contains(pointToCheck));
        }
    }
    private static void initialize(int[] points) {
        bottomLeft.setX(points[0]);
        bottomLeft.setY(points[1]);

        topRight.setX(points[2]);
        topRight.setY(points[3]);

        rectangle = new Rectangle(bottomLeft, topRight);
    }
}