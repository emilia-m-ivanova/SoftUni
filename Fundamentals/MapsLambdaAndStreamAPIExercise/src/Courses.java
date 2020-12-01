import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map <String, List<String>> courses = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("end")){
            String [] information = input.split(" : ");
            String courseName = information[0];
            String studentName = information[1];
            if(!courses.containsKey(courseName)){
                List <String> students = new ArrayList<>();
                courses.put(courseName,students);
            }

            courses.get(courseName).add(studentName);
            input = scanner.nextLine();
        }
        courses.entrySet().stream()
                .sorted((a,b)->Integer.compare(b.getValue().size(),a.getValue().size()))
        .forEach(entry-> {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue().size());
            entry.getValue().stream().sorted().forEach(s-> System.out.printf("-- %s%n",s));
        }
        );
    }
}
