import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostOffice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\|");
        String regEx1 = "([#$%*&])([A-Z]+)\\1";
        String regEx2 = "(\\d\\d):(\\d\\d)";

        //first part
        Pattern pattern = Pattern.compile(regEx1);
        Matcher matcher = pattern.matcher(input[0]);
        matcher.find();
        char[] letters = matcher.group(2).toCharArray();
        List<Character> chars = new ArrayList<>();
        for (char c : letters) {
            chars.add(c);
        }

        //second part
        pattern = Pattern.compile(regEx2);
        matcher = pattern.matcher(input[1]);
        List<String> validRegEx = new ArrayList<>();
        while (matcher.find()) {
            int asciiCode = Integer.parseInt(matcher.group(1));
            int count = Integer.parseInt(matcher.group(2));
            if (chars.contains((char) asciiCode)) {
                String regEx = "( |^)"+"(?<word>"+(char) asciiCode + "[^\\s]" + "{" + count + "}"+")"+"( |$)";
                if (!validRegEx.contains(regEx)){
                    validRegEx.add(regEx);
                }
            }
        }

        //third part
        List<String> output = new ArrayList<>();
        for (String regEx : validRegEx) {
            pattern = Pattern.compile(regEx);
            matcher = pattern.matcher(input[2]);
            if (matcher.find()) {
                output.add(matcher.group("word"));
            }
        }
        for (Character letter : chars) {
            for (String string : output) {
                if(string.charAt(0)==letter){
                    System.out.println(string);
                }
            }
        }
    }
}
