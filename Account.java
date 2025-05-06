// Account.java
package ATM;

import java.text.DecimalFormat;
import java.util.Scanner; // Import Scanner

public class Account {
    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0;
    private double savingBalance = 0;

    // Set The Customer's Number
    public int setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
        return customerNumber;
    }

    // Get The Customer's Number
    public int getCustomerNumber() {
        return customerNumber;
    }

    // Set Pin Number
    public int setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
        return pinNumber;
    }

    // Get Pin Number
    public int getPinNumber() {
        return pinNumber;
    }

    // Get Saving Account Balance
    public double getSavingBalance() {
        return savingBalance;
    }

    // Calculate Checking Account Withdrawal
    public double calcCheckingWithdraw(double amount) {
        checkingBalance = (checkingBalance - amount);
        return checkingBalance;
    }

    // Calculate Saving Account Withdrawal
    public double calcSavingWithdraw(double amount) {
        savingBalance = (savingBalance - amount);
        return savingBalance;
    }

    // Calculate Checking Account Deposit
    public double calcCheckingDeposit(double amount) {
        checkingBalance = (checkingBalance + amount);
        return checkingBalance;
    }

    // Calculate Saving Account Deposit
    public double calcSavingDeposit(double amount) {
        savingBalance = (savingBalance + amount);
        return savingBalance;
    }

    // Customer Checking Account Withdraw Input
    public void getCheckingWithdrawInput() {
        System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.print("Enter The Amount You Want To Withdraw From Your Checking Account: ");
        double amount = input.nextDouble();

        if ((checkingBalance - amount) >= 0) {
            calcCheckingWithdraw(amount);
            System.out.println("New Checking Account Balance: " + moneyFormat.format(checkingBalance));
        } else {
            System.out.println("Balance Cannot Be Negative.\n");
        }
    }

    // Customer Saving Account Withdraw Input
    public void getSavingWithdrawInput() {
        System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.print("Enter The Amount You Want To Withdraw From Your Saving Account: ");
        double amount = input.nextDouble();

        if ((savingBalance - amount) >= 0) {
            calcSavingWithdraw(amount);
            System.out.println("New Saving Account Balance: " + moneyFormat.format(savingBalance));
        } else {
            System.out.println("Balance Cannot Be Negative.\n");
        }
    }

    // Customer Checking Account Deposit Input
    public void getCheckingDepositInput() {
        System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.print("Enter The Amount You Want To Deposit To Your Checking Account: "); // Corrected prompt
        double amount = input.nextDouble();

        if ((checkingBalance + amount) >= 0) {
            calcCheckingDeposit(amount);
            System.out.println("New Checking Account Balance: " + moneyFormat.format(checkingBalance));
        } else {
            System.out.println("Balance Cannot Be Negative.\n");
        }
    }

    // Customer Saving Account Deposit Input
    public void getSavingDepositInput() {
        System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.print("Enter The Amount You Want To Deposit To Your Saving Account: "); // Corrected prompt
        double amount = input.nextDouble();

        if ((savingBalance + amount) >= 0) { // Corrected condition
            calcSavingDeposit(amount);
            System.out.println("New Saving Account Balance: " + moneyFormat.format(savingBalance));
        } else {
            System.out.println("Balance Cannot Be Negative.\n");
        }
    }
}