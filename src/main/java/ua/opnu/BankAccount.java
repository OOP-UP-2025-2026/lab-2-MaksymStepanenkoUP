package ua.opnu;

public class BankAccount {

    /**
     * Account balance.
     */
    double balance;

    /**
     * The amount of the commission that is deducted from the balance
     * each time a bank client withdraws money from the account.
     */
    double transactionFee = 0;

     void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount - transactionFee;
        }
    }

    double getBalance() {
        return this.balance;
    }

    boolean withdraw(double amount) {
        if ((amount > 0) && (balance > amount + transactionFee)) {
            balance = balance - amount - transactionFee;
            return true;
        }
        else {
            return false;
        }
    }

    boolean transfer(BankAccount receiver, double amount) {
        if ((amount > 0) && (getBalance() >= amount + this.transactionFee)) {
            this.balance = getBalance() - amount - this.transactionFee;
            receiver.balance += amount;
            return true;
        }
        return false;
    }
}