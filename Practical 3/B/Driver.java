public class Driver {
    public static void main(String[] args) {

        Card[] cards = new Card[10];
        int count = 0;

        Card[] input = {
            new Card("Ace", "Spades"),
            new Card("King", "Hearts"),
            new Card("Queen", "Diamonds"),
            new Card("Ace", "Spades"),
            new Card("Jack", "Clubs")
        };

        for (Card newCard : input) {

            boolean duplicate = false;

            for (int i = 0; i < count; i++) {
                if (newCard.equals(cards[i])) {
                    duplicate = true;
                    break;
                }
            }
            if (duplicate) {
                System.out.println("Duplicate found: " + newCard);
                break;
            }
            cards[count] = newCard;
            count++;
        }
    }
}