import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        ArrayDeque <Integer> binaryNum = new ArrayDeque<>();
        if(num==0){
            System.out.println(0);
            return;
        }
        while (num>0){
            binaryNum.push(num%2);
            num=num/2;
        }
        while (!binaryNum.isEmpty()){
            System.out.print(binaryNum.pop());
        }
    }
}
