package GenericBox;

public class Box<T> {
    T element;
    public Box(T element){
        this.element = element;
    }

    @Override
    public String toString() {
        return this.element.getClass().getName() + ": " + this.element;
    }
}
