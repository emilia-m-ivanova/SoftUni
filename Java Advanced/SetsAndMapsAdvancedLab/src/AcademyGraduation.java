import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String,double[]> students = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble).toArray();
            students.put(name,grades);
        }
        students.forEach((k,v)->{
            double sum = 0;
            for (double grade : v) {
                sum+=grade;
            }
            double average = sum/v.length;
            DecimalFormat df = new DecimalFormat("#.################");
            System.out.println(k+" is graduated with "+df.format(average));
        });
    }
}
