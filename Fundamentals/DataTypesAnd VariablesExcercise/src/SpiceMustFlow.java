import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstYield = Integer.parseInt(scanner.nextLine());
        int counterDays = 0;
        int spice = 0;
        while (firstYield>=100){
            spice+=(firstYield-26);
            counterDays++;
            firstYield-=10;
        }
        if(spice>=26){
            spice-=26;
        }
        System.out.printf("%d%n%d",counterDays,spice);

    }
}
