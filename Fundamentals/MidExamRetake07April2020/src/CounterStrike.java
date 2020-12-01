import java.util.Scanner;

public class CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int energy = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int counter = 0;
        while (!input.equals("End of battle")) {
            int distance = Integer.parseInt(input);
            if (distance > energy) {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", counter, energy);
                return;
            } else {
                counter++;
                if (counter % 3 == 0) {
                    energy += counter;
                }
                energy -= distance;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Won battles: %d. Energy left: %d", counter, energy);
    }
}
