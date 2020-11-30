import java.util.Scanner;

public class FoodDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int chicken = Integer.parseInt(scanner.nextLine());
        int fish = Integer.parseInt(scanner.nextLine());
        int vegetarian = Integer.parseInt(scanner.nextLine());
        double total = (chicken*10.35+fish*12.4+vegetarian*8.15)*120*0.01+2.5;
        System.out.printf("Total: %.2f",total);

    }
}
