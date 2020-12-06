import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String regEx = "(@|#)(?<wordOne>[A-Za-z]{3,})\\1\\1(?<wordTwo>[A-Za-z]{3,})\\1";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(text);
        List<String> mirrorWords = new ArrayList<>();
        int count = 0;
        while (matcher.find()){
            count++;
            String wordOne = matcher.group("wordOne");
            String wordTwo = matcher.group("wordTwo");
            if(wordsAreMirror(wordOne,wordTwo)){
                mirrorWords.add(wordOne + " <=> " + wordTwo);
            }
        }
        if(count==0){
            System.out.println("No word pairs found!");
        }else{
            System.out.println(count+" word pairs found!");
        }
        if(!mirrorWords.isEmpty()){
            System.out.println("The mirror words are:");
            System.out.println(String.join(", ",mirrorWords));
        }else{
            System.out.println("No mirror words!");
        }
    }

    private static boolean wordsAreMirror(String wordOne, String wordTwo) {
        StringBuilder reversed = new StringBuilder();
        for (int i = wordTwo.length()-1; i >=0 ; i--) {
            reversed.append(wordTwo.charAt(i));
        }
        return wordOne.equals(String.valueOf(reversed));
    }
}
