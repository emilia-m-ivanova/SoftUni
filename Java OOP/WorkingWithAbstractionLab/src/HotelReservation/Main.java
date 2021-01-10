package HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] line = scanner.nextLine().split("\\s+");
        PriceCalculator calculator = new PriceCalculator(Double.parseDouble(line[0]),Integer.parseInt(line[1]),
                Season.valueOf(line[2].toUpperCase()),DiscountType.valueOf(line[3].toUpperCase()));
        System.out.printf("%.2f",calculator.calculatePrice());
    }
}
