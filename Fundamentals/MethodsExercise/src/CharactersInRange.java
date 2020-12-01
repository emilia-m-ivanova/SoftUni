import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char firstChar = scanner.nextLine().charAt(0);
        char secondChar = scanner.nextLine().charAt(0);
        printCharactersInRange(firstChar, secondChar);
    }

    private static void printCharactersInRange(char start, char end) {

        for (char i = ++start; i < end; i++) {
                System.out.print(i+" ");
        }
        for (char i = ++end; i < start-1; i++) {
                System.out.print(i+" ");
        }
    }
}
