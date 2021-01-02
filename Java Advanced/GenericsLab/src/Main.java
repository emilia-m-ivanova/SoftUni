import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scale<String> stringScale = new Scale<>("abc","abcd");
        Scale<Integer> integerScale = new Scale<>(5,4);
        Scale<Integer> integerScale2 = new Scale<>(1,1);
        System.out.println(stringScale.getHeavier());
        System.out.println(integerScale.getHeavier());
        System.out.println(integerScale2.getHeavier());

        List<Integer> integerList = new ArrayList<>();
        Collections.addAll(integerList,5,4,6,1,2);
        System.out.println(ListUtils.getMin(integerList));
        List<String> stringList = new ArrayList<>();
        System.out.println(ListUtils.getMax(stringList));
    }
}
