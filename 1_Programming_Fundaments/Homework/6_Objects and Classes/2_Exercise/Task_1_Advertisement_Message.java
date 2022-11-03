import java.util.Random;
import java.util.Scanner;

public class Task_1_Advertisement_Message {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Message message = new Message();

        for (int i = 0; i < n; i++) {
            System.out.println(message.randomMessage());
        }
    }
    public static class Message {
        private final Random random = new Random();

        private final String[] phrases = {"Excellent product.", "Such a great product.",
                "I always use that product.", "Best product of its category.",
                "Exceptional product.", "I can’t live without this product."};
        private final String[] events = {"Now I feel good.", "I have succeeded with this product.",
                "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.",
                "Try it yourself, I am very satisfied.", "I feel great!"};
        private final String[] author = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        private final String[] town = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        public String randomMessage() {
            return String.format("%s %s %s - %s",
                    phrases[random.nextInt(phrases.length)],
                    events[random.nextInt(events.length)],
                    author[random.nextInt(author.length)],
                    town[random.nextInt(town.length)]);
        }
    }
}