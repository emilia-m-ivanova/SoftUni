import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int capacity = 255;
        for (int i = 0; i < n; i++) {
            int liters = Integer.parseInt(scanner.nextLine());
            if(capacity<liters){
                System.out.println("Insufficient capacity!");
                continue;
            }
            capacity-=liters;
        }
        System.out.println(255-capacity);
    }
}
