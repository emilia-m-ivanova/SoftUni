import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LineNumbers {
    public static void main(String[] args) {
        String inputPath = "resources\\inputLineNumbers.txt";
        String outputPath = "resources\\05.outputLineNumbers.txt";
        try(BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath));
            PrintWriter writer = new PrintWriter(outputPath)){
            String line = reader.readLine();
            int n = 1;
            while (line!=null){
                writer.println(n + ". " + line);
                line = reader.readLine();
                n++;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
