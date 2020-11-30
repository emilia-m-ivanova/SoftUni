import java.util.Scanner;

public class NumberPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        int current = 1;
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {

                System.out.print(current + " ");
                current++;
                if (current > num) {
                    break;
                }
            }
            if (current > num) {
                break;
            }
            System.out.println();
        }
    }
}
