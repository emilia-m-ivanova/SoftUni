import java.util.Scanner;

public class SantasCookies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int boxes = 0;
        for (int i = 0; i < n; i++) {
            int flour = Integer.parseInt(scanner.nextLine());
            int sugar = Integer.parseInt(scanner.nextLine());
            int cocoa = Integer.parseInt(scanner.nextLine());
            int totalCookies = (140+10+20)*Math.min(Math.min((flour/140),(sugar/20)),(cocoa/10))/25;
            if(totalCookies<=0){
                System.out.println("Ingredients are not enough for a box of cookies.");
            }else{
                boxes+=totalCookies/5;
                System.out.println("Boxes of cookies: "+totalCookies/5);
            }
        }
        System.out.println("Total boxes: "+boxes);
    }
}
