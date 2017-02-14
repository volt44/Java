package bank.chequeAccount;

import bank.Account;


public class GoldChequeAccount extends ChequeAccount {
    public int freeTrans = 10;

    public GoldChequeAccount(double accountBalance) {
        super(accountBalance);
    }

    @Override
    public void endOfMonth() {

    }

    @Override
    public int getBaseTransFee() {
        return 5;
    }

    public int getFreeTrans() {
        return freeTrans;
    }

    @Override
    public String toString() {
        return "Gold Cheque\t\t\t\t\t\t\t\t\t-\t\t" + accountNumber +  "\t\t-\t\t R" + accountBalance;
    }
}
