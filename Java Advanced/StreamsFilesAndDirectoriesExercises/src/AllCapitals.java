import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AllCapitals {
    public static void main(String[] args) {
        String inputPath = "resources\\input.txt";
        String outputPath = "resources\\03.AllCapitals.output.txt";
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath));
             PrintWriter writer = new PrintWriter(outputPath)) {
            String line = reader.readLine();
            while (line != null) {
                writer.println(line.toUpperCase());
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
