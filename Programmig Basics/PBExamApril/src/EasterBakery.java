import java.util.Scanner;

public class EasterBakery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double priceFlour = Double.parseDouble(scanner.nextLine());
        double flourKg = Double.parseDouble(scanner.nextLine());
        double sugarKg = Double.parseDouble(scanner.nextLine());
        int eggsPackage = Integer.parseInt(scanner.nextLine());
        int yeast = Integer.parseInt(scanner.nextLine());
        double priceSugar = priceFlour-(priceFlour*25*0.01);
        double priceEggsPackage = priceFlour+(priceFlour*10*0.01);
        double priceYeast = priceSugar-(priceSugar*80*0.01);
        double sum = priceEggsPackage*eggsPackage+priceFlour*flourKg+priceSugar*sugarKg+priceYeast*yeast;
        System.out.printf("%.2f",sum);

    }
}
