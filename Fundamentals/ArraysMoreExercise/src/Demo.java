import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNum = 0;
        int secondNum = 0;
        int thirdNum = 0;
        for (int i = 0; i < 3; i++) {
            int n = Integer.parseInt(scanner.nextLine());
            if(n>firstNum){
                thirdNum=secondNum;
                secondNum=firstNum;
                firstNum=n;
            }else if(n>secondNum){
                thirdNum=secondNum;
                secondNum=n;
            }
            else {
                thirdNum=n;
            }
        }
        System.out.printf("%d%n%d%n%d",firstNum,secondNum,thirdNum);
    }
}
