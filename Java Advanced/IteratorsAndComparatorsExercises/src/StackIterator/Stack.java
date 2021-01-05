package StackIterator;

import java.util.Iterator;

public class Stack implements Iterable<Integer> {

    Node node;


    private static class Node {

        private Integer element;
        private Node previous;

    }

    public Stack() {
        this.node = new Node();
    }

    public void push(Integer element) {
        Node node = new Node();
        node.previous = this.node;
        node.element = element;
        this.node = node;
    }

    public Integer pop() {
        if (node != null) {
            Integer element = this.node.element;
            this.node = this.node.previous;
            return element;
        }
        return null;
    }

    private static class StackIterator implements Iterator<Integer> {

        Node currentNode;

        public StackIterator(Node currentNode) {
            this.currentNode = currentNode;
        }

        @Override
        public boolean hasNext() {
            if(currentNode==null){
                return false;
            }
            return currentNode.previous != null;
        }

        @Override
        public Integer next() {
            Integer element = currentNode.element;
            currentNode = currentNode.previous;
            return element;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new StackIterator(this.node);
    }
}
