public class Cards {
    enum Suits {
        CLUBS(0), DIAMONDS(13), HEARTS(26), SPADES(39);
        private final int value;
        Suits(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
    enum Ranks {
        ACE(14), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6),
        SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11),
        QUEEN(12), KING(13);

        private final int value;

        Ranks(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public static void printPower(Suits suit, Ranks rank) {
        System.out.printf("Card name: %s of %s; Card power: %d", rank, suit, rank.getValue() + suit.getValue());
    }
}
