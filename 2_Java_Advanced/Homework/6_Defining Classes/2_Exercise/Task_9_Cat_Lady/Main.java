import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashSet<Cat> catList = new LinkedHashSet<>();

        String input;
        while (!"End".equals(input = reader.readLine())) {
            addCat(catList, input.split("\\s+"));
        }

        printCat(catList, reader.readLine());
    }

    private static void printCat (LinkedHashSet<Cat> catList, String name) {
        for (Cat cat : catList) {
            if (cat.getName().equals(name)) {
                System.out.println(cat);
                break;
            }
        }
    }
    private static void addCat(LinkedHashSet<Cat> catList, String[] input) {
        String name = input[1];
        String breed = input[0];
        double measurement = Double.parseDouble(input[2]);

        Cat newCat;

        switch (breed) {
            case "Siamese":
                newCat = new Cat(name, new Siamese(measurement));
                break;
            case "Cymric":
                newCat = new Cat(name, new Cymric(measurement));
                break;
            default:
                newCat = new Cat(name, new StreetExtraordinaire(measurement));
                break;
        }

        catList.add(newCat);
    }
}