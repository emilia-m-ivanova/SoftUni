import java.util.Scanner;

public class ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] integersAsStrings = scanner.nextLine().split(" ");
        int[] integerArray = new int[integersAsStrings.length];
        for (int i = 0; i < integerArray.length; i++) {
            integerArray[i] = Integer.parseInt(integersAsStrings[i]);
        }
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            int index = Integer.parseInt(input);
            if (0 <= index && index < integerArray.length &&
                    integerArray[index] != -1) {
                int value = integerArray[index];
                for (int i = 0; i < integerArray.length; i++) {
                    if (integerArray[i] != -1) {
                        if (integerArray[i] > value) {
                            integerArray[i] -= value;
                        } else {
                            integerArray[i] += value;
                        }
                    }
                }
                integerArray[index] = -1;
            }
            input = scanner.nextLine();
        }
        int counter = 0;
        for (int element : integerArray) {
            if (element == -1) {
                counter++;
            }
        }
        System.out.printf("Shot targets: %d -> ", counter);

        for (int i : integerArray) {
            System.out.print(i + " ");
        }


    }
}
