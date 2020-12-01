import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> students = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());
            students.putIfAbsent(name,new ArrayList<>());
            students.get(name).add(grade);
        }
        students.entrySet()
                .stream()
                .filter(s->s.getValue()
                        .stream()
                        .mapToDouble(Double::doubleValue)
                        .average()
                        .getAsDouble()>=4.5)
                .sorted((s1,s2)->{
                    double first = s1.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
                    double second = s2.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
                    return Double.compare(second,first);
                })
                .forEach(s-> System.out.println(s.getKey()+ " -> "+String.format("%.2f",
                        s.getValue()
                                .stream()
                                .mapToDouble(Double::doubleValue)
                                .average()
                                .getAsDouble())));
    }
}
