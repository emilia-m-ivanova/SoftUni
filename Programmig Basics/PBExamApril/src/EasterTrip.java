import java.util.Scanner;

public class EasterTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String destination = scanner.nextLine();
        String dates = scanner.nextLine();
        int days = Integer.parseInt(scanner.nextLine());
        double pricePerDay = 0;
        switch (destination) {
            case "Germany":
                switch (dates) {
                    case "21-23":
                        pricePerDay = 32;
                        break;
                    case "24-27":
                        pricePerDay = 37;
                        break;

                    case "28-31":
                        pricePerDay = 43;
                        break;
                }

                break;
            case "Italy":
                switch (dates) {
                    case "21-23":
                        pricePerDay = 28;
                        break;
                    case "24-27":
                        pricePerDay = 32;
                        break;

                    case "28-31":
                        pricePerDay = 39;
                        break;
                }
                break;
            case "France":
                switch (dates) {
                    case "21-23":
                        pricePerDay = 30;
                        break;
                    case "24-27":
                        pricePerDay = 35;
                        break;

                    case "28-31":
                        pricePerDay = 40;
                        break;
                }
                break;
        }

        double priceFinal = pricePerDay * days;
        System.out.printf("Easter trip to %s : %.2f leva.",destination,priceFinal);
    }
}
