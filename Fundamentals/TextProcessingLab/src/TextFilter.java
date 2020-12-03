import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] banList = scanner.nextLine().split(", ");
        String text = scanner.nextLine();
        for (String current : banList) {
            String replacement = "*";
            for (int i = 0; i < current.length()-1; i++) {
                replacement = replacement.concat("*");
            }
            while (text.contains(current)) {
                text = text.replace(current, replacement);
            }
        }
        System.out.println(text);
    }
}
