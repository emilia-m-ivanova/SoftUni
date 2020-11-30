import java.util.Scanner;

public class CareOfPuppy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int foodKg = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int foodGr = foodKg*1000;
        while(!input.equals("Adopted")){
            int grEaten = Integer.parseInt(input);
            foodGr-=grEaten;
            input= scanner.nextLine();
        }
        if(foodGr>=0){
            System.out.printf("Food is enough! Leftovers: %d grams.",foodGr);
        }else{
            System.out.printf("Food is not enough. You need %d grams more.",Math.abs(foodGr));
        }
    }
}
