import java.util.Scanner;

public class EasterEggsBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int eggsOne = Integer.parseInt(scanner.nextLine());
        int eggsTwo = Integer.parseInt(scanner.nextLine());
        String winner = scanner.nextLine();
        while (!winner.equals("End of battle")){
            switch (winner){
                case "one":
                    eggsTwo-=1;
                    break;
                case "two":
                    eggsOne-=1;
            }
            if(eggsOne==0 || eggsTwo==0){
                break;
            }
            winner = scanner.nextLine();
        }
        if(eggsOne==0){
            System.out.printf("Player one is out of eggs. Player two has %d eggs left.",eggsTwo);
        }else if(eggsTwo==0){
            System.out.printf("Player two is out of eggs. Player one has %d eggs left.",eggsOne);
        }else{
            System.out.printf("Player one has %d eggs left.%nPlayer two has %d eggs left.",eggsOne,eggsTwo);
        }
    }
}
