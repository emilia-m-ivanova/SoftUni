import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EasterShopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> shops = new ArrayList<>();
        String[] array = scanner.nextLine().split(" ");
        for (String element : array) {
            shops.add(element);
        }
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            switch (input[0]) {
                case "Include":
                    shops.add(input[1]);
                    break;
                case "Visit":
                    int numberOfShops = Integer.parseInt(input[2]);
                    if (numberOfShops <= shops.size()) {
                        switch (input[1]) {
                            case "first":
                                for (int j = 0; j < numberOfShops; j++) {
                                    shops.remove(0);
                                }
                                break;
                            case "last":
                                for (int j = 0; j < numberOfShops; j++) {
                                    shops.remove(shops.size() - 1);
                                }
                                break;
                        }
                    }
                    break;
                case "Prefer":
                    int index1 = Integer.parseInt(input[1]);
                    int index2 = Integer.parseInt(input[2]);
                    if (0 <= index1 && index1 < shops.size()
                            && 0 <= index2 && index2 < shops.size()) {
                        String temp = shops.get(index1);
                        shops.set(index1,shops.get(index2));
                        shops.set(index2,temp);
                    }
                    break;
                case "Place":
                    int index = Integer.parseInt(input[2])+1;
                    if(0 <= index && index < shops.size()){
                        shops.add(index,input[1]);
                    }
                    break;
            }
        }
        System.out.printf("Shops left:%n" +
                String.join(" ", shops));
    }
}
