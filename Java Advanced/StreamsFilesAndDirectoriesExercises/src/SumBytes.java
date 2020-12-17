import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SumBytes {
    public static void main(String[] args) {
        String inputPath = "resources\\input.txt";
        try(BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath))){
            String line = reader.readLine();
            int sum = 0;
            while(line!=null){
                for (int i = 0; i < line.length(); i++) {
                    sum+=line.charAt(i);
                }
                line = reader.readLine();
            }
            System.out.println(sum);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
