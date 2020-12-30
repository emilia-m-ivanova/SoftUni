import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<Person> people = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String[] personInfo = scanner.nextLine().split("\\s+");
            Person person = new Person(personInfo[0],Integer.parseInt(personInfo[1]));
            people.add(person);
        }
        people.stream()
                .filter(e->e.getAge()>30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(p-> System.out.println(p.toString()));
    }
}
