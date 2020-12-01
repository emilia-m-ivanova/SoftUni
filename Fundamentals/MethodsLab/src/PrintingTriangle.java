import java.util.Scanner;

public class PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printTriangle(Integer.parseInt(scanner.nextLine()));
    }

    private static void printLine(int end) {
        for (int i = 1; i <=end; i++) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
    private static void printTriangle(int maxNum){
        for (int i = 1; i <maxNum; i++) {
            printLine(i);
        }
        for (int i = maxNum; i >=1; i--) {
            printLine(i);
        }
    }
}
