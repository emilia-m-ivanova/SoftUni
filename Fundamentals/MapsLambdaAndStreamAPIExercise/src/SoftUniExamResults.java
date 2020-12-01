import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> submissions = new TreeMap<>();
        Map<String, Integer> points = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("exam finished")) {
            String[] array = input.split("-");
            String username = array[0];
            if (array[1].equals("banned")) {
                points.remove(username);
            } else {
                String language = array[1];
                int currentPoints = Integer.parseInt(array[2]);
                submissions.putIfAbsent(language, 0);
                submissions.put(language, submissions.get(language) + 1);
                if (!points.containsKey(username) || points.get(username) < currentPoints) {
                    points.put(username, currentPoints);
                }
            }
            input = scanner.nextLine();
        }
        System.out.println("Results:");
        points.entrySet()
                .stream()
                .sorted((a,b)->b.getValue().compareTo(a.getValue()))
                .forEach(e-> System.out.printf("%s | %d%n",e.getKey(),e.getValue()));
        System.out.println("Submissions:");
        submissions.entrySet()
                .stream()
                .sorted((a,b)->b.getValue().compareTo(a.getValue()))
                .forEach(e-> System.out.printf("%s - %d%n",e.getKey(),e.getValue()));
    }
}
