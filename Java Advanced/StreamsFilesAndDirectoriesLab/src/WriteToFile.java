import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WriteToFile {
    public static void main(String[] args) {
        String path = "D:\\SoftUni\\Java Advanced\\StreamsFilesAndDirectoriesLab\\resources";
        String in = path + "\\input.txt";
        String out = path + "\\02.WriteToFileOutput.txt";
        Set<Character> punctuation = new HashSet<>();
        Collections.addAll(punctuation, '.', ',', '!', '?');
        try (InputStream inputStream = new FileInputStream(in);
             OutputStream outputStream = new FileOutputStream(out)) {
            int readByte = inputStream.read();
            while (readByte >= 0) {
                if (!punctuation.contains((char)readByte)) {
                    outputStream.write(readByte);
                }
                readByte = inputStream.read();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
