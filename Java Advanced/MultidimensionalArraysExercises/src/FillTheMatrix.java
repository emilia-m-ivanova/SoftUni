import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        int dimensions = Integer.parseInt(input[0]);
        int[][] matrix = new int[dimensions][dimensions];
        switch (input[1]) {
            case "A":
                matrix = fillMatrixA(dimensions);
                break;
            case "B":
                matrix = fillMatrixB(dimensions);
                break;
        }
        for (int[] arr : matrix) {
            for (int element : arr) {
                System.out.print(element+" ");
            }
            System.out.println();
        }

    }

    private static int[][] fillMatrixA(int dimensions) {
        int[][] matrix = new int[dimensions][dimensions];
        int value = 1;
        for (int col = 0; col < dimensions; col++) {
            for (int row = 0; row < dimensions; row++) {
                matrix[row][col] = value++;
            }
        }
        return matrix;
    }

    private static int[][] fillMatrixB(int dimensions) {
        int[][] matrix = new int[dimensions][dimensions];
        int value = 1;
        for (int col = 0; col < dimensions; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < dimensions; row++) {
                    matrix[row][col] = value++;
                }
            }else{
                for (int row = dimensions-1; row >=0 ; row--) {
                    matrix[row][col] = value++;
                }
            }
        }
        return matrix;
    }
}
