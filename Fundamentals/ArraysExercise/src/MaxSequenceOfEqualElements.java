import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] arrayAsString = line.split(" ");
        int[] array = new int[arrayAsString.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(arrayAsString[i]);
        }
        int counter = 0;
        int longest = 0;
        int num = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1]) {
                counter++;
            } else {
                counter = 0;
            }
            if (counter > longest) {
                longest = counter;
                num = array[i];
            }
        }
        for (int i = 0; i <= longest; i++) {
            System.out.print(num + " ");
        }
    }
}
