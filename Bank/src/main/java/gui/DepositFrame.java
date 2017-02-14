package gui;

import bank.Account;
import main.BankState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepositFrame extends JFrame {

    private BankState bankState;

    private JPanel fieldsPanel;
    private JPanel buttonPanel;

    private JLabel toAccountLabel;
    private JLabel amountLabel;

    private JComboBox toAccountComboBox;

    private JTextField amountTextField;

    private JButton depositButton;
    private JButton cancelButton;

    public DepositFrame(BankState bankState) {
        super();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(new Dimension(400, 250));

        this.bankState = bankState;

        prepareGUI();
    }

    public void prepareGUI() {

        this.setTitle("Deposit");
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);

        fieldsPanel =  new JPanel();
        fieldsPanel.setLayout(new GridLayout(2,2));

        toAccountLabel = new JLabel("To Account :");
        toAccountLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        toAccountComboBox = new JComboBox();

        for (Account account : bankState.getAccountList()) {
            toAccountComboBox.addItem(account.getAccountNumber());
        }

        amountLabel = new JLabel("Amount :");
        amountLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        amountTextField = new JTextField();

        depositButton = new JButton("Deposit");
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DepositFrame.this.dispose();
            }
        });

        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DepositFrame.this.dispose();
            }
        });

        buttonPanel =  new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        buttonPanel.add(depositButton);
        buttonPanel.add(cancelButton);

        fieldsPanel.add(toAccountLabel);
        fieldsPanel.add(toAccountComboBox);

        fieldsPanel.add(amountLabel);
        fieldsPanel.add(amountTextField);

        this.add(fieldsPanel, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.CENTER);


        this.setVisible(true);

    }
}
