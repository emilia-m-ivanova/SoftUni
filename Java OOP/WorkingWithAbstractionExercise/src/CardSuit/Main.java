package CardSuit;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Suits:");
        for (CardSuit value : CardSuit.values()) {
            System.out.println("Ordinal value: " + value.ordinal()
                    + "; Name value: " + value.name());
        }
    }
}
