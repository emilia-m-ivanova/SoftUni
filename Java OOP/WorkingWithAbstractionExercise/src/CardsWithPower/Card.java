package CardsWithPower;

public class Card {

    private RankPower rankPower;
    private SuitPower suitPower;

    public Card(RankPower rankPower, SuitPower suitPower) {
        this.rankPower = rankPower;
        this.suitPower = suitPower;
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d",this.rankPower, this.suitPower,
                this.suitPower.getValue() + this.rankPower.getValue());
    }
}
