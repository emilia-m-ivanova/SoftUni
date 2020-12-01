import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integerList = readList(scanner);
        int maxCapacity = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] command = input.split(" ");

            if (command[0].equals("Add")) {
                int passengers = Integer.parseInt(command[1]);
                integerList.add(passengers);
            } else {
                int passengers = Integer.parseInt(command[0]);
                fillWagon(integerList, maxCapacity, passengers);
            }

            input = scanner.nextLine();
        }
        for (Integer element : integerList) {
            System.out.print(element + " ");
        }
    }

    private static void fillWagon(List<Integer> integerList, int maxCapacity, int passengers) {
        for (int i = 0; i < integerList.size(); i++) {
            int element = integerList.get(i);
            if (element + passengers <= maxCapacity) {
                integerList.set(i, element + passengers);
                break;
            }
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
