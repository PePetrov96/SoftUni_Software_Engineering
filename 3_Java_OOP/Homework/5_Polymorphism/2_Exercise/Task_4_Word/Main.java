package Task_4_Word;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder text = new StringBuilder(scanner.nextLine());

        CommandInterface commandInterface = Initialization.buildCommandInterface(text);

        String inputLine;

        while(!"exit".equals(inputLine = scanner.nextLine())) {
            commandInterface.handleInput(inputLine);
        }

        System.out.println(text);
    }
}