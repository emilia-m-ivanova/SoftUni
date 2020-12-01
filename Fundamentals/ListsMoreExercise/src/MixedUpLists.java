import java.util.*;

public class MixedUpLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstList = readList(scanner);
        List<Integer> secondList = readList(scanner);
        List<Integer> range = getRange(firstList,secondList);
        List<Integer> mergedList = mergeLists(firstList,secondList);
        List <Integer> output = new ArrayList<>();
        for (Integer element : mergedList) {
            if(element>range.get(0)&&element< range.get(1)){
                output.add(element);
            }
        }
        Collections.sort(output);
        for (Integer integer : output) {
            System.out.print(integer+" ");
        }

    }

    private static List<Integer> mergeLists(List<Integer> firstList, List<Integer> secondList) {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < firstList.size(); i++) {
            integerList.add(firstList.get(i));
            integerList.add(secondList.get(secondList.size()-1-i));
        }
        return integerList;
    }

    private static List<Integer> getRange(List<Integer> firstList, List<Integer> secondList) {
        List<Integer> range = new ArrayList<>();
        if(firstList.size()> secondList.size()){
            range.add(firstList.get(firstList.size()-1));
            firstList.remove(firstList.size()-1);
            range.add(firstList.get(firstList.size()-1));
            firstList.remove(firstList.size()-1);
        }else {
            range.add(secondList.get(0));
            secondList.remove(0);
            range.add(secondList.get(0));
            secondList.remove(0);
        }
        Collections.sort(range);
        return range;
    }

    private static List<Integer> readList(Scanner scanner) {
        String[] arrayAsStrings = scanner.nextLine().split("\\s+");
        List<Integer> integerList = new ArrayList<>();
        for (String string : arrayAsStrings) {
            integerList.add(Integer.parseInt(string));
        }
        return integerList;
    }
}
