package bank;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Client implements Serializable {

    protected String firstName;
    protected String lastName;
    protected long idNumber = 0000000000000L;
    protected List<Account> accounts;

    public Client(String firstName, String lastName, long idNumber, List accounts){

        this.firstName = firstName;
        this.lastName =  lastName;
        this.idNumber = idNumber;
        this.accounts = new ArrayList<Account>();
    }

    public Client(String firstName, String lastName, String idNumber) {
        this(firstName,lastName, Long.parseLong(idNumber), null);
    }

    @Override
    public String toString(){
        return firstName + " " + lastName + " " + " " + idNumber + accounts;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public long getIdNumber() {
        return idNumber;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

}
