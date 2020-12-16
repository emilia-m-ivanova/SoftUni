import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeCustomObject {
    static class Cube implements Serializable{
        String color;
        double width;
        double height;
        double depth;

        public Cube(String color, double width, double height, double depth) {
            this.color = color;
            this.width = width;
            this.height = height;
            this.depth = depth;
        }
    }
    public static void main(String[] args) {
        Cube cube = new Cube("green",15.3, 12.4,3.0);
        String basePath = "D:\\SoftUni\\Java Advanced\\StreamsFilesAndDirectoriesLab\\resources";
        String out = basePath + "\\serialized.ser";
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(out))){
            oos.writeObject(cube);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
