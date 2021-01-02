import java.util.ArrayDeque;

public class Jar<T>{
    private ArrayDeque<T> jar;

    public Jar() {
        this.jar = new ArrayDeque<>();
    }

    public void add (T element){
        this.jar.push(element);
    }

    public T remove (){
        return this.jar.pop();
    }
}
