import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map <Double, Integer> counts = new TreeMap<>();
        double [] nums = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();
        for (double num : nums) {
            if(!counts.containsKey(num)){
                counts.put(num,0);
            }
            counts.put(num,counts.get(num)+1);
        }
        for (Map.Entry<Double, Integer> entry : counts.entrySet()) {
            DecimalFormat df = new DecimalFormat("#.######");
            System.out.printf("%s -> %d%n",df.format(entry.getKey()),entry.getValue());
        }


    }
}
