import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CountCharacterTypes {
    public static void main(String[] args) {
        String inputPath = "resources\\input.txt";
        String outputPath = "resources\\04.CountCharacterTypes.txt";
        Set<Character> vowels = new HashSet<>();
        Set<Character> punctuation = new HashSet<>();
        Collections.addAll(vowels, 'a', 'e', 'i', 'o', 'u');
        Collections.addAll(punctuation, '!', ',', '.', '?');
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath));
             PrintWriter writer = new PrintWriter(outputPath)) {
            String line = reader.readLine();
            int countVowels = 0;
            int countConsonants = 0;
            int countPunctuation = 0;
            while (line != null) {
                for (char c : line.toCharArray()) {
                    if (c != ' ' && c!='\n'){
                        if(vowels.contains(c)){
                            countVowels++;
                        }else if(punctuation.contains(c)){
                            countPunctuation++;
                        }else {
                            countConsonants++;
                        }
                    }
                }
                line = reader.readLine();
            }
            writer.printf("Vowels: %d\n" +
                    "Consonants: %d\n" +
                    "Punctuation: %d\n",countVowels,countConsonants,countPunctuation);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
