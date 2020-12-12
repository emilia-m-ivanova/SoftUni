import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<List<Integer>> matrix = fillMatrix(scanner);
        String command = scanner.nextLine();
        while (!command.equals("Nuke it from orbit")) {
            String[] tokens = command.split("\\s+");
            int row = Integer.parseInt(tokens[0]);
            int col = Integer.parseInt(tokens[1]);
            int radius = Integer.parseInt(tokens[2]);
            removeElements(row, col, radius, matrix);
            command = scanner.nextLine();
        }
        for (List<Integer> arr : matrix) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static void removeElements(int row, int col, int radius, List<List<Integer>> matrix) {
        for (int c = col +radius; c >= col - radius; c--) {
            if (row >= 0 && row < matrix.size()&&
                    c >= 0 && c < matrix.get(row).size()) {
                matrix.get(row).remove(c);
            }
        }

        for (int r = row - radius; r <= row + radius; r++) {
            if (r >= 0 && r < matrix.size()&&
                    col >= 0 && col < matrix.get(r).size() && r != row) {
                matrix.get(r).remove(col);
            }
        }
        matrix.removeIf(List::isEmpty);
    }

    private static List<List<Integer>> fillMatrix(Scanner scanner) {
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int r = dimensions[0];
        int c = dimensions[1];
        List<List<Integer>> matrix = new ArrayList<>();
        int value = 1;
        for (int row = 0; row < r; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < c; col++) {
                matrix.get(row).add(value);
                value++;
            }
        }
        return matrix;
    }
}
