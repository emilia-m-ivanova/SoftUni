import java.util.Scanner;

public class EqualSumsEvenOddPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        for (int i = num; i <=num2 ; i++) {
            int even = 0;
            int odd = 0;
            for (int j = 0; j <6 ; j++) {
                char result = String.valueOf(i).charAt(j);
                if(j%2==0){
                    odd+=Integer.parseInt(String.valueOf(result));
                }else{
                    even+=Integer.parseInt(String.valueOf(result));
                }
            }
            if(odd==even){
                System.out.print(i+" ");
            }

        }
    }
}
