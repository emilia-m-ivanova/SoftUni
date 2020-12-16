import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines {
    public static void main(String[] args) throws IOException {
        String basePath = "D:\\SoftUni\\Java Advanced\\StreamsFilesAndDirectoriesLab\\resources";
        String in = basePath + "\\input.txt";
        String out = basePath + "\\06.SortLinesOutput.txt";
        Path pathIn = Paths.get(in);
        Path pathOut = Paths.get(out);

        List<String> allLines = Files.readAllLines(pathIn);
        Collections.sort(allLines);
        Files.write(pathOut,allLines);
    }
}
