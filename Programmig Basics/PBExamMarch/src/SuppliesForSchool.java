import java.util.Scanner;

public class SuppliesForSchool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Пакет химикали - 5.80 лв
        //• Пакет маркери - 7.20 лв
        //• Препарат - 1.20 лв (за литър)
        int pens = Integer.parseInt(scanner.nextLine());
        int markers = Integer.parseInt(scanner.nextLine());
        double detergent = Double.parseDouble(scanner.nextLine());
        int percent = Integer.parseInt(scanner.nextLine());
        double sumAll = pens*5.8+markers*7.2+detergent*1.2;
        double discount = sumAll*percent*0.01;
        System.out.printf("%.3f",sumAll-discount);
    }
}
