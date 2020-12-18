import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String command = scanner.nextLine();

        while (!command.equals("end")) {
            UnaryOperator<Integer> manipulate = getOperator(command);
            if (!command.equals("print")) {
                numbers = numbers.stream()
                        .map(manipulate)
                        .collect(Collectors.toList());
            }else{
                numbers.forEach(e-> System.out.print(e + " "));
                System.out.println();
            }
            command = scanner.nextLine();
        }
    }

    private static UnaryOperator<Integer> getOperator(String command) {
        UnaryOperator<Integer> result = null;
        switch (command) {
            case "add":
                result = e -> e + 1;
                break;
            case "multiply":
                result = e -> e * 2;
                break;
            case "subtract":
                result = e -> e - 1;
        }
        return result;
    }
}
