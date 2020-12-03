import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        for (String string : input) {
            if (3 <= string.length() && string.length() <= 16) {
                boolean print = true;
                for (int i = 0; i < string.length(); i++) {
                    char current = string.charAt(i);
                    if (!Character.isDigit(current)
                            && !Character.isLetter(current)
                            && current != '-'
                            && current != '_') {
                            print = false;
                            break;
                    }
                }
                if(print){
                    System.out.println(string);
                }
            }
        }

    }
}
