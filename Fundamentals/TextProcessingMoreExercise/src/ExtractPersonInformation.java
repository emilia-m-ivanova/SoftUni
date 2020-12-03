import java.util.Scanner;

public class ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            int nameStartIndex = 0;
            int nameEndIndex = 0;
            int ageStartIndex = 0;
            int ageEndIndex = 0;
            for (int c = 0; c < input.length(); c++) {
                char character = input.charAt(c);
                if (character == '@') {
                    nameStartIndex = c+1;
                }else if(character == '|'){
                    nameEndIndex = c;
                }else if(character=='#'){
                    ageStartIndex = c+1;
                }else if(character=='*'){
                    ageEndIndex = c;
                }
            }
            System.out.printf("%s is %s years old.%n", input.substring(nameStartIndex,nameEndIndex),
                    input.substring(ageStartIndex,ageEndIndex));

        }
    }
}
