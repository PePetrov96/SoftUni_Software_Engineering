import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task_2_Car_Race {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> race = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        outcome(firstRacer(race), secondRacer(race));
    }
    private static double firstRacer (List<Integer> race) {
        List<Integer> firstRacer = new ArrayList<>();
        for (int i = 0; i < race.size() / 2; i++) {
            firstRacer.add(race.get(i));
        }

        double firstSum = 0;

        for (int currNum : firstRacer) {
            firstSum += currNum;
            if (currNum == 0) {
                firstSum = (firstSum * 0.8);
            }
        }
        return firstSum;
    }
    private static double secondRacer (List<Integer> race) {
        List<Integer> secondRacer = new ArrayList<>();
        for (int i = race.size()-1; i > race.size() / 2; i--) {
            secondRacer.add(race.get(i));
        }

        double secondSum = 0;

        for (int currNum : secondRacer) {
            secondSum += currNum;
            if (currNum == 0) {
                secondSum = (secondSum * 0.8);
            }
        }
        return secondSum;
    }
    private static void outcome (double firstRacer, double secondRacer) {
        if (firstRacer < secondRacer) {
            System.out.printf("The winner is left with total time: %.1f", firstRacer);
        } else {
            System.out.printf("The winner is right with total time: %.1f", secondRacer);
        }
    }
}