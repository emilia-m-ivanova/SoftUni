import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Person> people = new LinkedHashSet<>();
        String personInfo = scanner.nextLine();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            if (input.contains("-")) {
                String[] tokens = input.split(" - ");
                String parentInfo = tokens[0];
                String childInfo = tokens[1];
                Person parent = createPerson(parentInfo);
                Person child = createPerson(childInfo);
                parent = addAndGetPerson(people, parent);
                child = addAndGetPerson(people, child);
                for (Person person : people) {
                    if (person.getName().equals(parent.getName()) &&
                            person.getBirthday().equals(parent.getBirthday())) {
                        person.getChildren().add(child);
                    }
                    if (person.getName().equals(child.getName()) &&
                            person.getBirthday().equals(child.getBirthday())) {
                        person.getParents().add(parent);
                    }
                }

            } else {
                String[] tokens = input.split(" ");
                String name = tokens[0] + " " + tokens[1];
                String birthday = tokens[2];
                boolean personExists = false;
                for (Person p : people) {
                    if (p.getName().equals(name)) {
                        p.setBirthday(birthday);
                        personExists = true;
                    }
                    if (p.getBirthday().equals(birthday)) {
                        p.setName(name);
                        personExists = true;
                    }
                }
                if(!personExists){
                    Person person = new Person();
                    person.setName(name);
                    person.setBirthday(birthday);
                    people.add(person);
                }
            }

            input = scanner.nextLine();
        }
        Person personToSearch;
        if (Character.isDigit(personInfo.charAt(0))) {
            personToSearch = people.stream()
                    .filter(p -> p.getBirthday().equals(personInfo))
                    .findAny().get();
        } else {
            personToSearch = people.stream()
                    .filter(p -> p.getName().equals(personInfo))
                    .findAny().get();
        }
        List<Person> parents = new ArrayList<>();
        List<Person> children = new ArrayList<>();
        people.stream()
                .filter(p -> p.getParents().stream().anyMatch(a -> a.getName().equals(personToSearch.getName())||
                        a.getBirthday().equals(personToSearch.getBirthday())))
                .forEach(children::add);
        people.stream()
                .filter(p -> p.getChildren().stream().anyMatch(a -> a.getName().equals(personToSearch.getName())||
                        a.getBirthday().equals(personToSearch.getBirthday())))
                .forEach(parents::add);

        System.out.println(personToSearch.getName() + " " + personToSearch.getBirthday());
        System.out.println("Parents:");
        for (Person parent : parents) {
            System.out.println(parent.getName() + " " + parent.getBirthday());
        }
        System.out.println("Children:");
        for (Person child : children) {
            System.out.println(child.getName() + " " + child.getBirthday());
        }
    }

    private static Person addAndGetPerson(Set<Person> people, Person person) {
        Person currentPerson;
        for (Person p : people) {
            if (p.getName().equals(person.getName()) && !p.getName().equals("") ||
                    p.getBirthday().equals(person.getBirthday()) && !p.getBirthday().equals("")) {
                currentPerson = p;
                return currentPerson;
            }
        }
        people.add(person);
        return person;
    }

    private static Person createPerson(String personInfo) {
        Person person = new Person();
        if (Character.isDigit(personInfo.charAt(0))) {
            person.setBirthday(personInfo);
        } else {
            person.setName(personInfo);
        }
        return person;
    }
}
