package WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Animal> animals = new ArrayList<>();
        while (!input.equals("End")){
            String[]tokens = input.split("\\s+");
            Animal animal = null;
            switch (tokens[0]){
                case "Cat":
                    animal = new Cat(tokens[0],tokens[1],Double.parseDouble(tokens[2]),tokens[3],tokens[4]);
                    break;
                case "Mouse":
                    animal = new Mouse(tokens[0],tokens[1],Double.parseDouble(tokens[2]),tokens[3]);
                    break;
                case "Tiger":
                    animal = new Tiger(tokens[0],tokens[1],Double.parseDouble(tokens[2]),tokens[3]);
                    break;
                case "Zebra":
                    animal = new Zebra(tokens[0],tokens[1],Double.parseDouble(tokens[2]),tokens[3]);
                    break;
            }
            animal.makeSound();
            String[] foodString = scanner.nextLine().split("\\s+");
            Food food;
            if(foodString[0].equals("Meat")){
                food = new Meat(Integer.parseInt(foodString[1]));
            }else{
                food = new Vegetable(Integer.parseInt(foodString[1]));
            }
            try {
                animal.eat(food);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            animals.add(animal);
            input = scanner.nextLine();
        }

        animals.forEach(System.out::println);
    }
}
