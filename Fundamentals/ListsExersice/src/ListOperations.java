import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integerList = getIntegerList(scanner);
        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] command = input.split(" ");
            switch (command[0]) {
                case "Add":
                    integerList.add(Integer.parseInt(command[1]));
                    break;
                case "Insert":
                    insertElement(integerList, command);
                    break;
                case "Remove":
                    removeElement(integerList, command[1]);
                    break;
                case "Shift":
                    int count = Integer.parseInt(command[2]);
                    switch (command[1]) {
                        case "left":
                            shiftLeftElements(integerList, count);
                            break;
                        case "right":
                            shiftRightElements(integerList, count);
                            break;
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        for (Integer element : integerList) {
            System.out.print(element + " ");
        }

    }

    private static void removeElement(List<Integer> integerList, String s) {
        int removeIndex = Integer.parseInt(s);
        if (0 <= removeIndex && removeIndex < integerList.size()) {
            integerList.remove(removeIndex);
        } else {
            System.out.println("Invalid index");
        }
    }

    private static void insertElement(List<Integer> integerList, String[] command) {
        int number = Integer.parseInt(command[1]);
        int InsertIndex = Integer.parseInt(command[2]);
        if (0 <= InsertIndex && InsertIndex < integerList.size()) {
            integerList.add(InsertIndex, number);
        } else {
            System.out.println("Invalid index");
        }
    }

    private static void shiftRightElements(List<Integer> integerList, int count) {
        for (int i = 0; i < count; i++) {
            int number = integerList.get(integerList.size() - 1);
            integerList.add(0, number);
            integerList.remove(integerList.size() - 1);
        }

    }

    private static void shiftLeftElements(List<Integer> integerList, int count) {
        for (int i = 0; i < count; i++) {
            int number = integerList.get(0);
            integerList.add(number);
            integerList.remove(0);
        }

    }

    private static List<Integer> getIntegerList(Scanner scanner) {
        String[] integersAsString = scanner.nextLine().split(" ");
        List<Integer> integerList = new ArrayList<>();
        for (String element : integersAsString) {
            integerList.add(Integer.parseInt(element));
        }
        return integerList;
    }
}
