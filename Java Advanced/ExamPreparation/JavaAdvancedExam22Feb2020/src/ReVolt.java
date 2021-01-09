import java.util.Scanner;

public class ReVolt {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int dimensions = Integer.parseInt(scanner.nextLine());
        int nCommands = Integer.parseInt(scanner.nextLine());
        char[][] matrix = readMatrix(scanner, dimensions);

        for (int i = 0; i < nCommands; i++) {

            String command = scanner.nextLine();
            int oldRow = positionRow;
            int oldCol = positionCol;
            matrix[oldRow][oldCol] = '-';
            char newPosition = changePosition(command, matrix);
            if (newPosition == 'B') {
                newPosition = changePosition(command, matrix);
            }
            if (newPosition == 'T') {
                positionRow = oldRow;
                positionCol = oldCol;
                newPosition = matrix[positionRow][positionCol];
            }

            matrix[positionRow][positionCol] = 'f';

            if (newPosition == 'F') {
                System.out.println("Player won!");
                printMatrix(matrix);
                return;
            }
        }

        System.out.println("Player lost!");
        printMatrix(matrix);
    }

    private static int positionRow;

    private static int positionCol;

    private static char changePosition(String command, char[][] matrix) {

        switch (command) {
            case "up":
                if (--positionRow < 0) {
                    positionRow = matrix.length - 1;
                }
                break;
            case "down":
                if (++positionRow >= matrix.length) {
                    positionRow = 0;
                }
                break;
            case "right":
                if (++positionCol >= matrix.length) {
                    positionCol = 0;
                }
                break;
            case "left":
                if (--positionCol < 0) {
                    positionCol = matrix.length - 1;
                }
                break;
        }
        return matrix[positionRow][positionCol];
    }

    private static void printMatrix(char[][] board) {
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static char[][] readMatrix(Scanner scanner, int n) {
        char[][] matrix = new char[n][n];
        for (int row = 0; row < n; row++) {
            String line = scanner.nextLine();
            for (int col = 0; col < n; col++) {
                matrix[row][col] = line.charAt(col);
                if (line.charAt(col) == 'f') {
                    positionRow = row;
                    positionCol = col;
                }
            }
        }
        return matrix;
    }
}