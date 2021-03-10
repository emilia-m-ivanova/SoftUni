package GettersAndSetters;

import Reflection01.Reflection;

import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        Class<Reflection> reflection = Reflection.class;
        Method[] methods = reflection.getDeclaredMethods();
        Set<Method> getters = new TreeSet<>(Comparator.comparing(Method::getName));
        Set<Method> setters = new TreeSet<>(Comparator.comparing(Method::getName));
        for (Method method : methods) {
            if(method.getName().startsWith("get")){
                getters.add(method);
            }else if (method.getName().startsWith("set")){
                setters.add(method);
            }
        }
        getters.forEach(g-> System.out.printf("%s will return class %s%n",
                g.getName(),g.getReturnType().toString().replace("class ","")));
        setters.forEach(s-> System.out.printf("%s and will set field of class %s%n",
                s.getName(),s.getParameterTypes()[0].toString().replace("class ","")));

    }
}
