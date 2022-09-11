import java.util.*;
import java.util.stream.Collectors;

public class Task_4_Mixed_up_List {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> listOne = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> listTwo = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        format(listOne, listTwo);
    }
    private static void format (List<Integer> listOne, List<Integer> listTwo) {
        int startConst, endConst;
        if (listOne.size() > listTwo.size()) {
            startConst = listOne.get(listOne.size() - 2);
            endConst = listOne.get(listOne.size() - 1);
        } else {
            startConst = listTwo.get(1);
            endConst = listTwo.get(0);
        }
        List<Integer> combined = new ArrayList<>();
        combined.addAll(listOne);
        combined.addAll(listTwo);

        output(combined, startConst, endConst);
    }
    private static void output (List<Integer> combined, int startConst, int endConst) {
        List<Integer> output = new ArrayList<>();
        if (startConst > endConst) {
            for (Integer integer : combined) {
                if (integer < startConst && integer > endConst) {
                    output.add(integer);
                }
            }
        } else {
            for (Integer integer : combined) {
                if (integer < endConst && integer > startConst) {
                    output.add(integer);
                }
            }
        }
        Collections.sort(output);
        System.out.println(output.toString().replaceAll("[\\[\\],]", ""));
    }
}