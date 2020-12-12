import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] rotate = scanner.nextLine().split("[()]");
        int degrees = Integer.parseInt(rotate[1]);
        degrees = degrees%360;
        String input = scanner.nextLine();
        List<String> list = new ArrayList<>();
        int maxLength = 0;
        while (!input.equals("END")){
            list.add(input);
            if(input.length()>maxLength){
                maxLength=input.length();
            }
            input = scanner.nextLine();
        }
        char[][] matrix = new char[list.size()][maxLength];
        fillMatrix(list, matrix);
        switch (degrees){
            case 0:
                printMatrix(matrix);
                break;
            case 90:
                char[][] matrix1 = new char[maxLength][matrix.length];
                rotate90(matrix, matrix1);
                printMatrix(matrix1);
                break;
            case 180:
                char[][] matrix2 = new char[matrix.length][maxLength];
                rotate180(matrix, matrix2);
                printMatrix(matrix2);
                break;
            case 270:
                char[][] matrix3 = new char[maxLength][matrix.length];
                rotate270(matrix, matrix3);
                printMatrix(matrix3);
                break;
        }
    }

    private static void rotate270(char[][] matrix, char[][] matrix3) {
        for (int row = 0; row < matrix3.length; row++) {
            for (int col = 0; col < matrix3[row].length; col++) {
                matrix3[row][col] = matrix[col][matrix[0].length-1-row];
            }
        }
    }

    private static void rotate180(char[][] matrix, char[][] matrix2) {
        for (int row = 0; row < matrix2.length; row++) {
            for (int col = 0; col < matrix2[row].length; col++) {
                matrix2[row][col] = matrix[matrix.length-1-row][matrix[0].length-1-col];
            }
        }
    }

    private static void printMatrix(char[][] matrix1) {
        for (char[] arr : matrix1) {
            for (char c : arr) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static void rotate90(char[][] matrix, char[][] matrix1) {
        for (int row = 0; row < matrix1.length; row++) {
            for (int col = 0; col < matrix1[row].length; col++) {
                matrix1[row][col] = matrix[matrix.length-1-col][row];
            }
        }
    }

    private static void fillMatrix(List<String> list, char[][] matrix) {
        for (int row = 0; row < list.size(); row++) {
            Arrays.fill(matrix[row], ' ');
            for (int col = 0; col < list.get(row).length(); col++) {
                matrix[row][col] = list.get(row).charAt(col);
            }
        }
    }
}
