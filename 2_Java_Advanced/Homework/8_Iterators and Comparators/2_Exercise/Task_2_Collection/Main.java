import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Listy listy = new Listy();

        create(listy, reader.readLine().split("\\s+"));

        String input;

        while (!"END".equals(input = reader.readLine())) {
            printCommand(listy, input);
        }

    }
    private static void create(Listy listy, String[] tokens) {
        String[] generate = Arrays.copyOfRange(tokens, 1, tokens.length);
        listy.Create(generate);
    }
    public static void printCommand(Listy listy, String input) {
        switch (input){
            case "HasNext":
                System.out.println(listy.HasNext());
            break;
            case "Move":
                System.out.println(listy.Move());
            break;
            case "Print":
                try {
                    listy.Print();
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "PrintAll":
                try {
                    listy.PrintAll();
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                }
        }
    }
}