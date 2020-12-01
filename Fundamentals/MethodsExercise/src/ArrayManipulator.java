import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arrayOfIntegers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(element -> Integer.parseInt(element)).toArray();
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] command = input.split(" ");
            switch (command[0]) {
                case "exchange":
                    splitArray(arrayOfIntegers, Integer.parseInt(command[1]));
                    break;
                case "max":
                    printIndexOfMax(arrayOfIntegers, command[1]);
                    break;
                case "min":
                    printIndexOfMin(arrayOfIntegers, command[1]);
                    break;
                case "first":
                    printFirstNElements(arrayOfIntegers, Integer.parseInt(command[1]), command[2]);
                    break;
                case "last":
                    printLastNElements(arrayOfIntegers, Integer.parseInt(command[1]), command[2]);
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println(Arrays.toString(arrayOfIntegers));
    }


    private static void printLastNElements(int[] arrayOfIntegers, int n, String evenOrOdd) {

        if (n > arrayOfIntegers.length) {
            System.out.println("Invalid count");
            return;
        }
        if (evenOrOdd.equals("even")) {
            printLastNEvenElements(arrayOfIntegers, n);
        } else {
            printLastNOddElements(arrayOfIntegers, n);
        }

    }

    private static void printLastNOddElements(int[] arrayOfIntegers, int n) {

        int oddCount = 0;
        for (int element : arrayOfIntegers) {
            if (element % 2 != 0) {
                oddCount++;
            }
        }
        if (oddCount > n) {
            oddCount = n;
        }
        int[] lastNEvenElements = new int[oddCount];
        int index = 0;
        for (int i = arrayOfIntegers.length - 1; i >= 0; i--) {
            if (arrayOfIntegers[i] % 2 != 0) {
                index++;
                lastNEvenElements[oddCount - index] = arrayOfIntegers[i];
            }
            if (index == oddCount) {
                break;
            }
        }

        System.out.println(Arrays.toString(lastNEvenElements));

    }

    private static void printLastNEvenElements(int[] arrayOfIntegers, int n) {

        int evenCount = 0;
        for (int element : arrayOfIntegers) {
            if (element % 2 == 0) {
                evenCount++;
            }
        }
        if (evenCount > n) {
            evenCount = n;
        }
        int[] lastNEvenElements = new int[evenCount];
        int index = 0;
        for (int i = arrayOfIntegers.length - 1; i >= 0; i--) {
            if (arrayOfIntegers[i] % 2 == 0) {
                index++;
                lastNEvenElements[evenCount - index] = arrayOfIntegers[i];
            }
            if (index == evenCount) {
                break;
            }
        }

        System.out.println(Arrays.toString(lastNEvenElements));

    }

    private static void printFirstNElements(int[] arrayOfIntegers, int n, String evenOrOdd) {

        if (n > arrayOfIntegers.length) {
            System.out.println("Invalid count");
            return;
        }
        if (evenOrOdd.equals("even")) {
            printFirstNEvenElements(arrayOfIntegers, n);
        } else {
            printFirstNOddElements(arrayOfIntegers, n);
        }

    }

    private static void printFirstNOddElements(int[] arrayOfIntegers, int n) {
        int oddCount = 0;
        for (int element : arrayOfIntegers) {
            if (element % 2 != 0) {
                oddCount++;
            }
        }
        if (oddCount > n) {
            oddCount = n;
        }
        int[] firstNOddElements = new int[oddCount];
        int index = 0;
        for (int element : arrayOfIntegers) {
            if (element % 2 != 0) {
                firstNOddElements[index] = element;
                index++;
            }
            if (index == oddCount) {
                break;
            }
        }
        System.out.println(Arrays.toString(firstNOddElements));
    }

    private static void printFirstNEvenElements(int[] arrayOfIntegers, int n) {
        int evenCount = 0;
        for (int element : arrayOfIntegers) {
            if (element % 2 == 0) {
                evenCount++;
            }
        }
        if (evenCount > n) {
            evenCount = n;
        }
        int[] firstNEvenElements = new int[evenCount];
        int index = 0;
        for (int element : arrayOfIntegers) {
            if (element % 2 == 0) {
                firstNEvenElements[index] = element;
                index++;
            }
            if (index == evenCount) {
                break;
            }
        }
        System.out.println(Arrays.toString(firstNEvenElements));
    }

    private static void printIndexOfMin(int[] arrayOfIntegers, String evenOrOdd) {
        if (evenOrOdd.equals("even")) {
            printIndexOfMinEven(arrayOfIntegers);
        } else {
            printIndexOfMinOdd(arrayOfIntegers);
        }
    }

    private static void printIndexOfMinOdd(int[] arrayOfIntegers) {

        int minNum = Integer.MAX_VALUE;
        int minOddIndex = -1;
        for (int i = 0; i < arrayOfIntegers.length; i++) {
            if (arrayOfIntegers[i] % 2 != 0 && arrayOfIntegers[i] <= minNum) {
                minNum = arrayOfIntegers[i];
                minOddIndex = i;
            }
        }
        if (minOddIndex >= 0) {
            System.out.println(minOddIndex);
        } else {
            System.out.println("No matches");
        }

    }

    private static void printIndexOfMinEven(int[] arrayOfIntegers) {

        int minNum = Integer.MAX_VALUE;
        int minEvenIndex = -1;
        for (int i = 0; i < arrayOfIntegers.length; i++) {
            if (arrayOfIntegers[i] % 2 == 0 && arrayOfIntegers[i] <= minNum) {
                minNum = arrayOfIntegers[i];
                minEvenIndex = i;
            }
        }
        if (minEvenIndex >= 0) {
            System.out.println(minEvenIndex);
        } else {
            System.out.println("No matches");
        }

    }

    private static void printIndexOfMax(int[] arrayOfIntegers, String evenOrOdd) {
        if (evenOrOdd.equals("even")) {
            printIndexOfMaxEven(arrayOfIntegers);
        } else {
            printIndexOfMaxOdd(arrayOfIntegers);
        }
    }

    private static void printIndexOfMaxOdd(int[] arrayOfIntegers) {

        int maxNum = Integer.MIN_VALUE;
        int maxOddIndex = -1;
        for (int i = 0; i < arrayOfIntegers.length; i++) {
            if (arrayOfIntegers[i] % 2 != 0 && arrayOfIntegers[i] >= maxNum) {
                maxNum = arrayOfIntegers[i];
                maxOddIndex = i;
            }
        }
        if (maxOddIndex >= 0) {
            System.out.println(maxOddIndex);
        } else {
            System.out.println("No matches");
        }

    }

    private static void printIndexOfMaxEven(int[] arrayOfIntegers) {

        int maxNum = Integer.MIN_VALUE;
        int maxEvenIndex = -1;
        for (int i = 0; i < arrayOfIntegers.length; i++) {
            if (arrayOfIntegers[i] % 2 == 0 && arrayOfIntegers[i] >= maxNum) {
                maxNum = arrayOfIntegers[i];
                maxEvenIndex = i;
            }
        }
        if (maxEvenIndex >= 0) {
            System.out.println(maxEvenIndex);
        } else {
            System.out.println("No matches");
        }

    }

    private static void splitArray(int[] arrayOfIntegers, int index) {

        if (0 > index || index > arrayOfIntegers.length - 1) {
            System.out.println("Invalid index");
            return;
        }
        int[] firstHalf = new int[arrayOfIntegers.length - (index + 1)];
        for (int i = 0; i < firstHalf.length; i++) {
            firstHalf[i] = arrayOfIntegers[index + 1 + i];
        }
        int[] secondHalf = new int[index + 1];
        for (int i = 0; i < secondHalf.length; i++) {
            secondHalf[i] = arrayOfIntegers[i];
        }

        for (int i = 0; i < firstHalf.length; i++) {
            arrayOfIntegers[i] = firstHalf[i];
        }
        for (int j = 0; j < secondHalf.length; j++) {
            arrayOfIntegers[firstHalf.length + j] = secondHalf[j];
        }

    }
}
