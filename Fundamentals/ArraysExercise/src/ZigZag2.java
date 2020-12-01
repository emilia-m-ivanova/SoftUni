import java.util.Scanner;

public class ZigZag2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] firstArray = new String[n];
        String[] secondArray = new String[n];
        for (int i = 0; i < n; i++) {
            String firstNum = scanner.next();
            String secondNum = scanner.next();
            if (i % 2 == 0) {
                firstArray[i] = firstNum;
                secondArray[i] = secondNum;
            } else {
                firstArray[i] = secondNum;
                secondArray[i] = firstNum;
            }

        }
        System.out.println(String.join(" ", firstArray));
        System.out.println(String.join(" ", secondArray));
    }
}
