import java.util.Scanner;

public class EasterLunch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int brioche = Integer.parseInt(scanner.nextLine());
        int eggs = Integer.parseInt(scanner.nextLine());
        int biscuits = Integer.parseInt(scanner.nextLine());
        double price = brioche * 3.2 + eggs * 4.35 + biscuits *5.4+eggs*12*0.15;
        System.out.printf("%.2f",price);
    }
}