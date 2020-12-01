import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integerList = readList(scanner);
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] command = input.split("\\s+");
            int element = Integer.parseInt(command[1]);
            switch (command[0].toLowerCase()) {
                case "delete":
                    integerList.removeIf(e -> e.equals(element));
                    break;
                case "insert":
                    int index = Integer.parseInt(command[2]);
                    if (index < integerList.size()) {
                        integerList.add(index, element);
                    }
                    break;
            }

            input = scanner.nextLine();
        }
        for (Integer element : integerList) {
            System.out.print(element + " ");
        }

    }

    private static List<Integer> readList(Scanner scanner) {
        String[] numbersAsString = scanner.nextLine().split("\\s+");
        List<Integer> integerList = new ArrayList<>();
        for (String element : numbersAsString) {
            integerList.add(Integer.parseInt(element));
        }
        return integerList;
    }
}
