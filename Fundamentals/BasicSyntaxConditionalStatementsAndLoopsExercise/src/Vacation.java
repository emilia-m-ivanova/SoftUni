import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        String type = scanner.nextLine();
        String day = scanner.nextLine();
        double pricePerPerson = 0;
        double discount = 0;
        switch (type) {
            case "Business":
                switch (day) {
                    case "Friday":
                        pricePerPerson=10.9;
                        break;
                    case "Saturday":
                        pricePerPerson=15.6;
                        break;
                    case "Sunday":
                        pricePerPerson=16;
                        break;
                }
                if (num >= 100) {
                    discount=pricePerPerson*10;
                }
                break;
            case "Regular":
                switch (day) {
                    case "Friday":
                        pricePerPerson=15;
                        break;
                    case "Saturday":
                        pricePerPerson=20;
                        break;
                    case "Sunday":
                        pricePerPerson=22.5;
                        break;
                }
                if (10<=num && num<=20) {
                    discount=pricePerPerson*num*5*0.01;
                }
                break;
            case "Students":
                switch (day) {
                    case "Friday":
                        pricePerPerson=8.45;
                        break;
                    case "Saturday":
                        pricePerPerson=9.8;
                        break;
                    case "Sunday":
                        pricePerPerson=10.46;
                        break;
                }
                if (num >= 30) {
                    discount=pricePerPerson*num*15*0.01;
                }
                break;
        }
        double totalPrice = pricePerPerson * num-discount;
        System.out.printf("Total price: %.2f", totalPrice);
    }
}
