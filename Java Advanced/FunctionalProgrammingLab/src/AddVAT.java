import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UnaryOperator<Double> addVat = d -> d * 1.2;
        List<Double> prices = Arrays.stream(scanner.nextLine().split(", "))
                .map(Double::parseDouble)
                .map(e->addVat.apply(e))
                .collect(Collectors.toList());
        System.out.println("Prices with VAT:");
        prices.forEach(e-> System.out.printf("%.2f%n",e));
    }
}
