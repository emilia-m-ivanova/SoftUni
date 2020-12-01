import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        if (correctCharacters(password) && correctLength(password) && hasMin2Digits(password)) {
            System.out.println("Password is valid");
            return;
        }
        if (!correctLength(password)) {
            System.out.println("Password must be between 6 and 10 characters");
        }
        if (!correctCharacters(password)) {
            System.out.println("Password must consist only of letters and digits");
        }
        if (!hasMin2Digits(password)) {
            System.out.println("Password must have at least 2 digits");
        }

    }

    public static boolean correctLength(String password) {
        return 6 <= password.length() && password.length() <= 10;
    }

    public static boolean correctCharacters(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (!Character.isLetterOrDigit(password.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasMin2Digits(String password) {
        int count = 0;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                count++;
            }
            if (count == 2) {
                return true;
            }
        }
        return false;
    }
}
