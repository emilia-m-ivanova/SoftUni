import java.util.Scanner;

public class KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int maxSum = 0;
        int maxSequence = 0;
        int indexLeft = 0;
        int sequenceLine = 0;
        int lineCounter = 0;
        String[] output = new String[length];
        while (!input.equals("Clone them!")) {
            lineCounter++;
            String[] arrayAsStrings = input.split("!+");
            int[] array = new int[arrayAsStrings.length];
            for (int i = 0; i < array.length; i++) {
                array[i] = Integer.parseInt(arrayAsStrings[i]);
            }
            int sum = 0;
            int sequence = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] == 1) {
                    sequence++;
                    sum++;
                    if (sequence > maxSequence) {
                        maxSequence = sequence;
                        indexLeft = i - sequence + 1;
                        sequenceLine = lineCounter;

                    } else if (sequence == maxSequence) {
                        if (i - sequence + 1 < indexLeft) {
                            indexLeft = i - sequence + 1;
                            sequenceLine = lineCounter;

                        } else if (i - sequence + 1 == indexLeft) {
                            int currentSum = 0;
                            for (int element:array) {
                                currentSum+=element;
                            }
                            if (currentSum > maxSum) {
                                sequenceLine = lineCounter;
                            }
                        }
                    }
                } else {
                    sequence = 0;
                }
            }
            if (sequenceLine==lineCounter) {
                maxSum = sum;
                output = arrayAsStrings;
            }else if(sequenceLine==0){
                sequenceLine=1;
                output = arrayAsStrings;
            }

            input = scanner.nextLine();
        }
        System.out.printf("Best DNA sample %d with sum: %d.%n", sequenceLine, maxSum);
        System.out.println(String.join(" ", output));
    }
}