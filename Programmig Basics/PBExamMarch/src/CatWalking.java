import java.util.Scanner;

public class CatWalking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //1min=5calories
        int min = Integer.parseInt(scanner.nextLine());
        int count = Integer.parseInt(scanner.nextLine());
        int calories = Integer.parseInt(scanner.nextLine());
        int burnedCalories = min*count*5;
        if(burnedCalories>=calories/2){
            System.out.printf("Yes, the walk for your cat is enough. Burned calories per day: %d.",burnedCalories);
        }else{
            System.out.printf("No, the walk for your cat is not enough. Burned calories per day: %d.",burnedCalories);
        }
    }
}
