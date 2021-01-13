package LinkedListTraversal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            int num = Integer.parseInt(tokens[1]);
            if(tokens[0].equals("Add")){
                myLinkedList.add(num);
            }else{
                myLinkedList.remove(num);
            }
        }
        System.out.println(myLinkedList.getSize());
        for (Integer integer : myLinkedList) {
            System.out.print(integer + " ");
        }

    }
}
