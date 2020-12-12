import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);
        int sumFirst = sumPrimaryDiagonal(matrix);
        int sumSecond = sumSecondaryDiagonal(matrix);
        System.out.println(Math.abs(sumFirst-sumSecond));

    }

    private static int sumSecondaryDiagonal(int[][] matrix) {
        int sum = 0;
        int row = 0;
        int col = matrix.length-1;
        while (row<matrix.length){
            sum+=matrix[row++][col--];
        }
        return sum;
    }

    private static int sumPrimaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum+=matrix[i][i];
        }
        return sum;
    }

    private static int[][] readMatrix(Scanner scanner) {
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
        return matrix;
    }
}
