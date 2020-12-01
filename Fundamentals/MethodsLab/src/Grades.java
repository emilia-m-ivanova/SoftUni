import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double grade = Double.parseDouble(scanner.nextLine());
        printGradeInWords(grade);
    }

    private static void printGradeInWords(double grade) {
        if (grade >= 5.5) {
            System.out.println("Excellent");
        } else if (grade >= 4.5) {
            System.out.println("Very good");
        } else if (grade >= 3.5) {
            System.out.println("Good");
        } else if (grade >= 3) {
            System.out.println("Poor");
        } else {
            System.out.println("Fail");
        }
    }
}
