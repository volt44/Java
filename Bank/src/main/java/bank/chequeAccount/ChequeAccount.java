package bank.chequeAccount;

import bank.Account;

public abstract class ChequeAccount extends Account {

    public ChequeAccount(double accountBalance) {
        super(accountBalance);
    }

    private static String accountType = "Cheque";

    public abstract int getBaseTransFee();

}
