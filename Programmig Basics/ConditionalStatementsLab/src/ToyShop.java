import java.util.Scanner;

public class ToyShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double vacationPrice = Double.parseDouble(scanner.nextLine());
        int puzzles = Integer.parseInt(scanner.nextLine());
        int dolls = Integer.parseInt(scanner.nextLine());
        int teddies = Integer.parseInt(scanner.nextLine());
        int minions = Integer.parseInt(scanner.nextLine());
        int trucks = Integer.parseInt(scanner.nextLine());
        double earning = (puzzles*2.6)+(dolls*3)+(teddies*4.1)+(minions*8.2)+(trucks*2);
        int toys = puzzles+dolls+teddies+minions+trucks;
        if(toys>=50){
           earning=earning-(earning*25*0.01);
        }
        earning = earning-(earning*10*0.01);
        double diff = Math.abs(earning-vacationPrice);
        if (earning>=vacationPrice){
            System.out.printf("Yes! %.2f lv left.",diff);
        }
        else {
            System.out.printf("Not enough money! %.2f lv needed.",diff);
        }
    }
}
