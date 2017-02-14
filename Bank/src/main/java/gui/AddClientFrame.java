package gui;

import bank.Account;
import bank.Client;
import main.BankState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class AddClientFrame extends JFrame {
    private BankState bankState;

    private JPanel fieldsPanel;
    private JPanel buttonPanel;

    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel idNumberLabel;

    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JTextField idNumberTextField;

    private JButton addClientButton;
    private JButton cancelButton;

    public AddClientFrame(BankState bankState) {
        super();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(new Dimension(250, 300));

        this.bankState = bankState;

        prepareGUI();
    }

    public void prepareGUI() {
        this.setTitle("Add Client");
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);

        fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new GridLayout(4, 2));

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        firstNameLabel = new JLabel("First Name :");
        firstNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        firstNameTextField = new JTextField();

        lastNameLabel = new JLabel("Last Name :");
        lastNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        lastNameTextField = new JTextField();

        idNumberLabel = new JLabel("ID Number :");
        idNumberLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        idNumberTextField = new JTextField();

        addClientButton = new JButton("Add Client");
        addClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                StringBuilder errors = new StringBuilder();
                String firstName = "", lastName = "", idNumber = "", depositString = "";
                // Verify First Name
                if (firstNameTextField.getText().isEmpty()) {
                    errors.append("First Name must not be empty.\n");
                } else {
                    firstName = firstNameTextField.getText();
                }
                // Verify Last Name
                if (lastNameTextField.getText().isEmpty()) {
                    errors.append("Last name must not be empty.\n");
                } else {
                    lastName = lastNameTextField.getText();
                }
                // Verify ID Number
                if (!idNumberTextField.getText().matches("\\d{13}")) {
                    errors.append("ID number must be a 13 digit number.\n");
                } else {
                    idNumber = idNumberTextField.getText();
                }
                if (errors.length() > 0) {
                    JOptionPane.showMessageDialog(AddClientFrame.this, errors.toString(), "Error", JOptionPane.WARNING_MESSAGE);
                } else {
                    Client client = null;
                    Account account = null;
                    client = new Client(firstName,lastName,idNumber);
                    bankState.getClientList().add(client);
//                    if(accountTypeComboBox.getSelectedItem().toString().equals("Diamond Cheque")){
//                        account = new DiamondChequeAccount(amount);
//                        bankState.getAccountList().add(account);
                }
            }
        });

        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AddClientFrame.this.dispose();
            }
        });

        fieldsPanel.add(firstNameLabel);
        fieldsPanel.add(firstNameTextField);

        fieldsPanel.add(lastNameLabel);
        fieldsPanel.add(lastNameTextField);

        fieldsPanel.add(idNumberLabel);
        fieldsPanel.add(idNumberTextField);

        buttonPanel.add(addClientButton);
        buttonPanel.add(cancelButton);

        this.add(fieldsPanel, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.CENTER);

        this.setVisible(true);
    }
}
