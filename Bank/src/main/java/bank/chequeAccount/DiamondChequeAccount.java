package bank.chequeAccount;

import bank.Account;


public class DiamondChequeAccount extends ChequeAccount {

    public int freeTrans = 20;
    public int currentFreeTrans;
    public int transFee = 7;

    public int getCurrentFreeTrans() {
        return currentFreeTrans;
    }

    public DiamondChequeAccount(double accountBalance) {
        super(accountBalance);
    }

    @Override
    public void endOfMonth() {

    }

    public int checkTransFee(){
        if (currentFreeTrans > 0){
            transFee = 0;
        } else {
            transFee = 7;
        } return transFee;
    }

    @Override
    public int getBaseTransFee() {
        return 7 ;
    }

    public int getFreeTrans(){
        return freeTrans;
    }

    @Override
    public String toString() {
        return "Diamond Cheque\t\t-\t\t" + accountNumber +  "\t\t-\t\t R" + accountBalance;
    }

}
