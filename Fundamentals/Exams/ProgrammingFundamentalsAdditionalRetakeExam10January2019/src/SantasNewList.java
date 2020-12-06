import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SantasNewList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String,Integer> children = new TreeMap<>();
        Map<String, Integer> toys = new LinkedHashMap<>();
        while (!input.equals("END")){
            String [] tokens = input.split("->");
            if(tokens.length==2){
                children.remove(tokens[1]);
            }else{
                children.putIfAbsent(tokens[0],0);
                children.put(tokens[0],children.get(tokens[0])+Integer.parseInt(tokens[2]));
                toys.putIfAbsent(tokens[1],0);
                toys.put(tokens[1],toys.get(tokens[1])+Integer.parseInt(tokens[2]));
            }
            input = scanner.nextLine();
        }
        System.out.println("Children:");
        children.entrySet()
                .stream()
                .sorted((a,b)->b.getValue().compareTo(a.getValue()))
                .forEach(e-> System.out.println(e.getKey()+" -> "+e.getValue()));
        System.out.println("Presents:");
        toys.forEach((k,v)-> System.out.println(k+" -> "+v));
    }
}
