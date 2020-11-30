import java.util.Scanner;

public class EasterBake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int briocheNum = Integer.parseInt(scanner.nextLine());
        int sugarSum = 0;
        int flourSum = 0;
        int sugarMax = Integer.MIN_VALUE;
        int flourMax = Integer.MIN_VALUE;
        for (int i = 1; i <=briocheNum ; i++) {
            int sugar = Integer.parseInt(scanner.nextLine());
            int flour = Integer.parseInt(scanner.nextLine());
            if(sugar>sugarMax){
                sugarMax=sugar;
            }
            if(flour>flourMax){
                flourMax=flour;
            }
            sugarSum+=sugar;
            flourSum+=flour;
        }
        System.out.printf("Sugar: %.0f%nFlour: %.0f%nMax used flour is %d grams, max used sugar is %d grams.",Math.ceil(sugarSum*1./950),Math.ceil(flourSum*1.0/750),flourMax,sugarMax);
    }
}
