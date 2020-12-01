import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.nextLine();
        String [] firstArrayAsString = input1.split(" ");
        int [] firstArray = new int[firstArrayAsString.length];
        for (int i = 0; i < firstArray.length; i++) {
            firstArray[i]=Integer.parseInt(firstArrayAsString[i]);
        }
        String input2 = scanner.nextLine();
        String [] secondArrayAsString = input2.split(" ");
        int [] secondArray = new int[secondArrayAsString.length];
        int differenceIndex = -1;
        int sum = 0;
        for (int i = 0; i < secondArray.length; i++) {
            secondArray[i]=Integer.parseInt(secondArrayAsString[i]);
            if(secondArray[i]!=firstArray[i]){
                differenceIndex=i;
                break;
            }else{
                sum+=secondArray[i];
            }
        }
        if(differenceIndex>=0){
            System.out.printf("Arrays are not identical. Found difference at %d index.",differenceIndex);
        }else{
            System.out.printf("Arrays are identical. Sum: %d",sum);
        }
    }
}
