import java.util.Scanner;

public class OldBooks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String book = scanner.nextLine();
        String check = scanner.nextLine();
        int num = 0;
        while (!check.equals("No More Books")) {
            if (check.equals(book)) {
                System.out.printf("You checked %d books and found it.", num);
                break;
            }
            num++;
            check = scanner.nextLine();
        }
        if (!check.equals(book)) {
            System.out.printf("The book you search is not here!%nYou checked %d books.", num);
        }

    }
}
