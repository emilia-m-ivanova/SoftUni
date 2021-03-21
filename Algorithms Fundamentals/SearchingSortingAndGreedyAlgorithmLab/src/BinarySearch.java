import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int n = Integer.parseInt(scanner.nextLine());

        int index = findIndex(arr, n, 0, arr.length - 1);
        System.out.println(index);
    }

    private static int findIndex(int[] arr, int n, int start, int end) {
        if(start>end){
            return -1;
        }
        int index = start + (end - start) / 2;
        if (n < arr[index]) {
            return findIndex(arr, n, start, index - 1);
        } else if (n > arr[index]) {
            return findIndex(arr, n, index + 1, end);
        } else {
            return index;
        }
    }
}
