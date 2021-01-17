package needForSpeed;

public class Main {
    public static void main(String[] args) {
        RaceMotorcycle motorcycle = new RaceMotorcycle(100,200);
        motorcycle.drive(10);
        System.out.println(motorcycle.getFuel());
        motorcycle.drive(50);
        System.out.println(motorcycle.getFuel());
    }
}
