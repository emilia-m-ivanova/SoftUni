import java.util.Scanner;

public class Selling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] pillars = new int[4];
        char[][] matrix = readMatrix(scanner, pillars);
        int sum = 0;
        while (sum < 50) {
            matrix[positionRow][positionCol] = '-';
            changePosition(scanner.nextLine());
            if (!indexIsInBounds(positionRow, positionCol, matrix)) {
                System.out.printf("Bad news, you are out of the bakery.%nMoney: %d%n",sum);
                break;
            }
            char c = movePosition(positionRow, positionCol, matrix);
            if (c == 'O') {
                matrix[positionRow][positionCol] = '-';
                if(positionRow == pillars[0] && positionCol == pillars[1]){
                    positionRow = pillars[2];
                    positionCol = pillars[3];
                }else{
                    positionRow = pillars[0];
                    positionCol = pillars[1];
                }
                movePosition(positionRow, positionCol, matrix);
            }else if(Character.isDigit(c)){
                sum+=Integer.parseInt(String.valueOf(c));
            }
        }

        if(sum>=50){
            System.out.printf("Good news! You succeeded in collecting enough money!%nMoney: %d%n",sum);
        }
        printMatrix(matrix);
    }

    private static int positionRow;

    private static int positionCol;

    private static void changePosition(String command) {

        switch (command) {
            case "up":
                positionRow--;
                break;
            case "down":
                positionRow++;
                break;
            case "left":
                positionCol--;
                break;
            case "right":
                positionCol++;
                break;
        }
    }


    private static void printMatrix(char[][] board) {
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static char movePosition(int row, int col, char[][] matrix) {
        char c = matrix[row][col];
        matrix[row][col] = 'S';
        return c;
    }

    private static boolean indexIsInBounds(int row, int col, char[][] matrix) {
        return 0 <= row && row < matrix.length && 0 <= col && col < matrix[row].length;
    }

    private static char[][] readMatrix(Scanner scanner, int[] pillars) {
        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];
        int pillarIndex = 0;
        for (int row = 0; row < n; row++) {
            String line = scanner.nextLine();
            for (int col = 0; col < n; col++) {
                matrix[row][col] = line.charAt(col);
                if (line.charAt(col) == 'S') {
                    positionRow = row;
                    positionCol = col;
                } else if (line.charAt(col) == 'O') {
                    pillars[pillarIndex++] = row;
                    pillars[pillarIndex++] = col;
                }
            }
        }
        return matrix;
    }
}
