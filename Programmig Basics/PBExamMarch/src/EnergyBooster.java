import java.util.Scanner;

public class EnergyBooster {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fruit = scanner.nextLine();
        String size = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());
        double price = 0;
        switch (fruit) {
            case "Watermelon":
                switch (size) {
                    case "small":
                        price=quantity*56*2;
                        break;
                    case "big":
                        price=quantity*28.7*5;
                        break;
                }
                break;
            case "Mango":
                switch (size) {
                    case "small":
                        price=quantity*36.66*2;
                        break;
                    case "big":
                        price=quantity*19.6*5;
                        break;
                }
                break;
            case "Pineapple":
                switch (size) {
                    case "small":
                        price=quantity*42.1*2;
                        break;
                    case "big":
                        price=quantity*24.8*5;
                        break;
                }
                break;
            case "Raspberry":
                switch (size) {
                    case "small":
                        price=quantity*20*2;
                        break;
                    case "big":
                        price=quantity*15.2*5;
                        break;
                }
                break;
        }
        if (price>1000){
            price=price -price*50*0.01;
        }else if(price>=400){
            price = price-price*15*0.01;
        }
        System.out.printf("%.2f lv.",price);
    }
}
