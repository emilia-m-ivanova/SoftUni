import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SantasSecretHelper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int key = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        String regEx = "@(?<name>[A-Za-z]+)([^@\\-!:>]*)!(?<type>[GN])!";
        Pattern pattern = Pattern.compile(regEx);
        while(!input.equals("end")){
            StringBuilder decrypted = new StringBuilder();
            for (char c : input.toCharArray()) {
                decrypted.append((char)(c-key));
            }
            Matcher matcher = pattern.matcher(decrypted);
            if(matcher.find()&&matcher.group("type").equals("G")){
                System.out.println(matcher.group("name"));
            }
            input = scanner.nextLine();
        }

    }
}
