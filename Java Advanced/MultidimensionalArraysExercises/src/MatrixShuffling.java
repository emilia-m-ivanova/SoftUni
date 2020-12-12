import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] matrix = readMatrix(scanner);
        String input = scanner.nextLine();
        while (!input.equals("END")){
            String [] command = input.split("\\s+");
            if(isValid(command,matrix)){
                int row1 = Integer.parseInt(command[1]);
                int col1 = Integer.parseInt(command[2]);
                int row2 = Integer.parseInt(command[3]);
                int col2 = Integer.parseInt(command[4]);
                String temp = matrix[row1][col1];
                matrix[row1][col1] = matrix[row2][col2];
                matrix[row2][col2] = temp;
                for (String[] arr : matrix) {
                    for (String element : arr) {
                        System.out.print(element + " ");
                    }
                    System.out.println();
                }

            }else{
                System.out.println("Invalid input!");
            }

            input = scanner.nextLine();
        }
    }

    private static boolean isValid(String[] command, String[][] matrix) {
        if(!command[0].equals("swap")){
            return false;
        }
        if(command.length!=5){
            return false;
        }
        int row1 = Integer.parseInt(command[1]);
        int col1 = Integer.parseInt(command[2]);
        int row2 = Integer.parseInt(command[3]);
        int col2 = Integer.parseInt(command[4]);
        if(row1<0 || row1>matrix.length || row2<0 || row2>matrix.length||
        col1<0 || col1>matrix[0].length || col2<0 || col2>matrix[0].length){
            return false;
        }

        return true;
    }

    private static String[][] readMatrix(Scanner scanner) {
        int n = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray()[0];
        String[][] matrix = new String[n][];
        for (int row = 0; row < n; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
        return matrix;
    }
}
