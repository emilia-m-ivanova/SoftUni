package zoo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        Gorilla gorilla = new Gorilla("Bill");
        animals.add(gorilla);
        Reptile reptile = new Lizard("Kim");
        animals.add(reptile);
    }
}
