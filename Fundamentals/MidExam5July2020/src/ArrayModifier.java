import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arrayAsStrings = scanner.nextLine().split(" ");
        int[] integerArray = new int[arrayAsStrings.length];
        for (int i = 0; i < integerArray.length; i++) {
            integerArray[i] = Integer.parseInt(arrayAsStrings[i]);
        }
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] command = input.split(" ");
            switch (command[0]) {
                case "swap":
                    int firstElement = integerArray[Integer.parseInt(command[1])];
                    integerArray[Integer.parseInt(command[1])] = integerArray[Integer.parseInt(command[2])];
                    integerArray[Integer.parseInt(command[2])] = firstElement;
                    break;
                case "multiply":
                    int firstNum = integerArray[Integer.parseInt(command[1])];
                    int secondNum = integerArray[Integer.parseInt(command[2])];
                    integerArray[Integer.parseInt(command[1])] = firstNum * secondNum;
                    break;
                case "decrease":
                    for (int i = 0; i < integerArray.length; i++) {
                        integerArray[i] -= 1;
                    }
                    break;
            }


            input = scanner.nextLine();
        }
        for (int i = 0; i < integerArray.length; i++) {
            if (i != integerArray.length - 1) {
                System.out.print(integerArray[i] + ", ");
            }else {
                System.out.print(integerArray[i]);
            }
        }

    }
}
