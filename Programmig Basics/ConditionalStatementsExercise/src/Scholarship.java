import java.util.Scanner;

public class Scholarship {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double income = Double.parseDouble(scanner.nextLine());
        double avResult = Double.parseDouble(scanner.nextLine());
        double minSalary = Double.parseDouble(scanner.nextLine());
        double scholarshipS = 0;
        double scholarshipR = 0;
        if (income < minSalary) {
            if (avResult > 4.5) {
                scholarshipS = minSalary * 35 * 0.01;
            }
        }
        if (avResult >= 5.5) {
            scholarshipR = avResult * 25;
        }
        if (scholarshipR + scholarshipS == 0) {
            System.out.println("You cannot get a scholarship!");
        } else if (scholarshipR < scholarshipS) {
            System.out.printf("You get a Social scholarship %.0f BGN", Math.floor(scholarshipS));
        } else {
            System.out.printf("You get a scholarship for excellent results %.0f BGN", Math.floor(scholarshipR));
        }


    }
}
