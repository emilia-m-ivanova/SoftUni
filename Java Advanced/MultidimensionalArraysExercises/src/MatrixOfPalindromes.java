import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        String [][] matrix = palindromeMatrix(row,col);
        for (String[] arr : matrix) {
            for (String element : arr) {
                System.out.print(element+" ");
            }
            System.out.println();
        }

    }

    private static String[][] palindromeMatrix(int row, int col) {
        String[][] matrix = new String[row][col];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                char firstAndLast = (char)(r+97);
                char middle = (char)(r+c+97);
                String element = String.valueOf(firstAndLast) + middle + firstAndLast;
                matrix[r][c] = element;
            }
        }
        return matrix;
    }
}
