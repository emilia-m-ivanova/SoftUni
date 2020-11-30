import java.util.Scanner;

public class Walking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int steps = 0;
        boolean goingHome = false;
        while (!goingHome && steps<=10000) {
            String input = scanner.nextLine();
            if (input.equals("Going home")) {
                goingHome = true;
                int stepsHome = Integer.parseInt(scanner.nextLine());
                steps+=stepsHome;
            } else {
                steps += Integer.valueOf(input);
            }
        }
        int diff = Math.abs(10000 - steps);
        if (steps >= 10000) {

            System.out.printf("Goal reached! Good job!%n%d steps over the goal!", diff);
        }else{
            System.out.printf("%d more steps to reach goal.",diff);
        }
    }
}
