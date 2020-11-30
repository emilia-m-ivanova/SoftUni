import java.util.Scanner;

public class Aquapark {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String month = scanner.nextLine();
        int hours = Integer.parseInt(scanner.nextLine());
        int people = Integer.parseInt(scanner.nextLine());
        String time = scanner.nextLine();
        double pricePerPerson = 0;

        switch (month) {
            case "march":
            case "april":
            case "may":
                switch (time) {
                    case "day":
                        pricePerPerson = 10.50;
                        break;
                    case "night":
                        pricePerPerson = 8.4;
                        break;
                }
                break;
            case "june":
            case "july":
            case "august":
                switch (time){
                    case "day":
                        pricePerPerson = 12.60;
                        break;
                    case "night":
                        pricePerPerson = 10.20;
                        break;
                }
                break;
        }
        if(people>=4){
            pricePerPerson-=pricePerPerson*10*0.01;
        }
        if(hours>=5){
            pricePerPerson=pricePerPerson/2;
        }
        double priceTotal = (pricePerPerson*hours)*people;
        System.out.printf("Price per person for one hour: %.2f%nTotal cost of the visit: %.2f",pricePerPerson,priceTotal);
    }

}
