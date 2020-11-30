import java.util.Scanner;

public class WorldSwimmingRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double record = Double.parseDouble(scanner.nextLine());
        double meters = Double.parseDouble(scanner.nextLine());
        double time1m = Double.parseDouble(scanner.nextLine());
        double late = (Math.floor(meters / 15)) * 12.5;
        double result = (meters * time1m) + late;
        double diff = result - record;
        if (result >= record) {
            System.out.printf("No, he failed! He was %.2f seconds slower.", diff);
        } else {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", result);
        }
    }
}

