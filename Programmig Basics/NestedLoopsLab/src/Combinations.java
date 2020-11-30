import java.util.Scanner;

public class Combinations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        for (int i = 0; i <=input ; i++) {
            for (int j = 0; j <=input ; j++) {
                for (int k = 0; k <=input ; k++) {
                    if(i+j+k==input){
                        counter++;
                    }
                }

            }
            
        }
        System.out.println(counter);
    }
}
