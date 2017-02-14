package main;

import bank.Account;
import bank.Client;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class BankState implements Serializable {

    private List<Account> accountList;
    private List<Client> clientList;

    public BankState() {
        accountList = new LinkedList<Account>();
        clientList = new LinkedList<Client>();
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    void addClient(Client client){
        clientList.add(client);
    }

    void addAccount(Account account){
        accountList.add(account);
    }

}
