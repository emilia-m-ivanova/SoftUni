import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        switch (input){
            case "int":
                printResult(Integer.parseInt(scanner.nextLine()));
                break;
            case "real":
                printResult(Double.parseDouble(scanner.nextLine()));
                break;
            case "string":
                printResult(scanner.nextLine());
                break;
        }
    }

    private static void printResult(String input) {
        System.out.printf("$%s$",input);
    }

    private static void printResult(double input) {
        System.out.printf("%.2f",input*1.5);
    }

    private static void printResult(int input) {
        System.out.println(input*2);
    }
}
