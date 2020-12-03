import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder output = new StringBuilder(String.valueOf(input.charAt(0)));
        for (int i = 1; i < input.length(); i++) {
            if(input.charAt(i)!=output.charAt(output.length()-1)){
                output.append(input.charAt(i));
            }
        }
        System.out.println(output);
    }
}
