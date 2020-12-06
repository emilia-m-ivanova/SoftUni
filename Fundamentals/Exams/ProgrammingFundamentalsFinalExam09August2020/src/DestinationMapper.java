import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String regEx = "([=/])(?<destination>[A-Z][A-Za-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(text);
        List <String> destinations = new ArrayList<>();
        int sum = 0;
        while (matcher.find()){
            destinations.add(matcher.group("destination"));
            sum+=matcher.group("destination").length();
        }
        System.out.println("Destinations: "+String.join(", ",destinations));
        System.out.println("Travel Points: "+sum);
    }
}
