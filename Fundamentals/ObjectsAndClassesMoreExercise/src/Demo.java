import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] array = input.split("");
        int longest = 1;
        String output = "";
        for (int i = 0; i < array.length - 1; i++) {
            int currentPalindrom = 1;
            String currentLongest = "";
            int currentOdd = 1;
            String oddString = "";
            int currentEven = 0;
            String evenString = "";
            for (int j = 1; j < array.length - 1; j++) {
                int left = i - j;
                int right = i + j;
                if (left >= 0 && right < array.length - 1) {
                    if (array[left].equals(array[right])) {
                        currentOdd += 2;
                        oddString = "";
                        for (int k = left; k <= right; k++) {
                            oddString += array[k];
                        }
                        if (currentOdd > currentPalindrom) {
                            currentPalindrom = currentOdd;
                            currentLongest = oddString;
                        }
                    }else{
                        break;
                    }
                } else {
                    break;
                }
            }
            if (array[i + 1].equals(array[i])) {
                for (int j = 0; j < array.length; j++) {
                    int left = i - j;
                    int right = i + j + 1;
                    if (left >= 0 && right < array.length) {
                        if (array[left].equals(array[right])) {
                            evenString="";
                            currentEven += 2;
                            for (int k = left; k <= right; k++) {
                                evenString += array[k];
                            }
                            if (currentEven > currentPalindrom) {
                                currentPalindrom = currentEven;
                                currentLongest = evenString;
                            }
                        } else {
                            break;
                        }
                    }else{
                        break;
                    }
                }
            }
            if (currentPalindrom > longest) {
                longest = currentPalindrom;
                output = currentLongest;
            }
        }
        System.out.println(longest);
        System.out.println(output);
    }
}
