import java.util.Scanner;

public class Cake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int sqm = width*length;
        int pieces = 0;
        while(pieces<sqm){
            String input = scanner.nextLine();
            if(input.equals("STOP")){
                break;
            } else{
                pieces+= Integer.valueOf(input);
            }
        }
        int diff = Math.abs(sqm-pieces);
        if(pieces>sqm){
            System.out.printf("No more cake left! You need %d pieces more.",diff);
        } else {
            System.out.printf("%d pieces are left.",diff);
        }
    }
}
