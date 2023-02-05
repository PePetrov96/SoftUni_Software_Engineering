import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.Arrays.*;

public class Task_7_Append_Arrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        List<String> lists = stream(scan.nextLine().split("\\|")).collect(Collectors.toList());
        output(lists);
    }
    private static void output (List<String> lists) {
        Collections.reverse(lists);
        String print = lists.toString().replaceAll("[\\[\\],]", "");
        print = print.replaceAll("\\s+", " ");
        System.out.println(print);
    }
}