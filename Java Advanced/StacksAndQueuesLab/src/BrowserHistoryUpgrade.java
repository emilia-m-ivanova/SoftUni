import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<String> historyBackwards = new ArrayDeque<>();
        ArrayDeque<String> historyForwards = new ArrayDeque<>();
        String currentURL = "";
        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (historyBackwards.isEmpty()) {
                    System.out.println("no previous URLs");
                } else {
                    historyForwards.push(currentURL);
                    currentURL = historyBackwards.peek();
                    System.out.println(historyBackwards.pop());
                }
            } else if (input.equals("forward")) {
                if(historyForwards.isEmpty()){
                    System.out.println("no next URLs");
                }else{
                    historyBackwards.push(currentURL);
                    currentURL = historyForwards.peek();
                    System.out.println(historyForwards.pop());
                }
            } else {
                if (!currentURL.equals("")) {
                    historyBackwards.push(currentURL);
                }
                historyForwards.clear();
                System.out.println(input);
                currentURL = input;
            }
            input = scanner.nextLine();
        }
    }
}
