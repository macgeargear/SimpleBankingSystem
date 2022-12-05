package banking;

public class Database {

    private int customerCounter = 0;
    private final Card[] CARDS = new Card[1000000];

    public int getCustomerCounter() {
        return customerCounter;
    }

    public Card[] getCARDS() {
        return CARDS;
    }

    void createAccount() {
        CARDS[customerCounter] = new Card(0);
        CARDS[customerCounter].generateNUMBER();
        CARDS[customerCounter].generatePIN();

        for (int i = 0; i < CARDS.length; i++) {
            if (CARDS[customerCounter].getNUMBER().equals(CARDS[i].getNUMBER()) && i != customerCounter
                    && CARDS[i] != null) {
                CARDS[customerCounter].generateNUMBER();
                // check again
                i = 0;
            } else {
                customerCounter++;
                break;
            }
        }
    }

    Card verifyAccount(String enterdNumber, String enteredPIN) {
        for (Card card : CARDS) {
            if (card != null && card.getNUMBER().equals(enterdNumber) && card.getPIN().equals(enteredPIN)) {
                return card;
            }
        }
        return null;
    }
}
