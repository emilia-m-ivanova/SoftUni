package RandomArrayList;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        RandomArrayList<Integer> arrayList = new RandomArrayList<Integer>();
        Collections.addAll(arrayList,1,2,3,4,5,6,7);
        System.out.println(arrayList.getRandomElement());
    }
}
