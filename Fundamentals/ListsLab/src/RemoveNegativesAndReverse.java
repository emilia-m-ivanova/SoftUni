import java.util.*;

public class RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integerList = readList(scanner);
        integerList.removeIf(element -> element < 0);
        Collections.reverse(integerList);
        if (!integerList.isEmpty()) {
            for (Integer element : integerList) {
                System.out.print(element + " ");
            }
        }else {
            System.out.println("empty");
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
