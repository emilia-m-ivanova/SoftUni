import java.util.Scanner;

public class HalfSumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int count = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int maxNum = Integer.MIN_VALUE;
        for (int i = 1; i <=count ; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            if(maxNum<num){
                maxNum=num;
            }
            sum+=num;
        }
        int sumTotal = sum-maxNum;
        int diff = Math.abs(sumTotal-maxNum);
        if (maxNum==sumTotal){
            System.out.printf("Yes %nSum = %d",sumTotal);
        } else{
            System.out.printf("No %nDiff = %d",diff);
        }
    }
}
