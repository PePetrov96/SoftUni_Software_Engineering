import java.util.ArrayList;
import java.util.List;

public class TrafficLight {
    enum Color {
        RED(1), GREEN(2), YELLOW(3);
        private final int value;
        Color(int value) {
            this.value = value;
        }
    }
    private static Color updateColor(Color color) {
        switch (color.value) {
            case 1: return Color.GREEN;
            case 2: return Color.YELLOW;
            case 3: return Color.RED;
        }
        return null;
    }
    public static List<Color> update(List<Color> lights) {
        List<Color> temp = new ArrayList<>();
        for (Color light : lights) {
            temp.add(updateColor(light));
        }
        return temp;
    }
}
