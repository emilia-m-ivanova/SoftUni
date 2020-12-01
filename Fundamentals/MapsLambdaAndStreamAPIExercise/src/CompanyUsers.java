import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, List<String>> companies = new HashMap<>();
        while (!input.equals("End")) {
            String[] details = input.split(" -> ");
            String companyName = details[0];
            String employeeID = details[1];
            companies.putIfAbsent(companyName, new ArrayList<>());
            if (!companies.get(companyName).contains(employeeID)) {
                companies.get(companyName).add(employeeID);
            }
            input = scanner.nextLine();
        }
        companies.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> {
                    System.out.println(e.getKey());
                    e.getValue()
                            .forEach(id -> System.out.printf("-- %s%n", id));
                });
    }
}
