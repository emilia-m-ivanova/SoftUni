import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] input = scanner.nextLine().split("\\s+");
        double sum = 0;

        for (String current : input) {
            char firstLetter = current.charAt(0);
            char lastLetter = current.charAt(current.length() - 1);
            long num = Integer.parseInt(current.substring(1, current.length() - 1));
            double result;
            if (Character.isUpperCase(firstLetter)) {
                result = (double) num / (firstLetter - 64);
            } else {
                result = num * (firstLetter - 96);
            }
            if (Character.isUpperCase(lastLetter)) {
                result -= lastLetter - 64;
            } else {
                result += lastLetter - 96;
            }
            sum += result;
        }

        System.out.printf("%.2f",sum);
    }
}
