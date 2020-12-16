import java.io.File;
import java.util.ArrayDeque;
import java.util.Arrays;

public class NestedFolders {
    public static void main(String[] args) {
        String basePath = "D:\\SoftUni\\Java Advanced\\StreamsFilesAndDirectoriesLab\\resources\\Files-and-Streams";
        File file = new File(basePath);
        ArrayDeque<File> queue = new ArrayDeque<>();
        queue.add(file);
        int n = 0;
        while(!queue.isEmpty()){
            File currentFile = queue.poll();
            if(currentFile.isDirectory()){
                queue.addAll(Arrays.asList(currentFile.listFiles()));
                System.out.println(currentFile.getName());
                n++;
            }
        }
        System.out.println(n + " folders");
    }
}
