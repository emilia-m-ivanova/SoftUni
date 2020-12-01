import java.util.Scanner;

public class SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = Integer.parseInt(scanner.nextLine());
        int firstNum = n1;
        int secondNum = n1;
        int thirdNum = n1;
        for (int i = 0; i < 3; i++) {
            if (n1<firstNum&&n1>thirdNum){
                secondNum=n1;
            } else if(n1>firstNum){
                secondNum=firstNum;
                firstNum=n1;
            }else if(n1<thirdNum){
                secondNum=thirdNum;
                thirdNum=n1;
            }
            if(i==2){
                break;
            }
            n1 = Integer.parseInt(scanner.nextLine());

        }


        System.out.printf("%d%n%d%n%d",firstNum,secondNum,thirdNum);
    }
}
