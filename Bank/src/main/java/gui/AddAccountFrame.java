package gui;

import bank.Account;
import bank.Client;
import bank.SingletonAccountFactory;
import bank.chequeAccount.DiamondChequeAccount;
import bank.chequeAccount.GoldChequeAccount;
import bank.savingsAccount.GreenSavingsAccount;
import bank.savingsAccount.InvestedSavingsAccount;
import main.BankState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class AddAccountFrame extends JFrame {
    private BankState bankState;

    private JPanel fieldsPanel;
    private JPanel buttonPanel;

    private JLabel clientLabel;
    private JLabel accountTypeLabel;
    private JLabel amountLabel;

    private JTextField amountTextField;

    private JComboBox clientComboBox;
    private JComboBox accountTypeComboBox;

    private JButton addAccountButton;
    private JButton cancelButton;

    public AddAccountFrame(BankState bankState) {
        super();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(new Dimension(250,300));

        this.bankState = bankState;

        prepareGUI();

    }

    public void prepareGUI(){
        this.setTitle("Add Account");
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);

        fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new GridLayout(3,2));

        buttonPanel =  new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        clientLabel = new JLabel("Select Client");
        clientLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        clientComboBox = new JComboBox();
        for (Client client : bankState.getClientList()) {
            clientComboBox.addItem(client);
        }

        amountLabel = new JLabel("Amount :");
        amountLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        amountTextField = new JTextField();

        accountTypeLabel = new JLabel("Account :");
        accountTypeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        accountTypeComboBox = new JComboBox();
        SingletonAccountFactory factory = SingletonAccountFactory.getInstance();

        for (String types : factory.getAvailableAccountTypes()){
            accountTypeComboBox.addItem(types);
        }

        addAccountButton = new JButton("Add Account");
        addAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
               StringBuilder errors = new StringBuilder();
                double amount = 0;
                //Verify Amount
                if(amountTextField.getText().isEmpty()) {
                    errors.append("Please enter an amount to be deposited into the account\n");
                } else {
                    try {
                        amount = round(Double.parseDouble(amountTextField.getText()), 2);
                    }
                    catch (NumberFormatException ex){
                        errors.append("Amount must be a number");
                    }
                }
                if(errors.length() > 0){
                    JOptionPane.showMessageDialog(AddAccountFrame.this,errors.toString(),"Error", JOptionPane.WARNING_MESSAGE);
                } else {
//                    JOptionPane.showMessageDialog(AddAccountFrame.this, firstName + "\n" + lastName + "\n" + idNumber + "\n" + amount);
                    Account account = null;
                    if(accountTypeComboBox.getSelectedItem().toString().equals("Diamond Cheque")){
                        account = new DiamondChequeAccount(amount);
                        bankState.getAccountList().add(account);
                        //Client client = the client in the drop down.
                        //client.add(account);
                    } else if(accountTypeComboBox.getSelectedItem().toString().equals("Gold Cheque")){
                        account = new GoldChequeAccount(amount);
                        bankState.getAccountList().add(account);
                    } else if(accountTypeComboBox.getSelectedItem().toString().equals("Green Savings")){
                        account = new GreenSavingsAccount(amount);
                        bankState.getAccountList().add(account);
                    } else if(accountTypeComboBox.getSelectedItem().toString().equals("Invested Savings")){
                        account = new InvestedSavingsAccount(amount);
                        bankState.getAccountList().add(account);
                    }
                }
            }
            private double round(double value, int places){
                if (places < 0) {
                    throw new IllegalArgumentException();
                }
                BigDecimal bd = new BigDecimal(value);
                bd = bd.setScale(places, RoundingMode.FLOOR);
                return bd.doubleValue();
            }

        });

        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AddAccountFrame.this.dispose();
            }
        });

        fieldsPanel.add(clientLabel);
        fieldsPanel.add(clientComboBox);

        fieldsPanel.add(accountTypeLabel);
        fieldsPanel.add(accountTypeComboBox);

        fieldsPanel.add(amountLabel);
        fieldsPanel.add(amountTextField);

        buttonPanel.add(addAccountButton);
        buttonPanel.add(cancelButton);

        this.add(fieldsPanel, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.CENTER);

        this.setVisible(true);
    }
}
