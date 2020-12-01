import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TribonacciSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= num; i++) {
            System.out.print(getTribonacci(i)+" ");
        }
    }

    public static List<Long> tribArray =new ArrayList<>();
    public static long getTribonacci(int i) {
        long tribValue;
        if (i==0){
            return 0;
        }
        if(i==1){
            return 1;
        }
        if(i==2){
            return 1;
        }
        if(tribArray.size()>i){
            return tribArray.get(i);
        }
        tribValue=getTribonacci(i-1)+getTribonacci(i-2)+getTribonacci(i-3);
        tribArray.add(tribValue);
        return tribValue;
    }

}
