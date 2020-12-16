import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) {
        String basePath = "D:\\SoftUni\\Java Advanced\\StreamsFilesAndDirectoriesLab\\resources";
        String in = basePath + "\\input.txt";
        String out = basePath + "\\04.ExtractIntegersOutput.txt";
        try (Scanner scanner = new Scanner(new FileInputStream(in));
             PrintWriter writer = new PrintWriter(out)) {
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    writer.println(scanner.nextInt());
                }
                scanner.next();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
