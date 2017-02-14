package bank.savingsAccount;

public class InvestedSavingsAccount extends SavingsAccount {

    public InvestedSavingsAccount(double accountBalance){
        super(accountBalance);
    }

    @Override
    public void endOfMonth() {
        accountBalance += (accountBalance*getBaseInterest());
    }

    @Override
    public double getBaseInterest() {
        return 1.4;
    }

    @Override
    public int getBaseTransFee() {
        return 50;
    }

    @Override
    public String toString() {
        return "Invested Savings\t\t\t-\t\t" + accountNumber +  "\t\t-\t\t R" + accountBalance;
    }
}
