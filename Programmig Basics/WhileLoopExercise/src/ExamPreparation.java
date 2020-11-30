import java.util.Scanner;

public class ExamPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int poor = Integer.parseInt(scanner.nextLine());
        String exercise = scanner.nextLine();
        int problems = 0;
        int poorNum = 0;
        double score = 0;
        String lastPb = "";
        while (!exercise.equals("Enough")) {
            int grade = Integer.parseInt(scanner.nextLine());
            if (grade <= 4) {
                poorNum++;
            }
            if (poorNum == poor) {
                System.out.printf("You need a break, %d poor grades.", poorNum);
                break;
            }
            problems++;
            score += grade;
            lastPb = exercise;
            exercise = scanner.nextLine();
        }
        if (poorNum != poor) {
            double avScore = score / problems;
            System.out.printf("Average score: %.2f%nNumber of problems: %d%nLast problem: %s", avScore, problems, lastPb);
        }
    }
}
