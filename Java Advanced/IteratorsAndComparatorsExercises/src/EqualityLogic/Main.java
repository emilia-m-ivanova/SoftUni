package EqualityLogic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<Person> treeSet = new TreeSet<>();
        Set<Person> hashSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String[] info = scanner.nextLine().split("\\s+");
            Person person = new Person(info[0],Integer.parseInt(info[1]));
            treeSet.add(person);
            hashSet.add(person);
        }

        System.out.println(treeSet.size());
        System.out.println(hashSet.size());

    }
}
