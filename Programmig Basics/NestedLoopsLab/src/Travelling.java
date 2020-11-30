import java.util.Scanner;

public class Travelling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String destination = scanner.nextLine();
        while (!destination.equals("End")) {
            double budget = Double.parseDouble(scanner.nextLine());
            double sumAll = 0;
            while (sumAll < budget) {
                double save = Double.parseDouble(scanner.nextLine());
                sumAll+=save;
            }
            System.out.println("Going to "+destination+"!");

            destination = scanner.nextLine();
        }
    }
}
