package animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("Beast!")) {
            String[] details = scanner.nextLine().split("\\s+");
            Animal animal = null;
            switch (input) {
                case "Dog":
                    try {
                        animal = new Dog(details[0], Integer.parseInt(details[1]), details[2]);
                    } catch (Exception e) {
                        System.out.println("Invalid input!");
                    }
                    break;
                case "Cat":
                    try {
                        animal = new Cat(details[0], Integer.parseInt(details[1]), details[2]);
                    } catch (Exception e) {
                        System.out.println("Invalid input!");
                    }
                    break;
                case "Frog":
                    try {
                        animal = new Frog(details[0], Integer.parseInt(details[1]), details[2]);
                    } catch (Exception e) {
                        System.out.println("Invalid input!");
                    }
                    break;
                case "Kitten":
                    try {
                        animal = new Kitten(details[0], Integer.parseInt(details[1]), details[2]);
                    } catch (Exception e) {
                        System.out.println("Invalid input!");
                    }
                    break;
                case "Tomcat":
                    try {
                        animal = new Tomcat(details[0], Integer.parseInt(details[1]), details[2]);
                    } catch (Exception e) {
                        System.out.println("Invalid input!");
                    }
                    break;
            }
            if (animal != null) {
                System.out.println(animal);
            }
            input = scanner.nextLine();
        }
    }
}
