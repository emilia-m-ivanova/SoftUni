import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulatorDebug {

    static int [] makeExchange(int [] numbers, int splitIndex){
        for (int i = 0; i <=splitIndex ; i++) {
            int oldNum = numbers[0];
            for (int j = 0; j < numbers.length - 1; j++) {
                numbers[j] = numbers[j+1];
            }
            numbers[numbers.length-1] = oldNum;
        }
        return numbers;
    }
    static void getMax(String type, int [] numbers){
        boolean areEqual = true;
        for (int i = 0; i < numbers.length-1; i++) {
            if(numbers[i]!=numbers[i+1]){
                areEqual = false;
                break;
            }
        }
        if(areEqual){
            System.out.println("No matches");
        }else {
            int index = -1;
            int maxValue = Integer.MIN_VALUE;
            if(type.equals("even")){
                for (int i = 0; i < numbers.length; i++) {
                    if(numbers[i]%2==0){
                        if (numbers[i]>=maxValue){
                            maxValue = numbers[i];
                            index=i;
                        }
                    }
                }
            }else if(type.equals("odd")){
                for (int i = 0; i < numbers.length; i++) {
                    if(numbers[i]%2!=0){
                        if (numbers[i]>=maxValue){
                            maxValue = numbers[i];
                            index=i;
                        }
                    }
                }
            }
            if(index>-1){
                System.out.println(index);
            }else{
                System.out.println("No matches");
            }
        }


    }
    static void getMin(String type, int [] numbers){
        boolean areEqual = true;
        for (int i = 0; i < numbers.length-1; i++) {
            if(numbers[i]!=numbers[i+1]){
                areEqual = false;
                break;
            }
        }
        if(areEqual){
            System.out.println("No matches");
        }else {
            int index = -1;
            int minValue = Integer.MAX_VALUE;
            if(type.equals("even")){
                for (int i = 0; i < numbers.length; i++) {
                    if(numbers[i]%2==0){
                        if (numbers[i]<=minValue){
                            minValue = numbers[i];
                            index=i;
                        }
                    }
                }
            }else if(type.equals("odd")){
                for (int i = 0; i < numbers.length; i++) {
                    if(numbers[i]%2!=0){
                        if (numbers[i]<=minValue){
                            minValue = numbers[i];
                            index=i;
                        }
                    }
                }
            }
            if(index>-1){
                System.out.println(index);
            }else{
                System.out.println("No matches");
            }
        }
    }
    static void getFirst(String type, int [] numbers, int count){
        int [] firstEvenOdd = new int[count];
        int countFound = 0;
        if(type.equals("even")){
            for (int i = 0; i < numbers.length; i++) {
                if(numbers[i]%2==0){
                    firstEvenOdd[countFound] = numbers[i];
                    countFound+=1;
                    if(countFound==count){
                        break;
                    }
                }
            }
        }else if(type.equals("odd")){
            for (int i = 0; i < numbers.length; i++) {
                if(numbers[i]%2!=0){
                    firstEvenOdd[countFound] = numbers[i];
                    countFound+=1;
                    if(countFound==count){
                        break;
                    }
                }
            }
        }
        if(countFound==0){
            System.out.println("[]");
        }else {
            String [] arrayToPrint = new String[countFound];
            for (int i = 0; i < arrayToPrint.length; i++) {
                arrayToPrint[i] = String.valueOf(firstEvenOdd[i]);
            }
            System.out.print("[");
            System.out.print(String.join(", ",arrayToPrint));
            System.out.println("]");
        }
    }
    static void getLast(String type, int [] numbers, int count){
        if(type.equals("even")){
            int countEvenFound = 0;
            for (int i = 0; i < numbers.length; i++) {
                if(numbers[i]%2==0){
                    countEvenFound++;
                }
            }
            if(countEvenFound<count){
                count=countEvenFound;
            }
            int [] lastEvenOdd = new int[count];
            for (int i = numbers.length-1; i >= 0; i--) {
                if(numbers[i]%2==0){
                    lastEvenOdd[count-1] = numbers[i];
                    count--;
                }
            }
            System.out.println(Arrays.toString(lastEvenOdd));

        }else if(type.equals("odd")){
            int countOddFound = 0;
            for (int i = 0; i < numbers.length; i++) {
                if(numbers[i]%2!=0){
                    countOddFound++;
                }
            }
            if(countOddFound<count){
                count=countOddFound;
            }
            int [] lastEvenOdd = new int[count];
            for (int i = numbers.length-1; i >= 0; i--) {
                if(numbers[i]%2!=0){
                    lastEvenOdd[count-1] = numbers[i];
                    count--;
                }
            }
            System.out.println(Arrays.toString(lastEvenOdd));
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String [] numbersAsString = input.split(" ");
        int [] numbers = new int[numbersAsString.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers [i] = Integer.parseInt(numbersAsString[i]);
        }
        String commands = scanner.nextLine();
        while (!commands.equals("end")){
            String [] commandLine = commands.split(" ");
            String mainCommand = commandLine[0];
            switch (mainCommand){
                case "exchange":
                    int indexToSplit = Integer.parseInt(commandLine[1]);
                    if(indexToSplit<numbers.length&&indexToSplit>=0){
                        makeExchange(numbers,indexToSplit);
                    }else {
                        System.out.println("Invalid index");

                    }
                    break;
                case "max":
                    String secondCommand = commandLine[1];
                    getMax(secondCommand,numbers);
                    break;
                case "min":
                    secondCommand = commandLine[1];
                    getMin(secondCommand,numbers);
                    break;
                case "first":
                    int count = Integer.parseInt(commandLine[1]);
                    if(count>numbers.length||count<0){
                        System.out.println("Invalid count");
                    }else{
                        secondCommand = commandLine[2];
                        getFirst(secondCommand, numbers, count);
                    }
                    break;
                case "last":
                    count = Integer.parseInt(commandLine[1]);
                    if(count>numbers.length||count<0){
                        System.out.println("Invalid count");
                    }else{
                        secondCommand = commandLine[2];
                        getLast(secondCommand, numbers, count);
                    }
                    break;

            }
            commands = scanner.nextLine();
        }
        String []arrayToPrint = new String[numbers.length];
        for (int i = 0; i < arrayToPrint.length; i++) {
            arrayToPrint[i] = String.valueOf(numbers[i]);
        }
        System.out.print("[");
        System.out.print(String.join(", ",arrayToPrint));
        System.out.println("]");

    }
}
 