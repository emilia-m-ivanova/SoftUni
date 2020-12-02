import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DescendingOrder {
    public static int sortDesc(final int num) {
        //Your code
        List<Integer> integerList = new ArrayList<>();
        int number = num;
        while (number>0){
            int currentNum = number%10;
            integerList.add(currentNum);
            number/=10;
        }
        Collections.sort(integerList);
        Collections.reverse(integerList);
        String numAsString = "";
        for(int element: integerList){
            numAsString+=element;
        }
        if(num==0){
            return 0;
        }
        return Integer.parseInt(numAsString);
    }

}