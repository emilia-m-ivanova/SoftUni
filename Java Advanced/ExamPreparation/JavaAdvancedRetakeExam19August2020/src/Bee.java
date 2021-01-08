import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> beePosition = new ArrayList<>();
        char[][] territory = readMatrix(scanner, beePosition);
        String input = scanner.nextLine();
        int flowersPollinated = 0;
        while (!input.equals("End")) {
            int row = beePosition.get(0);
            int col = beePosition.get(1);
            territory[row][col] = '.';
            switch (input) {
                case "up":
                    row--;
                    if(indexIsInBounds(row,col,territory)){
                        char c = moveBee(row,col,beePosition,territory);
                        if(c=='f'){
                            flowersPollinated++;
                        }else if(c=='O'){
                            territory[row][col] = '.';
                           if (moveBee(row-1,col,beePosition,territory)=='f'){
                               flowersPollinated++;
                           }
                        }
                    }
                    break;
                case "down":
                    row++;
                    if(indexIsInBounds(row,col,territory)){
                        char c = moveBee(row,col,beePosition,territory);
                        if(c=='f'){
                            flowersPollinated++;
                        }else if(c=='O'){
                            territory[row][col] = '.';
                            if (moveBee(row+1,col,beePosition,territory)=='f'){
                                flowersPollinated++;
                            }
                        }
                    }
                    break;
                case "right":
                    col++;
                    if(indexIsInBounds(row,col,territory)){
                        char c = moveBee(row,col,beePosition,territory);
                        if(c=='f'){
                            flowersPollinated++;
                        }else if(c=='O'){
                            territory[row][col] = '.';
                            if (moveBee(row,col+1,beePosition,territory)=='f'){
                                flowersPollinated++;
                            }
                        }
                    }
                    break;
                case "left":
                    col--;
                    if(indexIsInBounds(row,col,territory)){
                        char c = moveBee(row,col,beePosition,territory);
                        if(c=='f'){
                            flowersPollinated++;
                        }else if(c=='O'){
                            territory[row][col] = '.';
                            if (moveBee(row,col-1,beePosition,territory)=='f'){
                                flowersPollinated++;
                            }
                        }
                    }
                    break;
            }
            if(!indexIsInBounds(row,col,territory)){
                System.out.println("The bee got lost!");
                break;
            }
            input = scanner.nextLine();
        }
        if(flowersPollinated>=5){
            System.out.println("Great job, the bee manage to pollinate " + flowersPollinated + " flowers!");
        }else{
            System.out.println("The bee couldn't pollinate the flowers, she needed "
                    + (5-flowersPollinated) + " flowers more");
        }

        printMatrix(territory);
    }

    private static void printMatrix(char[][] territory) {
        for (char[] chars : territory) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    private static char moveBee(int row, int col, List<Integer> beePosition, char[][] territory) {
        beePosition.set(0,row);
        beePosition.set(1,col);
        char currentChar = territory[row][col];
        territory[row][col] = 'B';
        return currentChar;
    }

    private static boolean indexIsInBounds(int row, int col, char[][] matrix) {
        return 0 <= row && row < matrix.length && 0 <= col && col < matrix[row].length;
    }

    private static char[][] readMatrix(Scanner scanner, List<Integer> beePosition) {
        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];
        for (int row = 0; row < n; row++) {
            String string = scanner.nextLine();
            for (int col = 0; col < n; col++) {
                matrix[row][col] = string.charAt(col);
                if (string.charAt(col) == 'B') {
                    beePosition.add(row);
                    beePosition.add(col);
                }
            }
        }
        return matrix;
    }
}