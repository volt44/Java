package bank;

import bank.chequeAccount.DiamondChequeAccount;
import bank.chequeAccount.GoldChequeAccount;
import bank.savingsAccount.GreenSavingsAccount;
import bank.savingsAccount.InvestedSavingsAccount;

import java.util.LinkedList;
import java.util.List;

public class SingletonAccountFactory {
    private static SingletonAccountFactory instance = null;

    private  SingletonAccountFactory(){

    }

    public static SingletonAccountFactory getInstance(){
        if (instance == null){
            instance = new SingletonAccountFactory();
        }

        return instance;
    }

    public Account createAccount(String key, double accountBalance){
        if (key.equals("Diamond Cheque")) {
            return new DiamondChequeAccount(accountBalance);
        } else if (key.equals("Gold Cheque")) {
            return new GoldChequeAccount(accountBalance);
        } else if (key.equals("Green Savings")) {
            return new GreenSavingsAccount(accountBalance);
        } else if (key.equals("Invested Savings")) {
            return new InvestedSavingsAccount(accountBalance);
        } else {
            return null;
        }
    }

    public List<String> getAvailableAccountTypes(){
        List<String> types = new LinkedList<String>();

        types.add("Diamond Cheque");
        types.add("Gold Cheque");
        types.add("Green Savings");
        types.add("Invested Savings");

        return types;
    }


}
