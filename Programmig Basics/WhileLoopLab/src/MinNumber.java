import java.util.Scanner;

public class MinNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int minNum = Integer.MAX_VALUE;
        while (!input.equals("Stop")) {
            int num = Integer.parseInt(input);
            if (num < minNum) {
                minNum = num;
            }
            input = scan.nextLine();
        }
        System.out.println(minNum);
    }
}
