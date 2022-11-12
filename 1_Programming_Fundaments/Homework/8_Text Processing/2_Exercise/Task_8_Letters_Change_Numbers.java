import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task_8_Letters_Change_Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> input = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());
        double totalScore = 0;

        for (String s : input) {
            totalScore += calculateString(returnString(s));
        }

        System.out.printf("%.2f", totalScore);
    }
    private static List<String> returnString (String input) {
        List<String> firstInput = new ArrayList<>();
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                number.append(input.charAt(i));
            } else if (!number.toString().equals("") && Character.isLetter(input.charAt(i))){
                firstInput.add(number.toString());
                number = new StringBuilder();
                firstInput.add(input.charAt(i) + "");
            } else if (Character.isLetter(input.charAt(i)) && number.toString().equals("")) {
                firstInput.add(input.charAt(i) + "");
            }
        }

        return firstInput;
    }

    private static double calculateString (List<String> input) {
        double totalScore = 0.0;

        String letter1 = input.get(0);
        double theNumber = Double.parseDouble(input.get(1));
        String letter2 = input.get(2);


        if (Character.isLowerCase(letter1.charAt(0))) {
            totalScore += (theNumber * (letter1.charAt(0) - 96));
        } else {
            totalScore += (theNumber / (letter1.charAt(0) - 64));
        }

        if (Character.isLowerCase(letter2.charAt(0))) {
            totalScore += (letter2.charAt(0) - 96);
        } else {
            totalScore -= (letter2.charAt(0) - 64);
        }

        return totalScore;
    }
}