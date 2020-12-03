import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while(!input.equals("end")){
            char[] array = new char [input.length()];
            for (int i = input.length()-1; i >=0; i--) {
                array[input.length()-1-i] = input.charAt(i);
            }
            String output = new String(array);
            System.out.println(input+" = "+output);
            input = scanner.nextLine();
        }
    }
}
