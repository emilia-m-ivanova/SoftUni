import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        printTop(1,n);
        printBottom(n-1,n);
    }

    private static void printBottom(int i, int n) {
        if(i==0){
            return;
        }
        printChar(" ",n-i);
        printChar("* ",i);
        System.out.println();
        printBottom(i-1,n);
    }

    private static void printTop(int i, int n) {
        if(i>n){
            return;
        }
        printChar(" ",n-i);
        printChar("* ",i);
        System.out.println();
        printTop(i+1,n);
    }

    private static void printChar(String string,int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(string);
        }
    }
}
