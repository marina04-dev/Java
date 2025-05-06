// OptionMenu.java
package ATM;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

/* Main Class */
public class OptionMenu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    // Validate Login Information Customer Number & Pin Number

    public void getLogin() throws IOException {
        int x = 1;

        do {
            try {
                data.put(9876543, 9876);
                data.put(8989898, 1890);

                System.out.println("Welcome To The ATM Application!");

                System.out.print("Enter Your Customer Number: ");
                setCustomerNumber(menuInput.nextInt());

                System.out.print("Enter Your Pin Number: ");
                setPinNumber(menuInput.nextInt());
            } catch (Exception e) {
                System.out.println("\n" + "Invalid Character(s). Only Numbers Please.\n");
                menuInput.nextLine(); // Consume the invalid input
                x = 1; // Stay in the loop
                continue; // Go to the next iteration
            }

            boolean loginSuccessful = false;
            for (Entry<Integer, Integer> entry : data.entrySet()) {
                if (entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber()) {
                    getAccountType();
                    loginSuccessful = true;
                    return; // Exit the method after successful login
                }
            }

            if (!loginSuccessful) {
                System.out.println("\nWrong Customer Number Or Pin Number\n");
            }

        } while (x == 1);
    }

    // Display Account Type Menu With Selections

    public void getAccountType() {
        System.out.println("Select The Account You Want To Access: ");
        System.out.println("1 - Checking Account");
        System.out.println("2 - Saving Account");
        System.out.println("0 - Exit");
        System.out.print("Please Enter The Number Of Your Choice: ");

        int selection = menuInput.nextInt(); // Local variable

        switch (selection) {
            case 1:
                getChecking();
                break;
            case 2:
                getSaving();
                break;
            case 0:
                System.out.println("Thanks For Using Our ATM Application!");
                break;
            default:
                System.out.println("\nInvalid Choice!\n");
                getAccountType();
        }

    }

    // Display Checking Account Menu With Selections

    public void getChecking() {
        System.out.println("Checking Account Menu");
        System.out.println("1 - View Balance");
        System.out.println("2 - Withdraw Funds");
        System.out.println("3 - Deposit Funds");
        System.out.println("0 - Exit");
        System.out.print("Please Enter The Number Of Your Choice: ");

        int selection = menuInput.nextInt(); // Local variable

        switch (selection) {
            case 1:
                System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
                getAccountType();
                break;
            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;
            case 0:
                System.out.println("Thanks For Using Our ATM Application!");
                break;
            default:
                System.out.println("\nInvalid Choice!\n");
                getChecking();
        }
    }

    // Display Saving Account Menu With Selections

    public void getSaving() {
        System.out.println("Saving Account Menu");
        System.out.println("1 - View Balance");
        System.out.println("2 - Withdraw Funds");
        System.out.println("3 - Deposit Funds");
        System.out.println("0 - Exit");
        System.out.print("Please Enter The Number Of Your Choice: ");

        int selection = menuInput.nextInt(); // Local variable

        switch (selection) {
            case 1:
                System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;
            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getSavingDepositInput();
                getAccountType();
                break;
            case 0:
                System.out.println("Thanks For Using Our ATM Application!");
                break;
            default:
                System.out.println("\nInvalid Choice!\n");
                getSaving();
        }
    }
}