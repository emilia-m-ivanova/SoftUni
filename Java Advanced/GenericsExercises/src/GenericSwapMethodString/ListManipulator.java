package GenericSwapMethodString;

import java.util.List;

public class ListManipulator {

    public static <T> void swapElements(List<T> list,int swapIndex1, int swapIndex2){
        T element = list.get(swapIndex1);
        list.set(swapIndex1,list.get(swapIndex2));
        list.set(swapIndex2,element);
    }

    public static <T> void printElements (List<T> list){
        StringBuilder sb = new StringBuilder();
        for (T t : list) {
            sb.append(t.getClass().getName()).append(": ").append(t).append(System.lineSeparator());
        }
        System.out.print(sb);
    }

}
