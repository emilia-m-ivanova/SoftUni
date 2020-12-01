import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double money = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double priceLightSaber = Double.parseDouble(scanner.nextLine());
        double priceRobe = Double.parseDouble(scanner.nextLine());
        double priceBelt = Double.parseDouble(scanner.nextLine());
        int freeBelt = students/6;
        int lightSaberMore = (int) Math.ceil(students*1.1);
        double moneyTotal = (priceBelt*(students-freeBelt))+(priceLightSaber*lightSaberMore)+(priceRobe*students);
        if(money>=moneyTotal){
            System.out.printf("The money is enough - it would cost %.2flv.",moneyTotal);
        }else {
            System.out.printf("Ivan Cho will need %.2flv more.",moneyTotal-money);
        }
    }
}
