import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstList = readList(scanner);
        List<Integer> secondList = readList(scanner);
        List<Integer> outputList = new ArrayList<>();
        int index = 0;
        while (index < firstList.size() || index < secondList.size()) {
            if (index < firstList.size()) {
                outputList.add(firstList.get(index));
            }
            if (index < secondList.size()) {
                outputList.add(secondList.get(index));
            }
            index++;
        }

        for (Integer element : outputList) {
            System.out.print(element + " ");
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
