import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> doubleList = ReadList(scanner);
        int i = 1;
        while (i < doubleList.size()) {
            if (doubleList.get(i).equals(doubleList.get(i - 1))) {
                doubleList.set(i - 1, doubleList.get(i) * 2);
                doubleList.remove(i);
                i = 1;
            } else {
                i++;
            }
        }

        for (Double element : doubleList) {
            DecimalFormat decimalFormat = new DecimalFormat("###.##");
            System.out.print(decimalFormat.format(element) + " ");
        }

    }

    public static List<Double> ReadList(Scanner scanner) {
        String[] numbersAsStrings = scanner.nextLine().split(" ");
        List<Double> doubleList = new ArrayList<>();

        for (String element : numbersAsStrings) {
            doubleList.add(Double.parseDouble(element));
        }

        return doubleList;
    }
}
