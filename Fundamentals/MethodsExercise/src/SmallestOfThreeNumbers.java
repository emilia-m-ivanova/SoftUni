import java.util.Scanner;

public class SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        int n3 = Integer.parseInt(scanner.nextLine());
        System.out.println(getMinInteger(n1,n2,n3));
    }

    private static int getMinInteger(int n1, int n2, int n3) {
        if(Math.min(n1,n2)<n3){
            return Math.min(n1,n2);
        }
        return n3;
    }
}
