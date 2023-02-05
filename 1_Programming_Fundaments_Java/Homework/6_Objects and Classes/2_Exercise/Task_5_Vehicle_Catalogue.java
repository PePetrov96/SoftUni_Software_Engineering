import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task_5_Vehicle_Catalogue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Catalogue> vehicleCatalogue = new ArrayList<>();
        String[] input = scan.nextLine().split("\\s+");

        while (!input[0].equals("End")) {
            Catalogue vehicle = new Catalogue(input[0].substring(0, 1).toUpperCase() + input[0].substring(1), input[1], input[2], Integer.parseInt(input[3]));
            vehicleCatalogue.add(vehicle);
            input = scan.nextLine().split("\\s+");
        }

        String model;

        while (!"Close the Catalogue".equals(model = scan.nextLine())) {
            String finalModel = model;
            vehicleCatalogue.stream().
                    filter(v -> v.getModel().equals(finalModel)).
                    forEach(System.out::println);
        }

        System.out.printf("Cars have average horsepower of: %.2f.%n", average(vehicleCatalogue.stream().
                filter(v -> v.getType().equalsIgnoreCase("car")).
                collect(Collectors.toList())));
        System.out.printf("Trucks have average horsepower of: %.2f.%n", average(vehicleCatalogue.stream().
                filter(v -> v.getType().equalsIgnoreCase("truck")).
                collect(Collectors.toList())));
    }
    public static double average (List<Catalogue> vehicleCatalogue) {
        if (vehicleCatalogue.size() == 0) {
            return 0.0;
        } else {
            double sum = 0;
            for (Catalogue vehicle : vehicleCatalogue) {
                sum += vehicle.getHorsepower();
            }
            return sum / vehicleCatalogue.size();
        }
    }
    public static class Catalogue {
        private final String type;
        private final String model;
        private final String color;
        private final int horsepower;

        public Catalogue(String type, String model, String color, int horsepower) {
            this.type = type;
            this.model = model;
            this.color = color;
            this.horsepower = horsepower;
        }

        public String getType() {
            return type;
        }

        public String getModel() {
            return model;
        }

        public int getHorsepower() {
            return horsepower;
        }

        @Override
        public String toString() {
            return String.format("Type: %s%n" +
                    "Model: %s%n" +
                    "Color: %s%n" +
                    "Horsepower: %d", type, model, color, horsepower);
        }
    }
}