import java.util.Scanner;

public class Task_5_HTML {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.printf("<h1>%n" + "    %s%n" + "</h1>%n", scan.nextLine());
        System.out.printf("<article>%n" + "    %s%n" + "</article>%n", scan.nextLine());

        String input;
        while (!"end of comments".equals(input = scan.nextLine())) {
            System.out.printf("<div>%n" + "    %s%n" + "</div>%n", input);
        }

    }
}