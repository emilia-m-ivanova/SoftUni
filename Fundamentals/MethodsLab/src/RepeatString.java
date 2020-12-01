import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());
        printStringNTimes(input,n);
    }

    private static void printStringNTimes(String input, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(input);
        }
    }
}
