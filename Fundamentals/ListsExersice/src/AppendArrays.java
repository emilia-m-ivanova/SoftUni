import java.util.Scanner;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split("\\|");
        for (int i = array.length - 1; i >= 0; i--) {
            String miniArrayLine = array[i];
            String[] miniArray = miniArrayLine.split("\\s+");
            for (String element : miniArray) {
                if (!element.equals("")) {
                    System.out.print(element + " ");
                }
            }
        }
    }
}
