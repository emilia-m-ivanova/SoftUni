import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integerList = readList(scanner);
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] command = input.split(" ");
            switch (command[0]) {
                case "Contains":
                    int num = Integer.parseInt(command[1]);
                    if (integerList.contains(num)) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    printEvenOrOddElements(integerList, command);
                    break;
                case "Get":
                    int sum = 0;
                    for (Integer element : integerList) {
                        sum += element;
                    }
                    System.out.println(sum);
                    break;
                case "Filter":
                    String operator = command[1];
                    int n = Integer.parseInt(command[2]);
                    printFilteredList(integerList, operator, n);
                    break;
            }

            input = scanner.nextLine();
        }
    }

    private static void printFilteredList(List<Integer> integerList, String operator, int n) {
        switch (operator) {
            case "<":
                for (Integer element : integerList) {
                    if (element < n) {
                        System.out.print(element + " ");
                    }
                }
                break;
            case ">":
                for (Integer element : integerList) {
                    if (element > n) {
                        System.out.print(element + " ");
                    }
                }
                break;
            case ">=":
                for (Integer element : integerList) {
                    if (element >= n) {
                        System.out.print(element + " ");
                    }
                }
                break;
            case "<=":
                for (Integer element : integerList) {
                    if (element <= n) {
                        System.out.print(element + " ");
                    }
                }
                break;
        }
        System.out.println();

    }

    public static void printEvenOrOddElements(List<Integer> integerList, String[] command) {
        switch (command[1]) {
            case "even":
                for (Integer element : integerList) {
                    if (element % 2 == 0) {
                        System.out.print(element + " ");
                    }
                }
                System.out.println();
                break;
            case "odd":
                for (Integer element : integerList) {
                    if (element % 2 != 0) {
                        System.out.print(element + " ");
                    }
                }
                System.out.println();
                break;
        }
    }

    private static List<Integer> readList(Scanner scanner) {
        String[] numbersAsString = scanner.nextLine().split(" ");
        List<Integer> integerList = new ArrayList<>();
        for (String element : numbersAsString) {
            integerList.add(Integer.parseInt(element));
        }

        return integerList;
    }
}
