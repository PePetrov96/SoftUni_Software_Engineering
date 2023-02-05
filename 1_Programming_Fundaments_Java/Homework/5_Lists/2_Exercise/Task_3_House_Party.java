import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task_3_House_Party {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> namesList = new ArrayList<>();
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(" ");
            String name = input[0];
            String command = input[1] + " " + input[2];
            switch (command) {
                case "is going!":
                    isGoing(namesList, name);
                    break;
                case "is not":
                    isNotGoing(namesList, name);
                    break;
            }
        }
        print(namesList);
    }
    private static void isGoing (List<String> nameList, String name) {
        if (nameList.contains(name)) {
            System.out.println(name + " is already in the list!");
        } else {
            nameList.add(name);
        }
    }
    private static void isNotGoing (List<String> nameList, String name) {
        if (nameList.contains(name)) {
            nameList.remove(name);
        } else {
            System.out.println(name + " is not in the list!");
        }
    }
    private static void print (List<String> nameList) {
        for (int i = 0; i < nameList.size(); i++) {
            System.out.println(nameList.get(i));
        }
    }
}