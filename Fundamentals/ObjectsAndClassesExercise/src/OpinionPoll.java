import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class OpinionPoll {
    static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public int getAge(){
            return this.age;
        }

        public String getName(){
            return this.name;
        }

        public String toString(){
            return String.format("%s - %d",name,age);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Person> peopleList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String [] input = scanner.nextLine().split("\\s+");
            Person person = new Person(input[0],Integer.parseInt(input[1]));
            peopleList.add(person);
        }
        peopleList.sort(Comparator.comparing(Person::getName));
        for (Person person : peopleList) {
            if(person.getAge()>30){
                System.out.println(person.toString());
            }
        }
    }
}
