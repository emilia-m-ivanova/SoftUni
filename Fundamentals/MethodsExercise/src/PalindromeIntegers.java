import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("END")){
            System.out.println(isPalindrome(input));
            input=scanner.nextLine();
        }
    }

    private static boolean isPalindrome(String input) {
        String inputBackwards = "";
        for (int i = input.length()-1; i >= 0; i--) {
            inputBackwards+=input.charAt(i);
        }
        return input.equals(inputBackwards);
    }
}
