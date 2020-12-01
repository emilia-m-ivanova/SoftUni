import java.util.Scanner;

public class MultiplicationSign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        int n3 = Integer.parseInt(scanner.nextLine());

        int negativeCount = 0;
        if(isNegative(n1)){
            negativeCount++;
        }
        if(isNegative(n2)){
            negativeCount++;
        }
        if(isNegative(n3)){
            negativeCount++;
        }
        if(isZero(n1)||isZero(n2)||isZero(n3)){
            System.out.println("zero");
        }else if(negativeCount%2!=0){
            System.out.println("negative");
        }else{
            System.out.println("positive");
        }

    }
    public static boolean isZero (int n){
        return n==0;
    }
    public static boolean isNegative (int n){
        return n<0;
    }
}
