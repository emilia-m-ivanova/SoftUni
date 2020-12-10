import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] dimensions = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();
        int[][] matrix = readMatrix(scanner,dimensions[0],dimensions[1]);
        int maxSum = Integer.MIN_VALUE;
        int[][] bestMatrix = new int[2][2];
        for (int row = 0; row < matrix.length-1; row++) {
            for (int col = 0; col < matrix[row].length-1; col++) {
                int sum = matrix[row][col] + matrix[row][col+1] +
                        matrix [row+1][col] + matrix[row+1][col+1];
                if(sum>maxSum){
                    maxSum=sum;
                    bestMatrix[0][0] = matrix[row][col];
                    bestMatrix[0][1] = matrix[row][col+1];
                    bestMatrix[1][0] = matrix[row+1][col];
                    bestMatrix[1][1] = matrix[row+1][col+1];

                }
            }
        }
        for (int[] arr : bestMatrix) {
            for (int element : arr) {
                System.out.print(element+" ");
            }
            System.out.println();
        }

        System.out.println(maxSum);

    }

    private static int[][] readMatrix(Scanner scanner, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
