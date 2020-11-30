import java.util.Scanner;

public class HotelRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String month = scanner.nextLine();
        int nights = Integer.parseInt(scanner.nextLine());
        double priceApartment = 0;
        double priceStudio = 0;
        switch (month) {
            case "May":
            case "October":
                priceApartment = 65 * nights;
                priceStudio = 50 * nights;
                if (nights > 14) {
                    priceStudio = priceStudio - priceStudio * 30 * 0.01;
                } else if (nights > 7) {
                    priceStudio = priceStudio - priceStudio * 5 * 0.01;
                }
                break;
            case "September":
            case "June":
                priceApartment = 68.70 * nights;
                priceStudio = 75.20 * nights;
                if (nights > 14) {
                    priceStudio = priceStudio - priceStudio * 20 * 0.01;
                }
                break;
            case "July":
            case "August":
                priceApartment = 77 * nights;
                priceStudio = 76 * nights;
        }
        if (nights > 14) {
            priceApartment = priceApartment - priceApartment * 10 * 0.01;
        }
        System.out.printf("Apartment: %.2f lv.%n", priceApartment);
        System.out.printf("Studio: %.2f lv.", priceStudio);
    }
}
