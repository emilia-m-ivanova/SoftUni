import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] firstMatrix = readMatrix(scanner);
        int[][] secondMatrix = readMatrix(scanner);
        boolean areEqual = compareMatrices(firstMatrix,secondMatrix);
        System.out.println(areEqual? "equal" : "not equal");
    }

    private static boolean compareMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        if(firstMatrix.length!=secondMatrix.length){
            return false;
        }

        for (int row = 0; row < firstMatrix.length; row++) {
            if(firstMatrix[row].length!=secondMatrix[row].length){
                return false;
            }
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if(firstMatrix[row][col]!=secondMatrix[row][col]){
                    return false;
                }
            }
        }

        return true;
    }

    private static int [][] readMatrix(Scanner scanner) {
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int [][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix [row][col] = scanner.nextInt();
            }
        }
        return matrix;
    }
}
