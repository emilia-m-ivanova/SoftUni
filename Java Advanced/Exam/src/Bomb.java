import java.util.Scanner;

public class Bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");
        char[][] matrix = readMatrix(size, scanner);
        for (String command : commands) {
            matrix[positionRow][positionCol] = '+';
            changePosition(command, matrix);
            char c = movePosition(positionRow, positionCol, matrix);
            if (c == 'B') {
                bombs--;
                System.out.println("You found a bomb!");
            } else if (c == 'e') {
                System.out.printf(bombs == 0 ? "Congratulations! You found all bombs!" : "END! %d bombs left on the field", bombs);
                return;
            }
        }
        System.out.printf(bombs == 0 ? "Congratulations! You found all bombs!" :
                "%d bombs left on the field. Sapper position: (%d,%d)", bombs, positionRow, positionCol);
    }

    private static int positionRow;

    private static int positionCol;

    private static int bombs = 0;

    private static void changePosition(String command, char[][] matrix) {

        switch (command) {
            case "up":
                if (indexIsInBounds(positionRow - 1, positionCol, matrix)) {
                    positionRow--;
                }
                break;
            case "down":
                if (indexIsInBounds(positionRow + 1, positionCol, matrix)) {
                    positionRow++;
                }
                break;
            case "left":
                if (indexIsInBounds(positionRow, positionCol - 1, matrix)) {
                    positionCol--;
                }
                break;
            case "right":
                if (indexIsInBounds(positionRow, positionCol + 1, matrix)) {
                    positionCol++;
                }
                break;
        }

    }

    private static char movePosition(int row, int col, char[][] matrix) {
        char c = matrix[row][col];
        matrix[row][col] = 's';
        return c;
    }

    private static boolean indexIsInBounds(int row, int col, char[][] matrix) {
        return 0 <= row && row < matrix.length && 0 <= col && col < matrix[row].length;
    }

    private static char[][] readMatrix(int n, Scanner scanner) {
        char[][] matrix = new char[n][n];
        for (int row = 0; row < n; row++) {
            String[] line = scanner.nextLine().split("\\s+");
            for (int col = 0; col < n; col++) {
                matrix[row][col] = line[col].charAt(0);
                if (line[col].charAt(0) == 's') {
                    positionRow = row;
                    positionCol = col;
                } else if (line[col].charAt(0) == 'B') {
                    bombs++;
                }
            }
        }
        return matrix;
    }
}
