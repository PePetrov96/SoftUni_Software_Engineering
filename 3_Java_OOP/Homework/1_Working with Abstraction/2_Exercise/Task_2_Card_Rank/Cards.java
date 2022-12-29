import java.util.Arrays;

public class Cards {
    enum Suits {
        CLUBS(0), DIAMONDS(1), HEARTS(2), SPADES(3);
        private final int value;
        Suits(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
    enum Ranks {
        ACE(0), TWO(1), THREE(2), FOUR(3), FIVE(4), SIX(5),
        SEVEN(6), EIGHT(7), NINE(8), TEN(9), JACK(10),
        QUEEN(11), KING(12);

        private final int value;

        Ranks(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
