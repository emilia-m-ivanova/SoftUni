import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String,Map<String,Double>> supermarkets = new TreeMap<>();
        while (!input.equals("Revision")){
            String[] tokens = input.split(",\\s+");
            String supermarket = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);
            supermarkets.putIfAbsent(supermarket,new LinkedHashMap<>());
            supermarkets.get(supermarket).putIfAbsent(product,price);
            input = scanner.nextLine();
        }
        supermarkets.forEach((k,v)->{
            System.out.println(k+"->");
            v.forEach((product,price)-> System.out.printf("Product: %s, Price: %.1f%n",product,price));
        });
    }
}
