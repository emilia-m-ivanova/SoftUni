import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integerList = readList (scanner);
        int sum = 0;
        for (Integer integer : integerList) {
            sum+=integer;
        }
        Collections.sort(integerList);
        Collections.reverse(integerList);
        double average = (double) sum/integerList.size();
        int counter = 0;
        for (Integer integer : integerList) {
            if(integer>average){
                counter++;
                System.out.print(integer+" ");
            }
            if(counter==5){
                break;
            }
        }
        if(counter==0){
            System.out.println("No");
        }
    }

    private static List<Integer> readList(Scanner scanner) {
        String [] numbersAsStrings = scanner.nextLine().split(" ");
        List <Integer> integerList = new ArrayList<>();
        for (String element : numbersAsStrings) {
            integerList.add(Integer.parseInt(element));
        }
        return integerList;
    }
}
