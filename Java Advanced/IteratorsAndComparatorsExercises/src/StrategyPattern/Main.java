package StrategyPattern;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<Person> peopleByName = new TreeSet<>(new CompareByName());
        Set<Person> peopleByAge = new TreeSet<>(new CompareByAge());
        for (int i = 0; i < n; i++) {
            String[] info = scanner.nextLine().split("\\s+");
            Person person = new Person(info[0],Integer.parseInt(info[1]));
            peopleByName.add(person);
            peopleByAge.add(person);
        }

        for (Person person : peopleByName) {
            System.out.println(person);
        }
        for (Person person : peopleByAge) {
            System.out.println(person);
        }
    }
}
