import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] arrayOfStrings = new String[n];
        for (int i = 0; i < n; i++) {
            arrayOfStrings[i] = scanner.nextLine();
        }
        int[] arrayOutput = new int[n];
        for (int i = 0; i < arrayOfStrings.length; i++) {
            String element = arrayOfStrings[i];
            int sum = 0;
            for (int j = 0; j < element.length(); j++) {
                char currentChar = element.charAt(j);
                if (currentChar == 'a' || currentChar == 'i' || currentChar == 'e' || currentChar == 'o' || currentChar == 'u'
                        || currentChar == 'A' || currentChar == 'I' || currentChar == 'E' || currentChar == 'O' || currentChar == 'U') {
                    sum += (currentChar * element.length());
                } else {
                    sum += (currentChar / element.length());
                }
            }
                arrayOutput[i] = sum;
        }
            Arrays.sort(arrayOutput);
        for (int element : arrayOutput) {
            System.out.println(element);
        }
    }
}
