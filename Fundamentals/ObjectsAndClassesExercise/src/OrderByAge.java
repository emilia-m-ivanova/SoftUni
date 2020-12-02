import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class OrderByAge {
    static class Person {
        String name;
        String ID;
        int age;

        public Person (String name, String ID, int age){
            this.name = name;
            this.ID = ID;
            this.age = age;
        }

        public int getAge(){
            return this.age;
        }

        @Override
        public String toString() {
            return String.format("%s with ID: %s is %d years old.",name,ID,age);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List <Person> peopleList = new ArrayList<>();
        String input = scanner.nextLine();
        while(!input.equals("End")){
            String [] details = input.split("\\s+");
            Person person = new Person(details[0],details[1],Integer.parseInt(details[2]));
            peopleList.add(person);
            input=scanner.nextLine();
        }
        peopleList.sort(Comparator.comparing(Person::getAge));
        for (Person person : peopleList) {
            System.out.println(person.toString());
        }

    }
}
