import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SumLines {
    public static void main(String[] args) {
        String inputPath = "resources\\input.txt";
        try(BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath))){
            String line = reader.readLine();
            while(line!=null){
                int sum = 0;
                for (int i = 0; i < line.length(); i++) {
                    sum+=line.charAt(i);
                }
                System.out.println(sum);
                line = reader.readLine();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
