package GenericCountMethodDouble;


public class Box <T extends Comparable<T>> implements Comparable<Box<T>>{
    T element;
    public Box(T element){
        this.element = element;
    }

    @Override
    public String toString() {
        return this.element.getClass().getName() + ": " + this.element;
    }


    @Override
    public int compareTo(Box<T> compareElement) {
        return this.element.compareTo(compareElement.getValue());
    }

    public T getValue() {
        return this.element;
    }
}