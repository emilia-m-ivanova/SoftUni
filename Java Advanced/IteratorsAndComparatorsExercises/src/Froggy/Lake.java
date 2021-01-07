package Froggy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer> {

    List<Integer> lake;

    public Lake() {
        this.lake = new ArrayList<>();
    }

    public void add(Integer integer) {
        lake.add(integer);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {

            int index = 0;
            boolean lastIndexIsEven = (lake.size() - 1) % 2 == 0;

            @Override
            public boolean hasNext() {
                if (lastIndexIsEven) {
                    return index != lake.size();
                } else {
                    return index != lake.size() + 1;
                }
            }

            @Override
            public Integer next() {
                int result = lake.get(index);
                index += 2;
                if (index % 2 == 0 && index >= lake.size()) {
                    index = 1;
                }
                return result;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Integer integer : this) {
            sb.append(integer).append(", ");
        }
        sb.delete(sb.length()-2,sb.length());
        return String.valueOf(sb);
    }
}
