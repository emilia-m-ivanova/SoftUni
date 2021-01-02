import java.util.Comparator;
import java.util.List;

public class ListUtils {

    public static <T extends Comparable<T>> T getMin(List<T> list) {
        return list.stream()
                .min(Comparator.naturalOrder())
                .orElseThrow(IllegalArgumentException::new);
    }

    public static <T extends Comparable<T>> T getMax(List<T> list) {
        return list.stream()
                .max(Comparator.naturalOrder())
                .orElseThrow(IllegalArgumentException::new);
    }
}
