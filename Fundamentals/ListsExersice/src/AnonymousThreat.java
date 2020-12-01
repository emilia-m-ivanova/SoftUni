import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> stringList = new ArrayList<>();
        String[] stringArray = scanner.nextLine().split("\\s+");
        for (String element : stringArray) {
            stringList.add(element);
        }
        String command = scanner.nextLine();
        while (!command.equals("3:1")) {
            String[] tokens = command.split("\\s+");
            switch (tokens[0]) {
                case "merge":
                    mergeListElements(stringList, tokens);
                    break;
                case "divide":
                    divideListElements(stringList, tokens);
                    break;
            }

            command = scanner.nextLine();
        }
        System.out.println(String.join(" ",stringList));

    }

    private static void divideListElements(List<String> stringList, String[] tokens) {
        int index = Integer.parseInt(tokens[1]);
        int partitions = Integer.parseInt(tokens[2]);
        String element = stringList.get(index);
        if(partitions==0||partitions>element.length()){
            return;
        }
        int length = element.length()/partitions;
        stringList.remove(index);
        for (int i = 0; i < partitions; i++) {
            String newElement = "";
            int counter =0;
            for (int j = i*length; j <element.length() ; j++) {
                newElement+=String.valueOf(element.charAt(j));
                counter++;
                if(counter==length){
                    break;
                }
            }
            stringList.add(index+i,newElement);
        }
        if(element.length()%partitions!=0){
            int remainder = element.length()%partitions;
            int remainderIndex = element.length()-remainder;
            String lastElement = stringList.get(index+partitions-1);
            for (int i = remainderIndex; i <element.length() ; i++) {
                lastElement+=String.valueOf(element.charAt(i));
            }
            stringList.set(index+partitions-1,lastElement);
        }
    }

    private static void mergeListElements(List<String> stringList, String[] tokens) {
        int startIndex = Integer.parseInt(tokens[1]);
        int endIndex = Integer.parseInt(tokens[2]);
        if (endIndex > stringList.size() - 1) {
            endIndex = stringList.size() - 1;
        }
        if(startIndex<0){
            startIndex=0;
        }
        for (int i = 0; i < endIndex - startIndex; i++) {
            String concatenatedElement = stringList.get(startIndex) + stringList.get(startIndex + 1);
            stringList.set(startIndex, concatenatedElement);
            stringList.remove(startIndex + 1);
        }
    }
}
