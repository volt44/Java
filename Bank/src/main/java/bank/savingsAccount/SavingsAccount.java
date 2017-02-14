package bank.savingsAccount;

import bank.Account;

public abstract class SavingsAccount extends Account {

    public SavingsAccount(double accountBalance, double interest) {
        super(accountBalance);
        this.interest = interest;
    }

    private static String accountType = "Savings";


    protected double interest;

    public abstract double getBaseInterest();

    public SavingsAccount(double accountBalance){
        super(accountBalance);
    }

    public abstract int getBaseTransFee();
}
