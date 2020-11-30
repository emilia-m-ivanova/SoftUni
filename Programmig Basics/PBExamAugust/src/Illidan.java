import java.util.Scanner;

public class Illidan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int participants = Integer.parseInt(scanner.nextLine());
        int strengthPerOne = Integer.parseInt(scanner.nextLine());
        int IlidanStrength = Integer.parseInt(scanner.nextLine());
        int strenghtSum = strengthPerOne*participants;
        int diff = Math.abs(IlidanStrength-strenghtSum);

        if(strenghtSum>=IlidanStrength){
            System.out.printf("Illidan has been slain! You defeated him with %d points.",diff);
        }else{
            System.out.printf("You are not prepared! You need %d more points.",diff);
        }
    }
}
