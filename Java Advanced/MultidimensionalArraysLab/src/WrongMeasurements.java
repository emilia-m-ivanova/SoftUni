import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);
        int wrongValue = matrix[scanner.nextInt()][scanner.nextInt()];
        List<int[]> coordinates = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col]==wrongValue){
                    int newValue = getNewValue(matrix,row,col,wrongValue);
                    coordinates.add(new int[]{row,col,newValue});
                }
            }
        }
        for (int[] value : coordinates) {
            matrix[value[0]][value[1]] = value[2];
        }
        for (int[] arr : matrix) {
            for (int i : arr) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    private static int getNewValue(int[][] matrix, int row, int col,int wrongValue) {
        int n = 0;
        if(row>0 && matrix[row-1][col]!=wrongValue){
            n+=matrix[row-1][col];
        }
        if(row<matrix.length-1 && matrix[row+1][col]!=wrongValue){
            n+=matrix[row+1][col];
        }
        if(col>0 && matrix[row][col-1]!=wrongValue){
            n+=matrix[row][col-1];
        }
        if(col<matrix[row].length-1 && matrix[row][col+1]!=wrongValue){
            n+=matrix[row][col+1];
        }
        return n;
    }

    private static int[][] readMatrix(Scanner scanner) {
        int n = Integer.parseInt(scanner.nextLine());
        int [][] matrix = new int[n][];
        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
