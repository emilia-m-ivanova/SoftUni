import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MergeTwoFiles {
    public static void main(String[] args) {
        String inputOne = "resources\\inputOne.txt";
        String inputTwo = "resources\\inputTwo.txt";
        String outputPath = "resources\\07.outputMergeTwoFiles.txt";
        try(Scanner scannerOne = new Scanner(new FileInputStream(inputOne));
            Scanner scannerTwo = new Scanner(new FileInputStream(inputTwo));
            PrintWriter writer = new PrintWriter(outputPath)){
            while (scannerOne.hasNext()){
                String line = scannerOne.nextLine();
                writer.println(line);
            }
            while (scannerTwo.hasNext()){
                String line = scannerTwo.nextLine();
                writer.println(line);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
