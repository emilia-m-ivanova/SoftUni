package Collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ListyIterator implements Iterable<String>{
    private List<String> elements;

    public ListyIterator(String... elements) {
        this.elements = Arrays.asList(elements);
    }

    int index = 0;

    public boolean hasNext() {
        return index < elements.size() - 1;
    }

    public String get() throws NoSuchElementException {
        if(this.elements.isEmpty()){
            throw new NoSuchElementException("Invalid Operation!");
        }
        return elements.get(index);
    }

    public boolean move() {
        if (this.hasNext()) {
            this.index++;
            return true;
        }
        return false;
    }

    public class Iter implements Iterator<String>{

        int index = 0;

        @Override
        public boolean hasNext() {
            return this.index < elements.size();
        }

        @Override
        public String next() {
            return elements.get(this.index++);
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new Iter();
    }
}
