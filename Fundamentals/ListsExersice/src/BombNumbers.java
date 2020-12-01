import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integerList = readList(scanner);
        int bombNumber = scanner.nextInt();
        int power = scanner.nextInt();
        int i = 0;
        while (i < integerList.size()) {
            if (integerList.get(i) == bombNumber) {
                int difference = 0;
                if (i - power >= 0) {
                    i -= power;
                } else {
                    difference = Math.abs(i - power);
                    i = 0;
                }
                for (int j = 0; j < power * 2 + 1 - difference; j++) {
                    if (i < integerList.size()) {
                        integerList.remove(i);
                    }
                }
            } else {
                i++;
            }
        }
        int sum = 0;
        for (Integer element : integerList) {
            sum += element;
        }
        System.out.println(sum);

    }

    private static List<Integer> readList(Scanner scanner) {
        String[] integersAsString = scanner.nextLine().split(" ");
        List<Integer> integerList = new ArrayList<>();
        for (String element : integersAsString) {
            integerList.add(Integer.parseInt(element));
        }
        return integerList;
    }
}
