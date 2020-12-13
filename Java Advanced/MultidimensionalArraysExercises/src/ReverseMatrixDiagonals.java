import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<List<Integer>> matrix = readMatrix(scanner);
        printMatrixDiagonals(matrix);
    }

    private static void printMatrixDiagonals(List<List<Integer>> matrix) {
        int row = matrix.size() - 1;
        int col = matrix.get(row).size() - 1;
        while (!matrix.isEmpty()) {
            System.out.print(matrix.get(row).remove(col) + " ");
            if (matrix.get(row).isEmpty()) {
                matrix.remove(row);
            }
            if (row == 0 && col == 0) {
                return;
            }
            if (positionIsValid(row - 1, col + 1, matrix)) {
                row--;
                col++;
            } else {
                row = matrix.size() - 1;
                col = matrix.get(row).size() - 1;
                System.out.println();
            }
        }
    }

    private static boolean positionIsValid(int row, int col, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    private static List<List<Integer>> readMatrix(Scanner scanner) {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<List<Integer>> matrix = new ArrayList<>();
        for (int row = 0; row < n; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < m; col++) {
                matrix.get(row).add(scanner.nextInt());
            }
        }
        return matrix;
    }
}
