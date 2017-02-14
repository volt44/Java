package main;

import bank.Account;
import bank.Client;
import bank.chequeAccount.DiamondChequeAccount;
import bank.chequeAccount.GoldChequeAccount;
import bank.savingsAccount.GreenSavingsAccount;
import bank.savingsAccount.InvestedSavingsAccount;
import gui.MenuFrame2;

import java.util.List;

public abstract class Main extends Account {

    public static void main(String[] args) {

        Account myCheque = new DiamondChequeAccount(9000.00);
        Account myGold = new GoldChequeAccount(9000.00);
        Account myInvested = new InvestedSavingsAccount(9000.00);
        Account myGreen = new GreenSavingsAccount(9000.00);

        Client myClientJohn = new Client("John","Fisher","8208123456251");
        Client myClientClarice = new Client("Clarice","Mitts","6103189347581");

        BankState bankState = new BankState();
        bankState.getAccountList().add(myCheque);
        bankState.getAccountList().add(myGold);
        bankState.getAccountList().add(myInvested);
        bankState.getAccountList().add(myGreen);

        bankState.getClientList().add(myClientJohn);
        bankState.getClientList().add(myClientClarice);
        new MenuFrame2(bankState);
    }
}




