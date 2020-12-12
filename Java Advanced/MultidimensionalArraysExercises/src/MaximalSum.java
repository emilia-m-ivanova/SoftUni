import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);
        int bestSum = Integer.MIN_VALUE;
        int[][] bestMatrix = new int[3][3];
        for (int row = 0; row < matrix.length-2; row++) {
            for (int col = 0; col < matrix[row].length-2; col++) {
                int sum = 0;
                for (int r = 0; r < 3; r++) {
                    for (int c = 0; c < 3; c++) {
                        sum += matrix[row+r][col+c];
                    }
                }
                if(sum>bestSum){
                    bestSum = sum;
                    for (int r = 0; r < 3; r++) {
                        System.arraycopy(matrix[row + r], col, bestMatrix[r], 0, 3);
                    }
                }
            }
        }
        System.out.println("Sum = " + bestSum);
        for (int[] arr : bestMatrix) {
            for (int element : arr) {
                System.out.print(element+" ");
            }
            System.out.println();
        }
    }

    private static int[][] readMatrix(Scanner scanner) {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = new int[n][m];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
        return matrix;
    }
}
