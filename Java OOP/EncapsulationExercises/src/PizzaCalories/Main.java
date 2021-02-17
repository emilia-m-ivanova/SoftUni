package PizzaCalories;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pizzaString = scanner.nextLine().split(" ");
        Pizza pizza;
        try {
            pizza = new Pizza(pizzaString[1], Integer.parseInt(pizzaString[2]));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return;
        }

        String[] doughString = scanner.nextLine().split("\\s+");
        try {
            Dough dough = new Dough(doughString[1], doughString[2], Double.parseDouble(doughString[3]));
            pizza.setDough(dough);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return;
        }

        String toppingString = scanner.nextLine();
        while (!toppingString.equals("END")) {
            String[] tokens = toppingString.split("\\s+");
            try {
                Topping topping = new Topping(tokens[1], Double.parseDouble(tokens[2]));
                pizza.addTopping(topping);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                return;
            }
            toppingString = scanner.nextLine();
        }

        System.out.println(pizza.toString());
    }
}
