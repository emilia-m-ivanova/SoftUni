import java.io.File;

public class GetFolderSize {
    public static void main(String[] args) {
        String path = "resources\\Exercises Resources";
        File file = new File(path);
        File[] files = file.listFiles();
        int size = 0;
        for (File f : files) {
            size+=f.length();
        }

        System.out.println("Folder size: " + size);
    }
}
