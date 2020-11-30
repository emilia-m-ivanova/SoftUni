import java.util.Scanner;

public class Salary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        int salary = Integer.parseInt(scanner.nextLine());
        int facebook = 0;
        int instagram = 0;
        int reddit = 0;
        for (int i = 1; i <= count; i++) {
            String browser = scanner.nextLine();
            switch (browser) {
                case "Facebook":
                    facebook++;
                    break;
                case "Instagram":
                    instagram++;
                    break;
                case "Reddit":
                    reddit++;
                    break;
            }
            int fine = (facebook * 150) + (instagram * 100) + (reddit * 50);
            if (salary <= fine) {
                i = count + 1;
                System.out.println("You have lost your salary.");
            }

        }
        int fine = (facebook * 150) + (instagram * 100) + (reddit * 50);
        if (salary > fine) {
            System.out.println(salary - fine);
        }

    }
}
