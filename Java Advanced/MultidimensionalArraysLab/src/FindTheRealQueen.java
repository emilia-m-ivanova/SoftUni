import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] matrix = readMatrix(scanner,8,8);
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char current = matrix[row][col];
                if(current=='q'){
                    if(isValid(matrix,row,col)){
                        System.out.println(row+" "+col);
                        return;
                    }
                }
            }
        }

    }

    private static boolean isValid(char[][] matrix, int row, int col) {
        for (int c = 0; c < matrix[row].length; c++) { //check row
            if(matrix[row][c]=='q'&&c!=col){
                return false;
            }
        }
        for (int r = 0; r < matrix.length; r++) { //check column
            if(matrix[r][col]=='q'&&r!=row){
                return false;
            }
        }
        int r = row;
        int c = col;
        while (r>0&&c>0){ //check upper left diagonal
            r--;
            c--;
            if(matrix[r][c]=='q'){
                return false;
            }
        }
        r = row;
        c = col;
        while (r<matrix.length-1 && c<matrix[row].length-1){ //check lower right diagonal
            r++;
            c++;
            if(matrix[r][c]=='q'){
                return false;
            }
        }
        r = row;
        c = col;
        while (r>0 && c<matrix[row].length-1){ //check upper right diagonal
            r--;
            c++;
            if(matrix[r][c]=='q'){
                return false;
            }
        }
        r = row;
        c = col;
        while (r<matrix.length-1 && c>0){ //check lower left diagonal
            r++;
            c--;
            if(matrix[r][c]=='q'){
                return false;
            }
        }

        return true;
    }

    private static char[][] readMatrix(Scanner scanner, int rows, int cols) {
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] array = scanner.nextLine().toLowerCase().split(" ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = array[col].charAt(0);
            }
        }
        return matrix;
    }
}
