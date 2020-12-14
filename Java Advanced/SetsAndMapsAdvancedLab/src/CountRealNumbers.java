import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        Map<Double,Integer> numbers = new LinkedHashMap<>();
        for (String string : input) {
            double num = Double.parseDouble(string);
            numbers.putIfAbsent(num,0);
            numbers.put(num,numbers.get(num)+1);
        }
        numbers.forEach((k,v)-> System.out.printf("%.1f -> %d%n",k,v));

    }
}
