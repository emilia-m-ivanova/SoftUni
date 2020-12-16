import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        String basePath = "D:\\SoftUni\\Java Advanced\\StreamsFilesAndDirectoriesLab\\resources\\Files-and-Streams";
        File file = new File(basePath);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File currentFile : files) {
                if (!currentFile.isDirectory()) {
                    System.out.println(currentFile.getName() + ": [" + currentFile.length() + "]");
                }
            }
        }
    }
}
