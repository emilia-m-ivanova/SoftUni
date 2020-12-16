import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class WriteEveryThirdLine {
    public static void main(String[] args) {
        String basePath = "D:\\SoftUni\\Java Advanced\\StreamsFilesAndDirectoriesLab\\resources";
        String in = basePath + "\\input.txt";
        String out = basePath + "\\05.WriteEveryThirdLineOutput.txt";
        try(Scanner scanner = new Scanner(new FileInputStream(in));
            PrintWriter writer = new PrintWriter(new FileOutputStream(out))){
            int n = 1;
            String line = scanner.nextLine();
            while (scanner.hasNextLine()){
                if(n%3==0){
                    writer.println(line);
                }
                line = scanner.nextLine();
                n++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
