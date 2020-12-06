import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regEx = "(::|\\*\\*)(?<emoji>[A-Z][a-z]{2,})\\1";
        String text = scanner.nextLine();
        BigInteger threshold = new BigInteger(String.valueOf(1));
        int count = 0;
        List<String> output = new ArrayList<>();
        for (char c : text.toCharArray()){
            if(Character.isDigit(c)){
                threshold = threshold.multiply(new BigInteger(String.valueOf(c)));
            }
        }
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            count++;
            String emoji = matcher.group("emoji");
            BigInteger coolness = new BigInteger(String.valueOf(0));
            for(char c : emoji.toCharArray()){
                coolness = coolness.add(new BigInteger(String.valueOf((int)c)));
            }
            if(coolness.compareTo(threshold) >= 0){
                output.add(matcher.group());
            }
        }
        System.out.println("Cool threshold: "+threshold);
        System.out.println(count+" emojis found in the text. The cool ones are:");
        System.out.println(String.join(System.lineSeparator(),output));
    }
}
