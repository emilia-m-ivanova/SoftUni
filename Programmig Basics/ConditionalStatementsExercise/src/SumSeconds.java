import java.util.Scanner;

public class SumSeconds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seconds1 = Integer.parseInt(scanner.nextLine());
        int seconds2 = Integer.parseInt(scanner.nextLine());
        int seconds3 = Integer.parseInt(scanner.nextLine());
        int sum = seconds1 + seconds2 + seconds3;
        int min = sum / 60;
        int sec = sum % 60;
        System.out.printf("%d:%02d", min, sec);

    }
}
