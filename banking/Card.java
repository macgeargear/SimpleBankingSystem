package banking;

import java.util.*;

public class Card {
    static Random random = new Random();

    private final int[] NUMBER = new int[16];
    private final int[] PIN = new int[4];
    private long balance;

    Card(long balance) {
        this.balance = balance;
    }

    public String getNUMBER() {
        return Arrays.toString(NUMBER).replace("[", "").replace(", ", "").replace("]", "");
    }

    void generateNUMBER() {
        NUMBER[0] = 4;
        for (int i = 1; i < 16; i++) {
            NUMBER[i] = random.nextInt(10);
        }
    }

    public String getPIN() {
        return Arrays.toString(PIN).replace("[", "").replace(", ", "").replace("]", "");
    }

    void generatePIN() {
        for (int i = 0; i < 4; i++) {
            PIN[i] = random.nextInt(10);
        }
    }

    public long getBalance() {
        return balance;
    }
}
