import java.util.Scanner;

public class PrintPartOfASCIITable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstChar = Integer.parseInt(scanner.nextLine());
        int secondChar = Integer.parseInt(scanner.nextLine());
        String output = "";
        for (int i = firstChar; i <=secondChar ; i++) {
            char asciiChar = (char)i;
            output+=asciiChar+" ";
        }
        System.out.println(output);
    }
}
