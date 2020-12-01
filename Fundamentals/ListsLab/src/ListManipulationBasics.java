import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integerList = readList(scanner);
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] command = input.split(" ");
            switch (command[0]) {
                case "Add":
                    integerList.add(Integer.parseInt(command[1]));
                    break;
                case "Remove":
                    integerList.remove((Integer) Integer.parseInt(command[1]));
                    break;
                case "RemoveAt":
                    integerList.remove(Integer.parseInt(command[1]));
                    break;
                case "Insert":
                    integerList.add(Integer.parseInt(command[2]), Integer.parseInt(command[1]));
                    break;
            }

            input = scanner.nextLine();
        }

        for (Integer integer : integerList) {
            System.out.print(integer + " ");
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
