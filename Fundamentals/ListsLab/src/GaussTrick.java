import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integerList = readList(scanner);
        int size = integerList.size();
        for (int i = 0; i < size / 2; i++) {
            integerList.set(i, integerList.get(i) + integerList.get(integerList.size() - 1));
            integerList.remove(integerList.size() - 1);
        }
        for (Integer element : integerList) {
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
