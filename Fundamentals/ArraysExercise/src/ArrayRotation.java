import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int rotations = scanner.nextInt();
        String[] array = line.split(" ");
        for (int i = 0; i < rotations; i++) {
            String lastElement = array[array.length - 1];
            array[array.length - 1] = array[0];
            for (int j = 0; j < array.length - 1; j++) {
                array[j] = array[j + 1];
            }
            array[array.length - 2] = lastElement;
        }
        System.out.println(String.join(" ", array));
    }
}
