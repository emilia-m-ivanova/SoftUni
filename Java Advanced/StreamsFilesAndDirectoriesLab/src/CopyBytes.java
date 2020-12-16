import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyBytes {
    public static void main(String[] args) {
        String basePath = "D:\\SoftUni\\Java Advanced\\StreamsFilesAndDirectoriesLab\\resources";
        String in = basePath + "\\input.txt";
        String out = basePath + "\\03.CopyBytesOutput.txt";
        try(InputStream inputStream = new FileInputStream(in);
            OutputStream outputStream = new FileOutputStream(out)){
            int readByte = inputStream.read();
            while (readByte>=0){
                if(readByte!=' '&& readByte!='\n'){
                    for (char c : String.valueOf(readByte).toCharArray()) {
                        outputStream.write(c);
                    }
                }else{
                    outputStream.write((char)readByte);
                }
                readByte = inputStream.read();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
