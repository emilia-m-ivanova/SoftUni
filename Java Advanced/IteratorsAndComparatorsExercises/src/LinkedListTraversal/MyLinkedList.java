package LinkedListTraversal;

import java.util.Iterator;

public class MyLinkedList<E> implements Iterable<E>{

    Node<E> head;
    int size;

    public MyLinkedList() {
        this.size = 0;
    }

    private static class Node<E> {
        E current;

        Node<E> next;

        public Node(E current) {
            this.current = current;
        }

    }

    public void add(E element) {
        if (this.head == null) {
            this.head = new Node<>(element);
        }else{
            Node<E> current = this.head;
            while (current.next!=null){
                current = current.next;
            }
            current.next = new Node<>(element);
        }
        this.size++;
    }

    public int getSize (){
     return this.size;
    }

    public boolean remove (E element){
       Node<E> current = this.head;
       while (current!=null){
           if(current.current.equals(element)){
               current.current = current.next.current;
               current.next = current.next.next;
               this.size--;
               return true;
           }
           current = current.next;
       }
       return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            Node<E> current = head;
            @Override
            public boolean hasNext() {
                return current!=null;
            }

            @Override
            public E next() {
                E element = current.current;
                current = current.next;
                return element;
            }
        };
    }
}
