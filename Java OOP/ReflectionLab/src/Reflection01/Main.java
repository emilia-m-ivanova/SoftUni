package Reflection01;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Reflection> reflection = Reflection.class;
        Constructor<Reflection> constructor = reflection.getDeclaredConstructor();
        Reflection instance = constructor.newInstance();
        System.out.println("class " + reflection.getSimpleName());
        System.out.println(reflection.getSuperclass());
        Arrays.stream(reflection.getInterfaces()).forEach(System.out::println);
        System.out.println(instance);
    }
}
