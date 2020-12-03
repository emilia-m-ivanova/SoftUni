import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder input = new StringBuilder(scanner.nextLine());
        int counter = 0;
        int strength = 0;
        while(counter<input.length()){
            char current = input.charAt(counter);
            if(current=='>'){
                strength += Integer.parseInt(String.valueOf(input.charAt(counter+1)));
                counter++;
            }else if (strength==0){
                counter++;
            }else if(strength>0){
                input.delete(counter,counter+1);
                strength--;
            }
        }

        System.out.println(input);
    }
}
