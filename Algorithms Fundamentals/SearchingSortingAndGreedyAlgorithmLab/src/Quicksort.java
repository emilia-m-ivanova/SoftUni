import java.util.Arrays;
import java.util.Scanner;

public class Quicksort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        sort(arr,0,arr.length-1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void sort(int[] arr, int low, int high) {
        if(low>=high){
            return;
        }
        int pivot = partition(arr, low, high);
        sort(arr,low,pivot-1);
        sort(arr,pivot+1,high);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if(arr[j]<=pivot){
                int temp = arr[i];
                arr[i++] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;

        return i;
    }
}
