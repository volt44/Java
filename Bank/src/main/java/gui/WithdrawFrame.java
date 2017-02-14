package gui;

import bank.Account;
import main.BankState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WithdrawFrame extends JFrame {

    private BankState bankState;

    private JPanel fieldsPanel;
    private JPanel buttonPanel;

    private JLabel fromAccountLabel;
    private JLabel amountLabel;

    private JComboBox fromAccountComboBox;

    private JTextField amountTextField;

    private JButton withdrawButton;
    private JButton cancelButton;

    public WithdrawFrame(BankState bankState) {
        super();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(new Dimension(400, 250));

        this.bankState = bankState;

        prepareGUI();
    }

    public void prepareGUI() {

        this.setTitle("Withdraw");
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);

        fieldsPanel =  new JPanel();
        fieldsPanel.setLayout(new GridLayout(2,2));

        fromAccountLabel = new JLabel("From Account :");
        fromAccountLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        fromAccountComboBox = new JComboBox();

        for (Account account : bankState.getAccountList()) {
            fromAccountComboBox.addItem(account);
        }

        amountLabel = new JLabel("Amount :");
        amountLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        amountTextField = new JTextField();

        withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                WithdrawFrame.this.dispose();
            }
        });

        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                WithdrawFrame.this.dispose();
            }
        });

        buttonPanel =  new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        buttonPanel.add(withdrawButton);
        buttonPanel.add(cancelButton);

        fieldsPanel.add(fromAccountLabel);
        fieldsPanel.add(fromAccountComboBox);

        fieldsPanel.add(amountLabel);
        fieldsPanel.add(amountTextField);

        this.add(fieldsPanel, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.CENTER);


        this.setVisible(true);

    }
}
