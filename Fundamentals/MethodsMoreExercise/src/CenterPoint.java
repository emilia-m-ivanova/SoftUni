import java.util.Scanner;

public class CenterPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = Integer.parseInt(scanner.nextLine());
        int y1 = Integer.parseInt(scanner.nextLine());
        int x2 = Integer.parseInt(scanner.nextLine());
        int y2 = Integer.parseInt(scanner.nextLine());
        printClosestToCenterPoint(x1,y1,x2,y2);
    }

    private static void printClosestToCenterPoint(int x1, int y1, int x2, int y2) {
        if(Math.abs(x1)+Math.abs(y1)<=Math.abs(x2)+Math.abs(y2)){
            System.out.println("("+x1+", "+y1+")");
        }else{
            System.out.println("("+x2+", "+y2+")");
        }
    }
}
