import java.util.Scanner;

public class ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double priceWithoutTax = 0;
        while (!input.equals("special") && !input.equals("regular")) {
            double price = Double.parseDouble(input);
            if (price >= 0) {
                priceWithoutTax += price;
            } else {
                System.out.println("Invalid price!");
            }
            input = scanner.nextLine();
        }
        double tax = priceWithoutTax * 0.2;
        double totalPrice = priceWithoutTax + tax;
        if (input.equals("special")) {
            totalPrice = totalPrice * 0.9;
        }
        if (totalPrice == 0) {
            System.out.println("Invalid order!");
        } else {
            System.out.printf("Congratulations you've just bought a new computer!%n" +
                    "Price without taxes: %.2f$%n" +
                    "Taxes: %.2f$%n" +
                    "-----------%n" +
                    "Total price: %.2f$",priceWithoutTax,tax,totalPrice);
        }
    }
}
