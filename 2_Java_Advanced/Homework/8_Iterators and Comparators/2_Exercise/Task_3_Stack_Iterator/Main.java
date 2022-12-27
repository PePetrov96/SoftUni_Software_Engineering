import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CustomStack stack = new CustomStack();

        String input;

        while (!"END".equals(input = reader.readLine())) {
            modify(stack, input.trim().replaceAll(",","").split("\\s+"));
        }
        stack.forEachModified(System.out::println);
        stack.forEachModified(System.out::println);
    }
    private static void modify(CustomStack stack, String[] tokens) {
        switch (tokens[0]) {
            case "Push":
                for (int i = 1; i < tokens.length; i++) {
                    stack.Push(Integer.parseInt(tokens[i]));
                }
                break;
            case "Pop":
                stack.Pop();
                break;
        }
    }
}