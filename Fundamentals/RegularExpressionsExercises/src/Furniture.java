import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regEx = ">>(?<furniture>[A-Z]\\w+)<<(?<price>\\d+\\.*\\d+)!(?<quantity>[1-9]\\d*)";
        double sum = 0;
        Pattern pattern = Pattern.compile(regEx);
        System.out.println("Bought furniture:");
        while (!input.equals("Purchase")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                System.out.println(matcher.group("furniture"));
                sum += Double.parseDouble(matcher.group("price"))*Integer.parseInt(matcher.group("quantity"));
            }
            input = scanner.nextLine();
        }
        System.out.printf("Total money spend: %.2f",sum);
    }
}
