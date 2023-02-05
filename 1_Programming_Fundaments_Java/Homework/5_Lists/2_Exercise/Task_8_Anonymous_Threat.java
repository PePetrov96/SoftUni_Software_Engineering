import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class Task_8_Anonymous_Threat {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        List<String> input = stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());
        String[] command = scan.nextLine().split("\\s+");

        while (!command[0].equals("3:1")) {

            switch (command[0]) {
                case "merge":
                    merge(Integer.parseInt(command[1]), Integer.parseInt(command[2]), input);
                    break;
                case "divide":
                    divide(input, Integer.parseInt(command[1]), Integer.parseInt(command[2]));
                    break;
            }
            command = scan.nextLine().split("\\s+");
        }
        System.out.println(input.toString().replaceAll("[\\[\\],]", ""));
    }
    public static void merge (int indexStart, int indexEnd, List<String> input) {
        if (indexStart < 0) {
            indexStart = 0;
        }
        if (indexEnd > input.size() - 1) {
            indexEnd = input.size() - 1;
        }
        for (int i = indexStart; i < indexEnd; i++) {
            String contact = input.get(indexStart) + input.get(indexStart + 1);
            input.set(indexStart, contact);
            input.remove(indexStart + 1);
        }
    }

    public static void divide (List<String> input, int index, int partitions) {
        if (index >= 0 && index < input.size() && partitions >= 0 && partitions <= 100) {
            String element = input.get(index);
            List<String> newList = new ArrayList<>();

            if (element.length() % partitions == 0) {
                int potionLength = element.length() / partitions;
                int count = 0;
                for (int i = 0; i < partitions; i++) {
                    String concat = "";
                    for (int j = 0; j < potionLength; j++) {
                        char symbol = element.charAt(count);
                        concat += symbol;
                        count++;
                    }
                    newList.add(concat);
                }
            } else {
                int portionLength = element.length() / partitions;
                int count = 0;
                for (int i = 0; i < partitions; i++) {
                    String concat = "";

                    if (i == partitions - 1) {
                        for (int j = count; j < element.length(); j++) {
                            char symbol = element.charAt(count);
                            concat += symbol;
                            count++;
                        }
                    } else {
                        for (int j = 0; j < portionLength; j++) {
                            char symbol = element.charAt(count);
                            concat += symbol;
                            count++;
                        }
                    }
                    newList.add(concat);
                }
            }
            input.remove(index);
            input.addAll(index, newList);
        }
    }
}