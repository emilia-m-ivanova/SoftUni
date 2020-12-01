import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        long[] previousArray = {1};
        for (int i = 1; i <= n; i++) {
            long [] array = new long[i];
            array[0]=1;
            array[array.length-1]=1;
            for (int j = 1; j < i-1; j++) {
                array[j]=previousArray[j-1]+previousArray[j];
            }
            for (long element:array) {
                System.out.print(element+" ");
            }
            System.out.println();
            previousArray=array;
        }
    }
}
