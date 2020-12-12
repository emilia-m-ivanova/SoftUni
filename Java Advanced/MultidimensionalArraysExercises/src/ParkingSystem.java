import java.util.Arrays;
import java.util.Scanner;

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        boolean[][] matrix = new boolean[dimensions[0]][dimensions[1]];
        String input = scanner.nextLine();
        while (!input.equals("stop")) {
            String[] coordinates = input.split(" ");
            int entryRow = Integer.parseInt(coordinates[0]);
            int row = Integer.parseInt(coordinates[1]);
            int col = Integer.parseInt(coordinates[2]);
            boolean found = false;
            int i = 0;
            while (isValid(matrix, col - i) || isValid(matrix, col + i)) {
                if (isValid(matrix, col - i) && !matrix[row][col - i]) {
                    matrix[row][col - i] = true;
                    System.out.println((col + 1 - i) + Math.abs(row - entryRow));
                    found = true;
                    break;
                }
                if (isValid(matrix, col + i) && !matrix[row][col + i]) {
                    matrix[row][col + i] = true;
                    System.out.println((col + 1 + i) + Math.abs(row - entryRow));
                    found = true;
                    break;
                }
                i++;
            }
            if (!found) {
                System.out.printf("Row %d full%n", row);
            }
            input = scanner.nextLine();
        }
    }

    private static boolean isValid(boolean[][] matrix, int col) {
        return col > 0 && col < matrix[0].length;
    }
}
