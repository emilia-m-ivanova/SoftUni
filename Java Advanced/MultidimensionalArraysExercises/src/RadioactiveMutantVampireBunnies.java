import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RadioactiveMutantVampireBunnies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] playerPosition = new int[2];
        char[][] matrix = readMatrix(scanner, playerPosition);
        String commands = scanner.nextLine();
        boolean[] playerWinsOrDies = new boolean[2];
        String output = "";
        for (char command : commands.toCharArray()) {
            movePlayer(command, matrix, playerPosition, playerWinsOrDies);
            multiplyBunnies(matrix, playerWinsOrDies);
            if (playerWinsOrDies[0]) {
                output = "won: " + playerPosition[0] + " " + playerPosition[1];
                break;
            } else if (playerWinsOrDies[1]) {
                output = "dead: " + playerPosition[0] + " " + playerPosition[1];
                break;
            }
        }
        for (char[] arr : matrix) {
            for (char c : arr) {
                System.out.print(c);
            }
            System.out.println();
        }
        System.out.println(output);
    }

    private static void multiplyBunnies(char[][] matrix, boolean[] playerWinsOrDies) {
        List<List<Integer>> positions = new ArrayList<>();
        for (int row = 0; row <matrix.length ; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col]=='B'){
                    int finalRow = row;
                    int finalCol = col;
                    positions.add(new ArrayList<>(){{add(finalRow);add(finalCol);}});
                }
            }
        }
        for (List<Integer> position : positions) {
            int row = position.get(0);
            int col = position.get(1);
            if(positionIsValid(row-1,col,matrix)){
                if(matrix[row-1][col]=='P'){
                    playerWinsOrDies[1] = true;
                }
                matrix[row-1][col]='B';
            }
            if(positionIsValid(row+1,col,matrix)){
                if(matrix[row+1][col]=='P'){
                    playerWinsOrDies[1] = true;
                }
                matrix[row+1][col]='B';
            }
            if(positionIsValid(row,col-1,matrix)){
                if(matrix[row][col-1]=='P'){
                    playerWinsOrDies[1] = true;
                }
                matrix[row][col-1]='B';
            }
            if(positionIsValid(row,col+1,matrix)){
                if(matrix[row][col+1]=='P'){
                    playerWinsOrDies[1] = true;
                }
                matrix[row][col+1]='B';
            }
        }

    }

    private static void movePlayer(char command, char[][] matrix, int[] playerPosition, boolean[] winsOrDies) {
        int row = playerPosition[0];
        int col = playerPosition[1];
        switch (command) {
            case 'L':
                col--;
                break;
            case 'R':
                col++;
                break;
            case 'U':
                row--;
                break;
            case 'D':
                row++;
                break;
        }
        if (positionIsValid(row, col, matrix)) {
            char charAtPosition = matrix[row][col];
            if (charAtPosition == 'B') {
                winsOrDies[1] = true;
            } else {
                matrix[playerPosition[0]][playerPosition[1]] = '.';
                matrix[row][col] = 'P';
            }
            playerPosition[0] = row;
            playerPosition[1] = col;
        } else {
            winsOrDies[0] = true;
            matrix[playerPosition[0]][playerPosition[1]] = '.';
        }
    }

    private static boolean positionIsValid(int row, int col, char[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static char[][] readMatrix(Scanner scanner, int[] playerPosition) {
        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = dimensions[0];
        int m = dimensions[1];
        char[][] matrix = new char[n][m];
        for (int row = 0; row < n; row++) {
            String input = scanner.nextLine();
            for (int col = 0; col < m; col++) {
                matrix[row][col] = input.charAt(col);
                if (input.charAt(col) == 'P') {
                    playerPosition[0] = row;
                    playerPosition[1] = col;
                }
            }
        }
        return matrix;
    }
}