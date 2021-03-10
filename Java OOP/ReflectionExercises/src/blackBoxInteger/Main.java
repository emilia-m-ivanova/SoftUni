package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Scanner scanner = new Scanner(System.in);
        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        Constructor<BlackBoxInt> ctor = clazz.getDeclaredConstructor();
        ctor.setAccessible(true);
        BlackBoxInt instance = ctor.newInstance();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            method.setAccessible(true);
        }
        Field[] fields = clazz.getDeclaredFields();
        Field innerValue = Arrays.stream(fields)
                .filter(f -> f.getName().equals("innerValue"))
                .findFirst()
                .orElse(null);
        innerValue.setAccessible(true);


        String input = scanner.nextLine();
        while (!input.equals("END")){
            String[] tokens = input.split("_");
            Method method = Arrays.stream(methods)
                    .filter(m -> m.getName().equals(tokens[0]))
                    .findFirst().orElse(null);
            method.invoke(instance,Integer.parseInt(tokens[1]));
            System.out.println(innerValue.get(instance));
            input = scanner.nextLine();
        }

    }
}
