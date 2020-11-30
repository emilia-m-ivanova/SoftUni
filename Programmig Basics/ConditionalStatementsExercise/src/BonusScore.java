import java.util.Scanner;

public class BonusScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int points = Integer.parseInt(scanner.nextLine());
        double bonus = 0;
        if (points <= 100) {
            bonus = 5;
        } else if (1000 <= points) {
            bonus = points * 10 * 0.01;
        } else {
            bonus = points * 20 * 0.01;
        }
        if (points % 2 == 0) {
            bonus = bonus + 1;
        }
        if (points % 10 == 5) {
            bonus = bonus + 2;
        }
        System.out.println(bonus);
        System.out.println(bonus + points);


    }
}
