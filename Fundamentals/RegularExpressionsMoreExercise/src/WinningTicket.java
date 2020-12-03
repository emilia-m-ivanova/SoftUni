import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tickets = scanner.nextLine().split("\\s*,\\s*");
        String regExJackpot = "([@#$^])\\1{19}";
        String regExMatch = "([@#$^])\\1{5,8}";
        for (String ticket : tickets) {
            if (ticket.length() == 20) {
                Pattern pattern = Pattern.compile(regExJackpot);
                Matcher matcher = pattern.matcher(ticket);
                if (matcher.find()) {
                    System.out.printf("ticket \"%s\" - 10%s Jackpot!%n", ticket, matcher.group(1));
                } else {
                    pattern = Pattern.compile(regExMatch);
                    matcher = pattern.matcher(ticket.substring(0,10));
                    if (matcher.find()) {
                        String symbol = matcher.group(1);
                        Pattern newPattern = Pattern.compile(String.format("\\%s{6,}",symbol));
                        Matcher newMatcher = newPattern.matcher(ticket.substring(10));
                        if (newMatcher.find()) {
                            System.out.printf("ticket \"%s\" - %d%s%n", ticket,
                                    Math.min(newMatcher.group().length(),matcher.group().length()), symbol);
                        } else {
                            System.out.printf("ticket \"%s\" - no match%n", ticket);
                        }
                    }else {
                        System.out.printf("ticket \"%s\" - no match%n", ticket);
                    }
                }
            } else {
                System.out.println("invalid ticket");
            }
        }

    }
}
