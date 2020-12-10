import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regEx = "([#|])(?<item>[a-zA-Z\\s]+)\\1(?<date>\\d{2}/\\d{2}/\\d{2})\\1(?<calories>\\d+)\\1";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(input);
        List<String> itemStrings = new ArrayList<>();
        int calories = 0;
        while (matcher.find()){
            calories+=Integer.parseInt(matcher.group("calories"));
            itemStrings.add(String.format("Item: %s, Best before: %s, Nutrition: %s",
                    matcher.group("item"),matcher.group("date"),matcher.group("calories")));
        }
        int days = 0;
        while (calories>=2000){
            days++;
            calories-=2000;
        }
        System.out.println("You have food to last you for: " + days + " days!");

        for (String itemString : itemStrings) {
            System.out.println(itemString);
        }
    }
}
