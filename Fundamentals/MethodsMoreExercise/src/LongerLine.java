import java.util.Scanner;

public class LongerLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1First = Integer.parseInt(scanner.nextLine());
        int y1First = Integer.parseInt(scanner.nextLine());
        int x2First = Integer.parseInt(scanner.nextLine());
        int y2First = Integer.parseInt(scanner.nextLine());

        int x1Second = Integer.parseInt(scanner.nextLine());
        int y1Second = Integer.parseInt(scanner.nextLine());
        int x2Second = Integer.parseInt(scanner.nextLine());
        int y2Second = Integer.parseInt(scanner.nextLine());

        if (lineLength(x1First, y1First, x2First, y2First) >=
                lineLength(x1Second, y1Second, x2Second, y2Second)) {
            printClosestToCenterPoint(x1First, y1First, x2First, y2First);
        } else
            printClosestToCenterPoint(x1Second, y1Second, x2Second, y2Second);

    }

    private static double lineLength(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    private static void printClosestToCenterPoint(int x1, int y1, int x2, int y2) {
        if (Math.sqrt(x1 * x1 + y1 * y1) <= Math.sqrt(x2 * x2 + y2 * y2)) {
            System.out.println("(" + x1 + ", " + y1 + ")(" + x2 + ", " + y2 + ")");
        } else {
            System.out.println("(" + x2 + ", " + y2 + ")(" + x1 + ", " + y1 + ")");
        }
    }
}
