import java.util.Random;
import java.util.Scanner;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] arrayOfStrings = scanner.nextLine().split(" ");
        Random rnd = new Random();
        for (int i = 0; i < arrayOfStrings.length; i++) {
            String currentElement = arrayOfStrings[i];
            int newPosition = rnd.nextInt(arrayOfStrings.length);
            arrayOfStrings[i]=arrayOfStrings[newPosition];
            arrayOfStrings[newPosition]=currentElement;
        }
        System.out.println(String.join(System.lineSeparator(),arrayOfStrings));
    }
}
