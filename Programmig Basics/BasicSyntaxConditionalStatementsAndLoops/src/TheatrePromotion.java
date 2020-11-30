import java.util.Scanner;

public class TheatrePromotion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String day = scanner.nextLine();
        int age = scanner.nextInt();
        String output;
        switch (day) {
            case "Weekday":
                if (0 <= age && age <= 18) {
                    output = "12$";
                } else if (18 < age && age <= 64) {
                    output = "18$";
                } else if (64 < age && age <= 122) {
                    output = "12$";
                } else {
                    output = "Error!";
                }
                break;
            case "Weekend":
                if (0 <= age && age <= 18) {
                    output = "15$";
                } else if (18 < age && age <= 64) {
                    output = "20$";
                } else if (64 < age && age <= 122) {
                    output = "15$";
                } else {
                    output = "Error!";
                }

                break;
            case "Holiday":
                if (0 <= age && age <= 18) {
                    output = "5$";
                } else if (18 < age && age <= 64) {
                    output = "12$";
                } else if (64 < age && age <= 122) {
                    output = "10$";
                } else {
                    output = "Error!";
                }
                break;
            default:
                output = "Error!";
                break;
        }
        System.out.println(output);
    }
}
