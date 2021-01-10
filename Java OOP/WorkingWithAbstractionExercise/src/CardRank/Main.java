package CardRank;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Ranks:");
        for (CardRank value : CardRank.values()) {
            System.out.println("Ordinal value: " + value.ordinal()
                    + "; Name value: " + value.name());
        }
    }
}
