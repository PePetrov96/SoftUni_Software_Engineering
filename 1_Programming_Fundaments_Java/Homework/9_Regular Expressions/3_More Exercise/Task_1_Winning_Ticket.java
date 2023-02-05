import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Task_1_Winning_Ticket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] tickets = scan.nextLine().split("\\s*,\\s*");

        for (String ticket : tickets) {
            validate(ticket);
        }
    }
    private static void validate (String ticket) {
        Pattern p = Pattern.compile("(?=.{20}).*?(?=(?<ch>[@#$^]))(?<match>\\k<ch>{6,}).*(?<=.{10})\\k<match>.*");

        if (ticket.length() != 20) {
            System.out.println("invalid ticket");
        } else {
            Matcher matcher = p.matcher(ticket);
            if (matcher.matches()) {
                String match = matcher.group("match");
                System.out.printf("ticket \"%s\" - %d%s%s%n",
                        ticket, match.length(), match.charAt(0),
                        (match.length() == 10) ? " Jackpot!" : "");
            } else {
                System.out.printf("ticket \"%s\" - no match%n", ticket);
            }
        }
    }
}