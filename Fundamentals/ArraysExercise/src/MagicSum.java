import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] arrayAsString = line.split(" ");
        int[] array = new int[arrayAsString.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(arrayAsString[i]);
        }
        int num = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == num) {
                    System.out.printf("%d %d%n", array[i], array[j]);
                }
            }
        }
    }
}
