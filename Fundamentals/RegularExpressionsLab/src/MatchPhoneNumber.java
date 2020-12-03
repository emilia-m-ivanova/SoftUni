import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = "(^|\\s)\\+359([ -])2\\2\\d{3}\\2\\d{4}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        List<String> matchedNumbers = new ArrayList();

        while (matcher.find()){
            matchedNumbers.add(matcher.group());
        }
        System.out.println(String.join(",",matchedNumbers));
    }
}
