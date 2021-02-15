package ClassBoxDataValidation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            Box box = new Box(Double.parseDouble(scanner.nextLine()), Double.parseDouble(scanner.nextLine()), Double.parseDouble(scanner.nextLine()));
            System.out.println(box.toString());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
