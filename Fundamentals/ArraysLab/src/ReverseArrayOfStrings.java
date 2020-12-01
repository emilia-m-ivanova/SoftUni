import java.util.Scanner;

public class ReverseArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] arrayOfStrings = line.split(" ");
        for (int i = 0; i < arrayOfStrings.length/2; i++) {
            String oldValue = arrayOfStrings[i];
            arrayOfStrings[i]=arrayOfStrings[arrayOfStrings.length-1-i];
            arrayOfStrings[arrayOfStrings.length-1-i]=oldValue;
        }
        System.out.println(String.join(" ",arrayOfStrings));
    }
}
