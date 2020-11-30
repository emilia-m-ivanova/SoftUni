import java.util.Scanner;

public class Coins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double money = Double.parseDouble(scanner.nextLine());
        int coins = (int) (money*100);
        int coin2lv = 0;
        int coin1lv = 0;
        int coin50 = 0;
        int coin20=0;
        int coin10=0;
        int coin5 = 0;
        int coin2=0;
        int coin1 = 0;
        while (coins>0){
            if(coins>=200){
                coin2lv++;
                coins-=200;
            } else if(coins>=100){
                coin1lv++;
                coins -=100;
            } else if(coins>=50){
                coin50++;
                coins-=50;
            } else if(coins>=20){
                coin20++;
                coins-=20;
            }else if(coins>=10){
                coin10++;
                coins-=10;
            } else if(coins>=5){
                coin5++;
                coins-=5;
            }else if(coins>=2){
                coin2++;
               coins-=2;
            }else if(coins>=1){
                coin1++;
                coins-=1;
            }
        } int result = coin2lv+coin1lv+coin1+coin2+coin5+coin10+coin20+coin50;
        System.out.println(result);
    }
}
