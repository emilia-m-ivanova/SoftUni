import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,Person> people = new HashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("End")){
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            people.putIfAbsent(name,new Person(name));
            Person person = people.get(name);
            addPersonalInfo(tokens, person);
            input = scanner.nextLine();
        }
        String nameToPrint = scanner.nextLine();
        Person personToPrint = people.get(nameToPrint);
        System.out.println(personToPrint.toString());
    }

    private static void addPersonalInfo(String[] tokens, Person person) {
        switch (tokens[1]){
            case "company":
                String companyName = tokens[2];
                String department = tokens[3];
                double salary = Double.parseDouble(tokens[4]);
                person.setCompany(new Company(companyName,department,salary));
                break;
            case "pokemon":
                String pokemonName = tokens[2];
                String pokemonType = tokens[3];
                person.getPokemons().add(new Pokemon(pokemonName,pokemonType));
                break;
            case "parents":
                String parentName = tokens[2];
                String parentBirthday = tokens[3];
                person.getParents().add(new Parent(parentName,parentBirthday));
                break;
            case "children":
                String childName = tokens[2];
                String childBirthday = tokens[3];
                person.getChildren().add(new Child(childName,childBirthday));
                break;
            case "car":
                String carModel = tokens[2];
                String carSpeed = tokens[3];
                person.setCar(new Car(carModel,carSpeed));
                break;
        }
    }
}
