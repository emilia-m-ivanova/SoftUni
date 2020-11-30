import java.util.Scanner;

public class TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String presentation = scanner.nextLine();
        double scoreAll = 0;
        int counter = 0;
        while (!presentation.equals("Finish")) {
            double scoreSum = 0;
            for (int i = 1; i <=n; i++) {
                double score = Double.parseDouble(scanner.nextLine());
                scoreSum+=score;
            }
            scoreAll+=scoreSum;
            counter++;
            System.out.printf("%s - %.2f.%n",presentation,scoreSum/n);
            presentation=scanner.nextLine();
        }
        System.out.printf("Student's final assessment is %.2f.",scoreAll/n/counter);
    }
}
