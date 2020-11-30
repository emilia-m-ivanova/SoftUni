import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1111; i < 9999; i++) {
            int counter = 0;
            for (int j = 0; j < 4; j++) {
                char position = String.valueOf(i).charAt(j);
                int num = Integer.parseInt(String.valueOf(position));
                if (num != 0) {

                    if (n % num == 0) {
                        counter++;
                    }
                    if (counter == 4) {
                        System.out.print(i + " ");
                    }
                }

            }
        }
    }
}
//Пример: при N = 16, 2418 е специално число:
// 16 / 2 = 8 без остатък
// 16 / 4 = 4 без остатък
// 16 / 1 = 16 без остатък
// 16 / 8 = 2 без остатък