import java.util.Comparator;
import java.util.List;

public class ListUtils {

    public static <T extends Comparable<T>> T getMin(List<T> list) throws IllegalArgumentException {
        if(list.isEmpty()){
            throw new IllegalArgumentException();
        }
        return list.stream()
                .min(Comparator.naturalOrder())
                .get();
    }

    public static <T extends Comparable<T>> T getMax(List<T> list) throws IllegalArgumentException {
        if(list.isEmpty()){
            throw new IllegalArgumentException();
        }
        return list.stream()
                .max(Comparator.naturalOrder())
                .get();
    }
}
