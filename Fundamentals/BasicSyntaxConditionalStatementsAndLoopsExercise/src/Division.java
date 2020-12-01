import java.util.Scanner;

public class Division {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        //2, 3, 6, 7, 10.
        String output;
        if(num%10==0){
            output="The number is divisible by 10";
        }else if(num%7==0){
            output="The number is divisible by 7";
        }else if(num%6==0){
            output="The number is divisible by 6";
        }else if (num%3==0){
            output="The number is divisible by 3";
        }else if (num%2==0){
            output="The number is divisible by 2";
        }else {
            output="Not divisible";
        }

        System.out.println(output);
    }
}
