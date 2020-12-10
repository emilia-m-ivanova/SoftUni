import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());
        char[][] firstMatrix = readMatrix(scanner,rows,cols);
        char[][] secondMatrix = readMatrix(scanner,rows,cols);
        System.out.println();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char first = firstMatrix[row][col];
                char second = secondMatrix[row][col];
                System.out.print((first==second?first:'*')+" ");
            }
            System.out.println();
        }

    }
    private static char[][] readMatrix(Scanner scanner, int rows, int cols) {
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            String [] array = scanner.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = array[col].charAt(0);
            }
        }
        return matrix;
    }
}
