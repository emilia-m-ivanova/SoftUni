import java.util.Scanner;

public class PersonalTitles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double age = Double.parseDouble(scanner.nextLine());
        String sex = scanner.nextLine();
        if (sex.equals("m")) {
            if (age >= 16) {
                System.out.println("Mr.");

            } else {
                System.out.println("Master");
            }
        }
        if (sex.equals("f")) {
            if (age >= 16) {
                System.out.println("Ms.");
            } else {
                System.out.println("Miss");
            }
        }
    }
}
