import java.util.Scanner;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countStudents = Integer.parseInt(scanner.nextLine());
        int countLectures = Integer.parseInt(scanner.nextLine());
        int addBonus = Integer.parseInt(scanner.nextLine());
        int maxAttendances = 0;
        for (int i = 0; i < countStudents; i++) {
            int attendances = Integer.parseInt(scanner.nextLine());
            if (attendances > maxAttendances) {
                maxAttendances = attendances;
            }
        }
        double maxBonus = 0;
        if (maxAttendances > 0) {
            maxBonus = (double) maxAttendances / countLectures * (5 + addBonus);
        }
        System.out.printf("Max Bonus: %.0f.%nThe student has attended %d lectures.", Math.ceil(maxBonus), maxAttendances);
    }
}
