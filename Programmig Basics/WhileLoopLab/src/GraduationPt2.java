import java.util.Scanner;

public class GraduationPt2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        double sum = 0;
        int year = 1;
        int excluded = 0;
        while (year <= 12) {
            double grade = Double.parseDouble(scanner.nextLine());
            if (grade < 4) {
                excluded += 1;
                if (excluded == 2) {
                    System.out.printf("%s has been excluded at %d grade", name, year);
                    break;
                } else {
                    continue;
                }
            }
            year++;
            sum += grade;

        }
        if (excluded != 2) {
            double average = sum / 12;
            System.out.printf("%s graduated. Average grade: %.2f", name, average);
        }
    }
}
