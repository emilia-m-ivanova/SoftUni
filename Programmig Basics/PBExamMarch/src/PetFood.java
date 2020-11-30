import java.util.Scanner;

public class PetFood {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        double food = Double.parseDouble(scanner.nextLine());
        double eatenDog = 0;
        double eatenCat = 0;
        double biscuits = 0;
        for (int i = 1; i <=days ; i++) {
            int foodDog = Integer.parseInt(scanner.nextLine());
            int foodCat = Integer.parseInt(scanner.nextLine());
            eatenCat+=foodCat;
            eatenDog+=foodDog;
            if(i%3==0){
                biscuits+=(foodCat+foodDog)*10*0.01;
            }
        }
        double eatenAll = eatenCat+eatenDog;
        System.out.printf("Total eaten biscuits: %dgr.%n",Math.round(biscuits));
        System.out.printf("%.2f%% of the food has been eaten.%n",eatenAll/food*100);
        System.out.printf("%.2f%% eaten from the dog.%n",eatenDog/eatenAll*100);
        System.out.printf("%.2f%% eaten from the cat.%n",eatenCat/eatenAll*100);

    }
}
