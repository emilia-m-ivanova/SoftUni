import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SchoolLibrary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> books = readList(scanner);
        String input = scanner.nextLine();
        while(!input.equals("Done")){
            String[] command = input.split(" "+"\\|"+" ");
            switch (command[0]){
                case "Add Book":
                    if(!books.contains(command[1])){
                        books.add(0,command[1]);
                    }
                    break;
                case "Take Book":
                    books.remove(command[1]);
                    break;
                case "Swap Books":
                    if(books.contains(command[1])&&books.contains(command[2])){
                        String temp = command[1];
                        int index1 = books.indexOf(command[1]);
                        int index2 = books.indexOf(command[2]);
                        books.set(index1,command[2]);
                        books.set(index2,temp);
                    }
                    break;
                case "Insert Book":
                    books.add(command[1]);
                    break;
                case "Check Book":
                    int index = Integer.parseInt(command[1]);
                    if(0<=index && index<books.size()){
                        System.out.println(books.get(index));
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(String.join(", ",books));
    }

    private static List<String> readList(Scanner scanner) {
        String [] input = scanner.nextLine().split("&");
        List <String> stringList = new ArrayList<>();
        for (String element : input) {
            stringList.add(element);
        }

        return stringList;
    }
}
