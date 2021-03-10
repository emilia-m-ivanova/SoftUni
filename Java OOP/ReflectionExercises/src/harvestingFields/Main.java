package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        Class<RichSoilLand> clazz = RichSoilLand.class;
        Field[] fields = clazz.getDeclaredFields();
        String input = scanner.nextLine();
        while (!input.equals("HARVEST")) {
            for (Field field : fields) {
                if (Modifier.toString(field.getModifiers()).equals(input) || input.equals("all")) {
                    System.out.println(Modifier.toString(field.getModifiers()) + " " +
                            field.getType().getSimpleName() + " " + field.getName());
                }
            }
            input = scanner.nextLine();
        }
    }
}
