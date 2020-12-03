import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regEx = "([^|$%.]*)%(?<name>[A-Z][a-z]+)%" +
                "([^|$%.]*)<(?<product>\\w+)>" +
                "([^|$%.]*)\\|(?<count>\\d+)\\|" +
                "([^|$%.\\d]*)(?<price>\\d+\\.*\\d+)\\$([^|$%.]*)";
        Pattern pattern = Pattern.compile(regEx);
        double sum = 0;
        while(!input.equals("end of shift")){
            Matcher matcher = pattern.matcher(input);
            if(matcher.find()){
                String name = matcher.group("name");
                String product = matcher.group("product");
                double price = Integer.parseInt(matcher.group("count")) *
                        Double.parseDouble(matcher.group("price"));
                System.out.printf("%s: %s - %.2f%n",name,product,price);
                sum+=price;
            }

            input = scanner.nextLine();
        }
        System.out.printf("Total income: %.2f",sum);
    }
}
