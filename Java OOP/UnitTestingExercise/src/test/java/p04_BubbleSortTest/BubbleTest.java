package p04_BubbleSortTest;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

public class BubbleTest {

    @Test
    public void testSort() {
        int[] arr = new int[10];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt();
        }
        int[] arrSorted = Arrays.stream(arr).sorted().toArray();
        Bubble.sort(arr);
        assertArrayEquals(arr,arrSorted);
    }
}