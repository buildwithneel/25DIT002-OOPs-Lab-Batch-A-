import java.util.Objects;

public class Card {
    private String rank;
    private String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Card))
            return false;

        Card other = (Card) obj;

        return rank.equals(other.rank) && suit.equals(other.suit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }
}