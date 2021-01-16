package StackOfStrings;

public class Main {
    public static void main(String[] args) {
        StackOfStrings stack = new StackOfStrings();
        System.out.println(stack.isEmpty());
        stack.push("1");
        stack.push("2");
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}
