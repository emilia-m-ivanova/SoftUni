package Collection;


import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] initialArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .skip(1)
                .toArray(String[]::new);
        ListyIterator iterator = new ListyIterator(initialArr);

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] tokens = input.split("\\s+");
            switch (tokens[0]) {
                case "Move":
                    System.out.println(iterator.move());
                    break;
                case "Print":
                    try {
                        System.out.println(iterator.get());
                    }catch (NoSuchElementException e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case "PrintAll":
                    try {
                        for (String s : iterator) {
                            System.out.print(s + " ");
                        }
                        System.out.println();

                    }catch (NoSuchElementException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "HasNext":
                    System.out.println(iterator.hasNext());
                    break;
            }

            input = scanner.nextLine();
        }
    }
}

