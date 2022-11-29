package banking;

import java.util.Scanner;

public class Display {
    static Scanner scanner = new Scanner(System.in);
    static Database database = new Database();
    static Card customerCard;

    static void launchMainMenu() {
        while (true) {
            System.out.println("\n1. Create an account\n2. Log in to account\n0. Exit");
            switch (scanner.nextInt()) {
                case 1:
                    int i = database.getCustomerCounter();
                    database.createAccount();
                    System.out.printf("\nYour card has been ceratecd\nYour card number:\n%s\nYour card PIN:\n%s\n",
                            database.getCARDS()[i].getNUMBER(), database.getCARDS()[i].getPIN());
                    break;
                case 2:
                    launchLoginMenu();
                    break;
                case 0:
                    System.out.println("Bye!");
                    return;
            }
        }
    }

    static void launchLoginMenu() {
        if (customerCard == null) {
            System.out.println("\nEnter your cared number:");
            String enteredNumber = scanner.next();
            System.out.println("Enter your PIN:");
            String enteredPIN = scanner.next();
            customerCard = database.verifyAccount(enteredNumber, enteredPIN);
        }
        if (customerCard != null) {
            System.out.println("You have successfully logged in");
            launchCustomerMenu();
        } else {
            System.out.println("Wrong card number or PIN");
        }
    }

    static void launchCustomerMenu() {
        while (true) {
            System.out.println("1. Balance\n2. Log out\n0. Exit");
            switch (scanner.nextInt()) {
                case 1:
                    System.out.printf("Balacne: %d\n", customerCard.getBalance());
                    break;
                case 2:
                    System.out.println("YOu have successfully logged out");
                    customerCard = new Card(0);
                    // customerCard = null;
                case 0:
                    return;

            }
        }
    }
}
