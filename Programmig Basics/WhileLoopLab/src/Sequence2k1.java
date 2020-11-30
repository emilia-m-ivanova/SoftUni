import java.util.Scanner;

public class Sequence2k1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        int result = 1;
        while (num>=result){
            System.out.println(result);
            result=result*2+1;
        }
    }
}
