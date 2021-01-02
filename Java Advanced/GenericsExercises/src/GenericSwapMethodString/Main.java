package GenericSwapMethodString;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            stringList.add(scanner.nextLine());
        }
        ListManipulator.swapElements(stringList,scanner.nextInt(),scanner.nextInt());
        ListManipulator.printElements(stringList);
    }
}
