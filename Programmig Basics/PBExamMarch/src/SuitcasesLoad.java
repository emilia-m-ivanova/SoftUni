import java.util.Scanner;

public class SuitcasesLoad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double capacity = Double.parseDouble(scanner.nextLine());
        String input = scanner.nextLine();
        int counter = 0;
        double spacefFilled = 0;
        while (!input.equals("End")) {
            double volume = Double.parseDouble(input);
            spacefFilled += volume;
            if (spacefFilled >= capacity) {
                System.out.println("No more space!");
                break;
            }
            counter++;
            input = scanner.nextLine();
        }
        if (spacefFilled < capacity) {
            System.out.println("Congratulations! All suitcases are loaded!");
        }
        System.out.printf("Statistic: %d suitcases loaded.", counter);
    }
}
