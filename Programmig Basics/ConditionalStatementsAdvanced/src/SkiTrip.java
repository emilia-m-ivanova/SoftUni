import java.util.Scanner;

public class SkiTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        String room = scanner.nextLine();
        String rating = scanner.nextLine();
        int priceNights = 0;
        double discount = 0;
        int nights = days-1;
        switch (room) {
            case "room for one person":
                priceNights = nights* 18;
                break;
            case "apartment":
                priceNights = nights * 25;
                if (nights < 10) {
                    discount = priceNights * 30 * 0.01;
                } else if (nights <= 15) {

                    discount = priceNights * 35 * 0.01;
                } else {
                    discount = priceNights * 50 * 0.01;
                }
                break;
            case "president apartment":
                priceNights = nights * 35;
                if (nights < 10) {
                    discount = priceNights * 10 * 0.01;
                } else if (nights <= 15) {

                    discount = priceNights * 15 * 0.01;
                } else {
                    discount = priceNights * 20 * 0.01;
                }
                break;
        }
        double priceFinal = priceNights - discount;
        double ratingSum = 0;
        if (rating.equals("positive")) {
            ratingSum = priceFinal + (priceFinal * 25 * 0.01);
        } else if (rating.equals("negative")) {
            ratingSum = priceFinal - (priceFinal * 10 * 0.01);
        }
        System.out.printf("%.2f", ratingSum);
    }
}
