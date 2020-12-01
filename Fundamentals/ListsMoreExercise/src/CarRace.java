import java.util.Scanner;

public class CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arrayAsStrings = scanner.nextLine().split("\\s+");
        double[] arrayOfNumbers = new double[arrayAsStrings.length];
        for (int i = 0; i < arrayOfNumbers.length; i++) {
            arrayOfNumbers[i]=Double.parseDouble(arrayAsStrings[i]);
        }
        double sumLeft = 0;
        double sumRight = 0;
        for (int i = 0; i < arrayOfNumbers.length/2; i++) {
            double left = arrayOfNumbers[i];
            double right = arrayOfNumbers[arrayOfNumbers.length-1-i];
            if(left==0){
                sumLeft=sumLeft*0.8;
            }
            if(right==0){
                sumRight=sumRight*0.8;
            }
            sumLeft+=left;
            sumRight+=right;
        }
        if(sumLeft<sumRight){
            System.out.printf("The winner is left with total time: %.1f",sumLeft);
        }else{
            System.out.printf("The winner is right with total time: %.1f",sumRight);
        }
    }
}
