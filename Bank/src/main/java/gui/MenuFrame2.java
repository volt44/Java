package gui;

import main.BankState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;

public class MenuFrame2 extends JFrame {

    private BankState bankState;

    private JMenu loadSubMenu;
    private JMenu saveSubMenu;

    private JMenuItem chooseFileSaveMenuItem;
    private JMenuItem chooseFileLoadMenuItem;

    private JPanel titlePanel;
    private JPanel buttonPanel;
    private JPanel tablePanel;

    private JTable displayTable;

    private JFileChooser loadFileChooser;
    private JFileChooser saveFileChooser;

    private JButton withdrawButton;
    private JButton depositButton;
    private JButton exitButton;
    private JButton addClientButton;
    private JButton addAccountButton;

    public MenuFrame2(BankState bankState) {
        super();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(new Dimension(600,450));
        this.setLocationRelativeTo(null);

        this.bankState = bankState;

        prepareGUI();

    }

    public void prepareGUI() {

        this.setTitle("Main Menu");
        this.setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        menuBar.add(fileMenu);

        this.setJMenuBar(menuBar);

        loadSubMenu = new JMenu("Load");
        loadSubMenu.setMnemonic(KeyEvent.VK_L);

        chooseFileLoadMenuItem = new JMenuItem("Choose Load File");
        chooseFileLoadMenuItem.addActionListener(e -> loadFileChooser.showOpenDialog(MenuFrame2.this));
        loadSubMenu.add(chooseFileLoadMenuItem);

        fileMenu.add(loadSubMenu);


        saveSubMenu = new JMenu("Save");
        saveSubMenu.setMnemonic(KeyEvent.VK_S);

        chooseFileSaveMenuItem = new JMenuItem("Choose Save File");
        chooseFileSaveMenuItem.addActionListener(e -> saveFileChooser.showOpenDialog(MenuFrame2.this));

        saveSubMenu.add(chooseFileSaveMenuItem);
        fileMenu.add(saveSubMenu);

//        JMenuItem newMenuItemLoad = new JMenuItem("Load", KeyEvent.VK_L);
//        fileMenu.add(newMenuItemLoad);
//        newMenuItemLoad.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                loadFileChooser.getSelectedFile();
//                File file = loadFileChooser.getSelectedFile();
//
//                try {
//                    ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
//
//                    BankState loadedState = (BankState)in.readObject();
//                    bankState = loadedState;
//
//                    in.close();
//                } catch (FileNotFoundException ex){
//                    System.out.println("File Not Found.");
//                } catch (IOException ex) {
//                    System.out.println("I/O Error");
//                } catch (ClassNotFoundException ex) {
//                    System.out.println("Class not Found");
//                }
//            }
//        });
//
//        JMenuItem newMenuItemSave = new JMenuItem("Save", new ImageIcon("images/save.png"));
//        fileMenu.add(newMenuItemSave);
//        newMenuItemLoad.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                saveFileChooser.getSelectedFile();
//                File file = saveFileChooser.getSelectedFile();
//
//                try {
//                    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
//
//                    out.writeObject(bankState);
//
//                    out.close();
//                } catch (FileNotFoundException ex){
//                    System.out.println("File Not Found.");
//                } catch (IOException ex) {
//                    System.out.println("I/O Error");
//                }
//            }
//        });

        fileMenu.addSeparator();
        JMenuItem newMenuItemExit = new JMenuItem("Exit", KeyEvent.VK_E);
        fileMenu.add(newMenuItemExit);
        newMenuItemExit.addActionListener(e -> System.exit(0));

        titlePanel =  new JPanel();
        titlePanel.setLayout(new FlowLayout());

//        tablePanel = new JPanel();
//        tablePanel.setLayout(new GridLayout());
//
//        String[] columnNames = {"First Name", "Last Name", "Account Number", "Balance"};
//        Object[][] data = {
//                {"John","Doe","1234","213.00"},
//                {"Macy","Deed","3256","450.00"},
//                {"John","Doe","1234","213.00"},
//                {"Macy","Deed","3256","450.00"},
//        };
//        displayTable = new JTable(data, columnNames);
//        displayTable.setPreferredScrollableViewportSize(new Dimension(500,150));
//        displayTable.setFillsViewportHeight(true);
//        displayTable.setAutoCreateRowSorter(true);
//
//        JScrollPane scrollPane = new JScrollPane(displayTable);
//        tablePanel.add(scrollPane);

        saveFileChooser = new JFileChooser();
        loadFileChooser = new JFileChooser();

        withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(actionEvent -> new WithdrawFrame(bankState));

        depositButton = new JButton("Deposit");
        depositButton.addActionListener(actionEvent -> new DepositFrame(bankState));

        exitButton = new JButton("Exit", new ImageIcon("images/exit.png"));
        exitButton.addActionListener(actionEvent -> System.exit(0));

        addAccountButton = new JButton("Add Account");
        addAccountButton.addActionListener(actionEvent -> new AddAccountFrame(bankState));

        addClientButton = new JButton("Add Client");
        addClientButton.addActionListener(e -> new AddClientFrame(bankState));

        buttonPanel =  new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        titlePanel.add(new JLabel("Welcome to the Bank."));
//        tablePanel.add(displayTable);
        buttonPanel.add(addClientButton);
        buttonPanel.add(addAccountButton);
        buttonPanel.add(withdrawButton);
        buttonPanel.add(depositButton);
        buttonPanel.add(exitButton);



        this.add(titlePanel, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.CENTER);
//        this.add(tablePanel, BorderLayout.SOUTH);

        this.setVisible(true);

    }

}


