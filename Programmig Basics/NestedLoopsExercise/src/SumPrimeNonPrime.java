import java.util.Scanner;

public class SumPrimeNonPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int prime = 0;
        int nonPrime = 0;
        while (!input.equals("stop")) {
            int num = Integer.parseInt(input);
            if(num<0){
                System.out.println("Number is negative.");
                input=scanner.nextLine();
                continue;
                }
            if((num%2==0 || num%3==0 ||num%5==0||num%7==0)&&(num!=2)&&(num!=3)&&(num!=5)&&(num!=7)){
                nonPrime+=num;
            } else {
                prime+=num;
            }
            input= scanner.nextLine();
        }
        System.out.println("Sum of all prime numbers is: "+prime);
        System.out.println("Sum of all non prime numbers is: "+nonPrime);
    }
}
