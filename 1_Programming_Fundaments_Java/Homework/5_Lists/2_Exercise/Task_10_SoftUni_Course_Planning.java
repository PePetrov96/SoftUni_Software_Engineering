import java.util.*;
import java.util.stream.Collectors;

public class Task_10_SoftUni_Course_Planning {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> Lessons = Arrays.stream(scan.nextLine().split(", ")).collect(Collectors.toList());
        String[] command = scan.nextLine().split(":");

        while(!command[0].equals("course start")){

            switch(command[0]) {
                case "Add":
                    if (!Lessons.contains(command[1])) {
                        Lessons.add(command[1]);
                    }
                    break;
                case "Insert":
                    if (!Lessons.contains(command[1]) && Integer.parseInt(command[2]) >= 0 && Integer.parseInt(command[2]) < Lessons.size()) {
                        Lessons.add(Integer.parseInt(command[2]), command[1]);
                    }
                    break;
                case "Remove":
                    remove(Lessons, command[1]);
                    break;
                case "Swap":
                    swap(Lessons, command[1], command[2]);
                    break;
                case "Exercise":
                    exercise (Lessons, command[1]);
                    break;
            }
            command = scan.nextLine().split(":");
        }
        int count =0;
        for (int i=0;i<=Lessons.size()-1;i++) {
            count++;
            System.out.printf("%s.%s\n",count,Lessons.get(i));
        }
    }
    private static void remove (List<String> Lessons, String subject) {
        String exerciseTitle = subject + "-Exercise";

        if(Lessons.contains(subject) && Lessons.contains(exerciseTitle)) {
            Lessons.remove(subject);
            Lessons.remove(exerciseTitle);
        }
        if (Lessons.contains(subject)) {
            Lessons.remove(subject);
        }
        if (Lessons.contains(exerciseTitle)) {
            Lessons.remove(exerciseTitle);
        }
    }
    private static void swap (List<String> Lessons, String subject1, String subject2) {
        if(Lessons.contains(subject1) && Lessons.contains(subject2)) {
            int indexOfFirst = Lessons.indexOf(subject1);
            int indexOfSecond = Lessons.indexOf(subject2);

            String tempValue = Lessons.get(indexOfFirst);

            Lessons.set(indexOfFirst, subject2);
            Lessons.set(indexOfSecond, tempValue);

            if (Lessons.contains(subject1 + "-Exercise")) {
                String tempName = subject1 + "-Exercise";
                Lessons.remove(subject1 + "-Exercise");
                if (indexOfSecond+1<=Lessons.size()-1) {
                    Lessons.add(indexOfSecond+1,tempName);
                } else {
                    Lessons.add(tempName);
                }
            } else if (Lessons.contains(subject2 + "-Exercise")) {
                String tempName = subject2 + "-Exercise";
                Lessons.remove(subject2 + "-Exercise");

                if (indexOfFirst+1<=Lessons.size()-1) {
                    Lessons.add(indexOfFirst+1,tempName);
                } else {
                    Lessons.add(tempName);
                }
            }
        }
    }
    private static void exercise (List<String> Lessons, String subject) {
        if (Lessons.contains(subject)) {
            if (!Lessons.contains(subject + "-Exercise")) {
                int indexOf = Lessons.indexOf(subject);
                if (indexOf <= Lessons.size() - 1) {
                    Lessons.add(indexOf + 1, (subject + "-Exercise"));
                } else {
                    Lessons.add((subject + "-Exercise"));
                }
            }
        } else {
            Lessons.add(subject);
            Lessons.add((subject + "-Exercise"));
        }
    }
}