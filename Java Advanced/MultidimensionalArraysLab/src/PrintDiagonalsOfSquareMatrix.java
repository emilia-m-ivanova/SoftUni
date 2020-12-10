import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i][i]+" ");
        }
        System.out.println();
        for (int i = matrix.length-1; i >=0; i--) {
            System.out.print(matrix[i][matrix.length-i-1]+" ");
        }
    }

    private static int[][] readMatrix(Scanner scanner) {
        int n = Integer.parseInt(scanner.nextLine());
        int [][] matrix = new int[n][];
        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
