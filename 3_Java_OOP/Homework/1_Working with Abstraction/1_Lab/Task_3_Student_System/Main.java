import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static StudentSystem studentSystem = new StudentSystem();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while (!"Exit".equals(input = reader.readLine())) {
            command(input);
        }

    }
    private static void command(String input) {
        String command = input.substring(0, input.indexOf(" "));
        String[] tokens = input.substring(input.indexOf(" ")+1).split("\\s+");

        switch (command) {
            case "Create": studentSystem.Create(tokens); break;
            case "Show": studentSystem.Show(tokens[0]); break;
        }
    }
}