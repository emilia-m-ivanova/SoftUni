import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double moneyTrip = Double.parseDouble(scanner.nextLine());
        double moneySaved = Double.parseDouble(scanner.nextLine());
        int daysSpend = 0;
        int daysTotal = 0;
        String prevAction ="";
        while (moneySaved<moneyTrip){
            String action = scanner.nextLine();
            double moneyDay = Double.parseDouble(scanner.nextLine());
            daysTotal++;
            if(action.equals("save")){
                moneySaved+=moneyDay;
            }else{
                if(moneyDay>moneySaved){
                    moneyDay=moneySaved;
                }
                if(prevAction.equals("save")){
                    daysSpend=0;
                }
                moneySaved-=moneyDay;
                daysSpend++;

            }
            if(daysSpend==5){
                System.out.println("You can't save the money.");
                System.out.println(daysTotal);
            break;
            }
            prevAction=action;
        } if(moneySaved>=moneyTrip){
            System.out.printf("You saved the money for %d days.", daysTotal);
        }
    }
}
