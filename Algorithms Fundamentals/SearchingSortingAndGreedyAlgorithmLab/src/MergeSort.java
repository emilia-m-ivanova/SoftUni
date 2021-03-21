import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }

    }

    private static void sort(int[] arr) {
        if (arr.length == 1) {
            return;
        }

        int mid = arr.length / 2;
        int[] firstPartition = new int[mid];
        int[] secondPartition = new int[arr.length - mid];

        for (int i = 0; i < firstPartition.length; i++) {
            firstPartition[i] = arr[i];
        }

        for (int i = mid; i < mid + secondPartition.length; i++) {
            secondPartition[i - mid] = arr[i];
        }

        sort(firstPartition);
        sort(secondPartition);

        merge(arr, firstPartition, secondPartition);

    }

    private static void merge(int[] arr, int[] firstPartition, int[] secondPartition) {
        int mainIndex = 0;
        int firstIndex = 0;
        int secondIndex = 0;

        while (firstIndex < firstPartition.length && secondIndex < secondPartition.length) {
            if (firstPartition[firstIndex] < secondPartition[secondIndex]) {
                arr[mainIndex++] = firstPartition[firstIndex++];
            } else {
                arr[mainIndex++] = secondPartition[secondIndex++];
            }
        }

        while (firstIndex < firstPartition.length) {
            arr[mainIndex++] = firstPartition[firstIndex++];
        }

        while (secondIndex < secondPartition.length) {
            arr[mainIndex++] = secondPartition[secondIndex++];
        }
    }

}
