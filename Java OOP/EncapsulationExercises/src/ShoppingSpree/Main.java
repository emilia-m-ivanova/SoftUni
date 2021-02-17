package ShoppingSpree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //initialize products and people

        Map<String, Person> people = readPeople(scanner);
        Map<String, Product> products = readProducts(scanner);

        //buy products
        String buy = scanner.nextLine();
        while (!buy.equals("END")) {
            String[] tokens = buy.split(" ");
            if (people.containsKey(tokens[0])) {
                try {
                    people.get(tokens[0]).buyProduct(products.get(tokens[1]));
                    System.out.printf("%s bought %s%n", tokens[0], buy);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
            buy = scanner.nextLine();
        }
        people.forEach((k, v) -> System.out.println(v.toString()));

    }

    private static Map<String, Person> readPeople(Scanner scanner) {
        Map<String, Person> people = new LinkedHashMap<>();
        String[] peopleStrings = scanner.nextLine().split(";");
        for (String str : peopleStrings) {
            String[] tokens = str.split("=");
            try {
                Person person = new Person(tokens[0], Double.parseDouble(tokens[1]));
                people.put(tokens[0], person);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return people;
    }

    private static Map<String, Product> readProducts(Scanner scanner) {
        Map<String, Product> products = new LinkedHashMap<>();
        String[] productStrings = scanner.nextLine().split(";");

        for (String str : productStrings) {
            String[] tokens = str.split("=");
            try {
                Product product = new Product(tokens[0], Double.parseDouble(tokens[1]));
                products.put(tokens[0], product);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return products;
    }
}
