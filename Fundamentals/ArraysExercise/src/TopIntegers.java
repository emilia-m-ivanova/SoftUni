import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String [] arrayAsString = line.split(" ");
        int [] array = new int[arrayAsString.length];
        for (int i = 0; i < array.length; i++) {
            array[i]=Integer.parseInt(arrayAsString[i]);
        }
        for (int i = 0; i < array.length ; i++) {
            boolean isTop = true;
            for (int j = i+1; j < array.length; j++) {
                if (array[i] <= array[j]) {
                    isTop = false;
                    break;
                }
            }
            if (isTop){
                System.out.print(array[i]+" ");
            }
        }
    }
}
