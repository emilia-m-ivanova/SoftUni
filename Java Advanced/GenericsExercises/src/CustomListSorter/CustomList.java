package CustomListSorter;

import java.util.NoSuchElementException;

public class CustomList<T extends Comparable<T>> {
    private static final int INITIAL_CAPACITY = 4;
    private Object[] elements;
    private int size;

    public CustomList() {
        this.elements = new Object[INITIAL_CAPACITY];
        this.size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public void add(T element) {
        if (this.size == this.elements.length) {
            this.elements = grow(this.elements);
        }
        this.elements[size++] = element;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) throws IndexOutOfBoundsException {
        if (indexIsInBounds(index)) {
            return (T) this.elements[index];
        }
        throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for size " + this.size);
    }

    private Object[] grow(Object[] elements) {
        Object[] arrDoubled = new Object[elements.length * 2];
        System.arraycopy(elements, 0, arrDoubled, 0, elements.length);
        return arrDoubled;
    }

    @SuppressWarnings("unchecked")
    public T remove(int index) throws IndexOutOfBoundsException {
        if (indexIsInBounds(index)) {
            T element = (T) this.elements[index];
            if (this.size - 1 - index >= 0) {
                System.arraycopy(this.elements, index + 1, this.elements, index, this.size - 1 - index);
            }
            this.elements[size - 1] = null;
            this.size--;
            if (this.size == elements.length / 3) {
                this.elements = shrink(this.elements);
            }
            return element;
        }
        throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for size " + this.size);
    }

    private Object[] shrink(Object[] elements) {
        Object[] arrShrunk = new Object[elements.length / 3];
        System.arraycopy(elements, 0, arrShrunk, 0, arrShrunk.length);
        return arrShrunk;
    }

    private boolean isEmpty() {
        return this.size == 0;
    }

    @SuppressWarnings("unchecked")
    public boolean contains(T element) {
        if (isEmpty()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            T obj = (T) this.elements[i];
            if (obj.equals(element)) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public void swap(int indexOne, int indexTwo) throws IndexOutOfBoundsException {
        if (indexIsInBounds(indexOne) && indexIsInBounds(indexTwo)) {
            T temp = (T) this.elements[indexOne];
            this.elements[indexOne] = this.elements[indexTwo];
            this.elements[indexTwo] = temp;
            return;
        }
        throw new IndexOutOfBoundsException("Index is out of bounds for size " + this.size);
    }

    private boolean indexIsInBounds(int index) {
        return 0 <= index && index < this.size;
    }

    @SuppressWarnings("unchecked")
    public int countGreaterThan(T element) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            T currentElement = (T) this.elements[i];
            if (currentElement.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    @SuppressWarnings("unchecked")
    public T getMax() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        T maxElement = (T) this.elements[0];
        for (int i = 1; i < size; i++) {
            T currentElement = (T) this.elements[i];
            if (currentElement.compareTo(maxElement) > 0) {
                maxElement = currentElement;
            }
        }
        return maxElement;
    }

    @SuppressWarnings("unchecked")
    public T getMin() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        T minElement = (T) this.elements[0];
        for (int i = 1; i < size; i++) {
            T currentElement = (T) this.elements[i];
            if (currentElement.compareTo(minElement) < 0) {
                minElement = currentElement;
            }
        }
        return minElement;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(this.elements[i]).append(System.lineSeparator());
        }
        return String.valueOf(sb);
    }
}
