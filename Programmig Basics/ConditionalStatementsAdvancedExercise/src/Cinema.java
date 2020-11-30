import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        int r = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());
        int tickets = r * c;
        double total = 0;
        switch (type) {
            case "Premiere":
                total = tickets * 12;
                break;
            case "Normal":
                total = tickets * 7.5;
                break;
            case "Discount":
                total = tickets * 5;
                break;
        }
        System.out.printf("%.2f leva", total);
    }
}
