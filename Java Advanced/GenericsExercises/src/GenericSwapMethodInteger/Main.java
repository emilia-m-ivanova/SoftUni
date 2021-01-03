package GenericSwapMethodInteger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            integerList.add(Integer.parseInt(scanner.nextLine()));
        }
        ListManipulator.swapElements(integerList,scanner.nextInt(),scanner.nextInt());
        ListManipulator.printElements(integerList);
    }
}
