package PointInRectangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Rectangle rectangle = new Rectangle(new Point(scanner.nextInt(), scanner.nextInt()),
                new Point(scanner.nextInt(), scanner.nextInt()));
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            Point point = new Point(scanner.nextInt(), scanner.nextInt());
            System.out.println(pointIsInFigure(point, rectangle));
        }
    }

    private static boolean pointIsInFigure(Point point, Rectangle rectangle) {
        return point.getX() <= rectangle.getTopRight().getX() && point.getY() <= rectangle.getTopRight().getY() &&
                point.getX() >= rectangle.getBottomLeft().getX() && point.getY() >= rectangle.getBottomLeft().getY();
    }
}
