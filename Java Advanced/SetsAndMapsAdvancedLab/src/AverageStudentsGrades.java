import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String,List<Double>> students = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            double grade = Double.parseDouble(input[1]);
            students.putIfAbsent(name,new ArrayList<>());
            students.get(name).add(grade);
        }
        students.forEach((k,v)-> {
            System.out.print(k+" -> ");
            double sum = 0;
            for (Double grade : v) {
                sum+=grade;
                System.out.printf("%.2f ",grade);
            }
            double average = sum/v.size();
            System.out.printf("(avg: %.2f)%n",average);
        });
    }
}
