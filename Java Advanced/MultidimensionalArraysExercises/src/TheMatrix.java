
import java.util.Arrays;
import java.util.Scanner;

public class TheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] matrix = readMatrix(scanner);
        char fillChar = scanner.nextLine().charAt(0);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int startRow = dimensions[0];
        int startCol = dimensions[1];
        char currentChar = matrix[startRow][startCol];
        replaceChars(matrix, currentChar, fillChar, startRow, startCol);
        for (char[] arr : matrix) {
            for (char c : arr) {
                System.out.print(c);
            }
            System.out.println();
        }

    }

    private static void replaceChars(char[][] matrix, char currentChar, char fillChar, int startRow, int startCol) {
        if (!positionIsValid(matrix, startRow, startCol) || matrix[startRow][startCol] != currentChar) {
            return;
        }
        matrix[startRow][startCol] = fillChar;
        replaceChars(matrix, currentChar,fillChar, startRow - 1, startCol);
        replaceChars(matrix, currentChar, fillChar, startRow, startCol + 1);
        replaceChars(matrix, currentChar, fillChar, startRow + 1, startCol);
        replaceChars(matrix, currentChar, fillChar, startRow, startCol - 1);

    }

    private static boolean positionIsValid(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length
                && col >= 0 && col < matrix[row].length;
    }

    private static char[][] readMatrix(Scanner scanner) {
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int row = dimensions[0];
        int col = dimensions[1];
        char[][] matrix = new char[row][col];
        for (int r = 0; r < row; r++) {
            String[] arr = scanner.nextLine().split("\\s+");
            for (int c = 0; c < col; c++) {
                matrix[r][c] = arr[c].charAt(0);
            }
        }
        return matrix;
    }
}
