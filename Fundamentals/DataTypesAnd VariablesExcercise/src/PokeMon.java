import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int power = Integer.parseInt(scanner.nextLine());
        double power50Percent = ((double)power)/2;
        int distance = Integer.parseInt(scanner.nextLine());
        int exhaustionFactor = Integer.parseInt(scanner.nextLine());
        int targets = 0;
        while(power>=distance){
            power-=distance;
            if(power==power50Percent&&exhaustionFactor!=0){
                    power=power/exhaustionFactor;
            }
            targets++;
        }
        System.out.println(power);
        System.out.println(targets);
    }
}
