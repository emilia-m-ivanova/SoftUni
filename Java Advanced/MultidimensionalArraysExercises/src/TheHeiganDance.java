import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double damage = Double.parseDouble(scanner.nextLine());
        double heigan = 3000000;
        int player = 18500;
        int currentRow = 7;
        int currentCol = 7;
        String killedBy = "";
        boolean activeCloud = false;
        while (player > 0 && heigan > 0) {
            boolean[][] matrix = new boolean[15][15];
            if (activeCloud) {
                player -= 3500;
                activeCloud = false;
                if (player <= 0) {
                    killedBy = "Plague Cloud";
                }
            }
            heigan -= damage;
            if (heigan <= 0 || player<=0) {
                break;
            }
            String[] input = scanner.nextLine().split("\\s+");
            String spell = input[0];
            int row = Integer.parseInt(input[1]);
            int col = Integer.parseInt(input[2]);
            for (int r = -1; r <= 1; r++) {
                for (int c = -1; c <= 1; c++) {
                    if (positionIsValid(matrix, row - r, col - c)) {
                        matrix[row - r][col - c] = true;
                    }
                }
            }
            if (matrix[currentRow][currentCol]) {
                if (positionIsValid(matrix, currentRow - 1, currentCol) &&
                        !matrix[currentRow - 1][currentCol]) {
                    currentRow--;
                } else if (positionIsValid(matrix, currentRow, currentCol + 1) &&
                        !matrix[currentRow][currentCol + 1]) {
                    currentCol++;
                } else if (positionIsValid(matrix, currentRow + 1, currentCol) &&
                        !matrix[currentRow + 1][currentCol]) {
                    currentRow++;
                } else if (positionIsValid(matrix, currentRow, currentCol - 1) &&
                        !matrix[currentRow][currentCol - 1]) {
                    currentCol--;
                }
            }
            if (!matrix[currentRow][currentCol]) {
                continue;
            }
            switch (spell) {
                case "Cloud":
                    player -= 3500;
                    activeCloud = true;
                    if (player <= 0) {
                        killedBy = "Plague Cloud";
                    }
                    break;
                case "Eruption":
                    player -= 6000;
                    if (player <= 0) {
                        killedBy = "Eruption";
                    }
                    break;
            }
        }

        printResult(heigan, player, currentRow, currentCol, killedBy);
    }

    private static void printResult(double heigan, int player, int currentRow, int currentCol, String killedBy) {
        if (heigan <= 0) {
            System.out.printf("Heigan: Defeated!%n");
        } else {
            System.out.printf("Heigan: %.2f%n", heigan);
        }
        if (player <= 0) {
            System.out.printf("Player: Killed by %s%n", killedBy);
        } else {
            System.out.printf("Player: %d%n", player);
        }
        System.out.printf("Final position: %d, %d", currentRow, currentCol);
    }

    private static boolean positionIsValid(boolean[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length
                && col >= 0 && col < matrix[row].length;
    }
}
