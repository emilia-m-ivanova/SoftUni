import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regEx = "(\\D+)(\\d+)";
        String input = scanner.nextLine().toUpperCase();
        StringBuilder output = new StringBuilder();
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()){
            int repeat = Integer.parseInt(matcher.group(2));
            for (int i = 0; i < repeat; i++) {
                output.append(matcher.group(1));
            }
        }
        List<Character> chars = new ArrayList<>();
        for (Character c : output.toString().toCharArray()) {
            if(!chars.contains(c)){
                chars.add(c);
            }
        }
        System.out.printf("Unique symbols used: %d%n",chars.size());
        System.out.println(output);
    }
}
