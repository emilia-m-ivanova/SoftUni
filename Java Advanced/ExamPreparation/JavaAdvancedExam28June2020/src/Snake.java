import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] snakePosition = new int[2];
        int[] borrowPositions = new int[4];
        char[][] board = readMatrix(scanner, snakePosition, borrowPositions);
        int row = snakePosition[0];
        int col = snakePosition[1];
        int food = 0;
        while (food < 10 && indexIsInBounds(row, col, board)) {
            String command = scanner.nextLine();
            board[row][col] = '.';
            switch (command) {
                case "up":
                    row--;
                    break;
                case "down":
                    row++;
                    break;
                case "right":
                    col++;
                    break;
                case "left":
                    col--;
                    break;
            }
            if (indexIsInBounds(row, col, board)) {
                char c = moveSnake(row, col, board);
                if (c == '*') {
                    food++;
                } else if (c == 'B') {
                    board[row][col] = '.';
                    if (row == borrowPositions[0] && col == borrowPositions[1]) {
                        row = borrowPositions[2];
                        col = borrowPositions[3];
                    } else {
                        row = borrowPositions[0];
                        col = borrowPositions[1];
                    }
                    board[row][col] = 'S';
                }
            }
        }

        if (food >= 10) {
            System.out.println("You won! You fed the snake.");
        } else {
            System.out.println("Game over!");
        }
        System.out.println("Food eaten: " + food);
        printMatrix(board);

    }

    private static void printMatrix(char[][] board) {
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static char moveSnake(int row, int col, char[][] matrix) {
        char c = matrix[row][col];
        matrix[row][col] = 'S';
        return c;
    }

    private static boolean indexIsInBounds(int row, int col, char[][] matrix) {
        return 0 <= row && row < matrix.length && 0 <= col && col < matrix[row].length;
    }

    private static char[][] readMatrix(Scanner scanner, int[] position, int[] borrow) {
        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];
        int borrowIndex = 0;
        for (int row = 0; row < n; row++) {
            String line = scanner.nextLine();
            for (int col = 0; col < n; col++) {
                matrix[row][col] = line.charAt(col);
                if (line.charAt(col) == 'S') {
                    position[0] = row;
                    position[1] = col;
                } else if (line.charAt(col) == 'B') {
                    borrow[borrowIndex++] = row;
                    borrow[borrowIndex++] = col;
                }
            }
        }
        return matrix;
    }
}
