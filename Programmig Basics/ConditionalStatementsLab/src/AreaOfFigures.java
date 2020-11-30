import java.util.Scanner;

public class AreaOfFigures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String figure = scanner.nextLine();
        String square = "square";
        String rectangle = "rectangle";
        String circle = "circle";
        String triangle = "triangle";
        if(figure.equals(square)){
            double side = Double.parseDouble(scanner.nextLine());
            System.out.printf("%.3f",side*side);
        }
        else if(figure.equals(rectangle)){
            double sideA = Double.parseDouble(scanner.nextLine());
            double sideB = Double.parseDouble(scanner.nextLine());
            System.out.printf("%.3f",sideA*sideB);
        }
        else if(figure.equals(circle)){
            double radius = Double.parseDouble(scanner.nextLine());
            System.out.printf("%.3f", radius*radius*Math.PI);
        }
        else if(figure.equals(triangle)){
            double sideA = Double.parseDouble(scanner.nextLine());
            double height = Double.parseDouble(scanner.nextLine());
            System.out.printf("%.3f",sideA*height/2);
        }
    }
}
