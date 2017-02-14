package bank;


import java.io.Serializable;

public abstract class Account implements Serializable{

    protected long accountNumber;
    protected double accountBalance;

    private static int count = 1000000001;

    public Account(double accountBalance) {


        this.accountNumber = count;
        this.accountBalance = accountBalance;

        count++;
    }

    public Account() {

        accountNumber = count;
//        accountBalance = 10000.00;

        count++;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return accountBalance;
    }

    public void withdraw(double amount){
        if(amount > accountBalance){
            System.out.println("You have insufficient funds.");
            return;
        }
        accountBalance -= amount;
        System.out.println("You have withdrawn R" + amount + " and was charged a fee of R");
        System.out.println("You now have a balance of R" + accountBalance);

    }

    public void deposit(double amount){
        if(amount < 0){
            System.out.println("Please select valid positive amount.");
            return;
        }
        accountBalance += amount;
        System.out.println("You have deposited R" + amount);
        System.out.println("You now have a balance of R" + accountBalance);
    }

    public abstract void endOfMonth();

}
