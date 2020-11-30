import java.util.Scanner;

public class PaintingEggs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String size = scanner.nextLine();
        String colour = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());
        double pricePerOne = 0;
        switch (size) {
            case "Large":
                switch (colour) {
                    case "Red":
                        pricePerOne =16;
                        break;
                    case "Green":
                        pricePerOne =12;
                        break;
                    case "Yellow":
                        pricePerOne =9;
                        break;
                }

                break;
            case "Medium":
                switch (colour) {
                    case "Red":
                        pricePerOne =13;
                        break;
                    case "Green":
                        pricePerOne =9;
                        break;
                    case "Yellow":
                        pricePerOne =7;
                        break;
                }
                break;
            case "Small":
                switch (colour) {
                    case "Red":
                        pricePerOne =9;
                        break;
                    case "Green":
                        pricePerOne =8;
                        break;
                    case "Yellow":
                        pricePerOne =5;
                        break;
                }
                break;
        }
        double priceTotal = (pricePerOne * quantity) * 65 * 0.01;
        System.out.printf("%.2f leva.", priceTotal);
    }
}
