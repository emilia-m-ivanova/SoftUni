import java.util.Scanner;

public class Rate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sum = Double.parseDouble(scanner.nextLine());
        int months = Integer.parseInt(scanner.nextLine());
        double simpleInterest = 0;
        double complexInterest = 0;
        double sumAfterComplexInterest = 0;
        for (int i = 1; i <=months ; i++) {
            sumAfterComplexInterest=sum+complexInterest;
            simpleInterest+=sum*3*0.01;
            complexInterest+=sumAfterComplexInterest*2.7*0.01;
        }
        System.out.printf("Simple interest rate: %.2f lv.%nComplex interest rate: %.2f lv.%n",sum+simpleInterest,sum+complexInterest);
        double diff = Math.abs((sum+complexInterest)-(sum+simpleInterest));
        if((sum+complexInterest)>(sum+simpleInterest)){
            System.out.printf("Choose a complex interest rate. You will win %.2f lv.",diff);
        }else{
            System.out.printf("Choose a simple interest rate. You will win %.2f lv.",diff);
        }
    }
}
