package bank.savingsAccount;


public class GreenSavingsAccount extends SavingsAccount {

    public GreenSavingsAccount(double accountBalance) {
        super(accountBalance);
    }

    @Override
    public void endOfMonth() {


    }

    @Override
    public double getBaseInterest() {
        return 1.2;
    }

    @Override
    public int getBaseTransFee() {
        return 10;
    }

    @Override
    public String toString() {
        return "Green Savings\t\t\t\t\t\t\t-\t\t" + accountNumber +  "\t\t-\t\t R" + accountBalance;
    }
}
