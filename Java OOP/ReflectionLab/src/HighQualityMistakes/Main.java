package HighQualityMistakes;

import Reflection01.Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Class<Reflection> reflection = Reflection.class;
        Method[] methods = reflection.getDeclaredMethods();
        Field[] fields = reflection.getDeclaredFields();
        Set<Method> getters = new TreeSet<>(Comparator.comparing(Method::getName));
        Set<Method> setters = new TreeSet<>(Comparator.comparing(Method::getName));
        for (Method method : methods) {
            if (method.getName().startsWith("get")) {
                getters.add(method);
            } else if (method.getName().startsWith("set")) {
                setters.add(method);
            }
        }
        Arrays.stream(fields)
                .sorted(Comparator.comparing(Field::getName))
                .filter(f -> {
                    int modifiers = f.getModifiers();
                    return !Modifier.isPrivate(modifiers);
                })
                .forEach(f -> System.out.printf("%s must be private!%n", f.getName()));
        getters.stream()
                .filter(g -> {
                    int modifiers = g.getModifiers();
                    return !Modifier.isPublic(modifiers);
                })
                .forEach(g -> System.out.printf("%s have to be public!%n",
                        g.getName()));
        setters.stream()
                .filter(s -> {
                    int modifiers = s.getModifiers();
                    return !Modifier.isPrivate(modifiers);
                })
                .forEach(s -> System.out.printf("%s have to be private!%n",
                        s.getName()));
    }
}
