import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firsLine = scanner.nextLine();
        String secondLine = scanner.nextLine();
        String [] firstArray = firsLine.split(" ");
        String [] secondArray = secondLine.split(" ");
        for (String secondValue : secondArray) {
            for (String firstValue : firstArray) {
                if (firstValue.equals(secondValue)) {
                    System.out.print(secondValue + " ");
                }
            }
        }
    }
}
