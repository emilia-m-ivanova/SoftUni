import java.util.Scanner;

public class NationalCourt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int efficiency = Integer.parseInt(scanner.nextLine()) + Integer.parseInt(scanner.nextLine())
                + Integer.parseInt(scanner.nextLine());
        int peopleCount = Integer.parseInt(scanner.nextLine());
        int timeNeeded = 0;
        while (peopleCount > 0) {
            timeNeeded++;
            if (timeNeeded % 4 != 0) {
                peopleCount -= efficiency;
            }
        }
        System.out.printf("Time needed: %dh.", timeNeeded);
    }
}
