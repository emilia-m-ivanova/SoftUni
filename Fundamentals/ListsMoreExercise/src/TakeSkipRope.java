import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TakeSkipRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> stringList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        String[] array = scanner.nextLine().split("");
        for (String s : array) {
            if (Character.isDigit(s.charAt(0))) {
                integerList.add(Integer.parseInt(s));
            } else {
                stringList.add(s);
            }
        }
        List<Integer> integerTakeList = new ArrayList<>();
        List<Integer> integerRemoveList = new ArrayList<>();
        for (int i = 0; i < integerList.size(); i++) {
            if (i % 2 != 0) {
                integerRemoveList.add(integerList.get(i));
            } else {
                integerTakeList.add(integerList.get(i));
            }
        }
        int stringIndex = 0;
        int intIndex = 0;
        String output = "";
        for (int i = 0; i < integerTakeList.size(); i++) {
            for (int j = 0; j < integerTakeList.get(intIndex); j++) {
                if (stringIndex < stringList.size()) {
                    output += stringList.get(stringIndex);
                    stringIndex++;
                }
            }
            for (int j = 0; j < integerRemoveList.get(intIndex); j++) {
                if (stringIndex < stringList.size()) {
                    stringIndex++;
                }
            }
            intIndex++;
        }
        System.out.println(output);
    }
}
