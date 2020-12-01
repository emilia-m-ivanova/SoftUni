import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<Character, Integer> characters = new LinkedHashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar != ' ') {
                if (!characters.containsKey(currentChar)) {
                    characters.put(currentChar, 0);
                }
                characters.put(currentChar, characters.get(currentChar) + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : characters.entrySet()) {
            System.out.println(entry.getKey()+" -> "+entry.getValue());
        }
    }
}
