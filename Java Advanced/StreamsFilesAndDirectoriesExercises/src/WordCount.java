import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class WordCount {
    public static void main(String[] args) {
        String inputPathFirst = "resources\\words.txt";
        String inputPathSecond = "resources\\text.txt";
        String outputPath = "resources\\06.outputWordCount.txt";
        try (Scanner firstReader = new Scanner(new FileInputStream(inputPathFirst));
             Scanner secondReader = new Scanner(new FileInputStream(inputPathSecond));
             PrintWriter writer = new PrintWriter(outputPath)) {
            Map<String,Integer> words = new HashMap<>();
            while (firstReader.hasNext()) {
                String wordFirstFile = firstReader.next();
                words.putIfAbsent(wordFirstFile,0);
            }
            while (secondReader.hasNext()){
                String wordSecondFile = secondReader.next();
                if(words.containsKey(wordSecondFile)){
                    words.put(wordSecondFile,words.get(wordSecondFile)+1);
                }
            }
            words.entrySet().stream()
                    .sorted((a,b)->b.getValue().compareTo(a.getValue()))
                    .forEach(e->writer.println(e.getKey() + " - " + e.getValue()));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
