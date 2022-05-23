import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ATMFrame extends JFrame implements ActionListener {
    private Container c;
    private JLabel accInfo;
    private JTextField accNumber;
    private JLabel amountInfo;
    private JTextField amountNumber;
    private JButton deposit;
    private JButton withdrawal;
    private JButton show;
    private JLabel balanceInfo;
    private JLabel balance;
    private Database db;

    public ATMFrame(Database db) {
        this.db = db;
        setTitle("ATM");
        setBounds(700, 300, 350, 270);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        accInfo = new JLabel("Account:");
        accInfo.setFont(new Font("Arial", Font.PLAIN, 16));
        accInfo.setSize(100, 30);
        accInfo.setLocation(30, 15);
        c.add(accInfo);

        accNumber = new JTextField();
        accNumber.setFont(new Font("Arial", Font.PLAIN, 16));
        accNumber.setSize(205, 30);
        accNumber.setLocation(100, 15);
        accNumber.setEnabled(false);
        accNumber.setText(String.valueOf(db.account.getAccountID()));
        c.add(accNumber);

        amountInfo = new JLabel("Amount:");
        amountInfo.setFont(new Font("Arial", Font.PLAIN, 16));
        amountInfo.setSize(100, 30);
        amountInfo.setLocation(30, 50);
        c.add(amountInfo);

        amountNumber = new JTextField();
        amountNumber.setFont(new Font("Arial", Font.PLAIN, 16));
        amountNumber.setSize(205, 30);
        amountNumber.setLocation(100, 50);
        c.add(amountNumber);

        deposit = new JButton("Deposit");
        deposit.setFont(new Font("Arial", Font.BOLD, 20));
        deposit.setSize(140, 40);
        deposit.setLocation(30, 90);
        deposit.addActionListener(this);
        c.add(deposit);

        withdrawal = new JButton("withdrawal");
        withdrawal.setFont(new Font("Arial", Font.BOLD, 20));
        withdrawal.setSize(140, 40);
        withdrawal.setLocation(172, 90);
        withdrawal.addActionListener(this);
        c.add(withdrawal);

        show = new JButton("Last 10 transactions");
        show.setFont(new Font("Arial", Font.BOLD, 20));
        show.setSize(282, 40);
        show.setLocation(30, 135);
        show.addActionListener(this);
        c.add(show);

        balanceInfo = new JLabel("Balance:");
        balanceInfo.setFont(new Font("Arial", Font.PLAIN, 16));
        balanceInfo.setSize(100, 30);
        balanceInfo.setLocation(30, 180);
        c.add(balanceInfo);

        balance = new JLabel("mmmmm");
        balance.setFont(new Font("Arial", Font.PLAIN, 16));
        balance.setSize(100, 30);
        balance.setText(String.valueOf(db.account.getBalance()));
        balance.setForeground(Color.blue);
        balance.setLocation(100, 180);
        c.add(balance);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        long currentAmount = 0;
       try {
           if (e.getSource() != show){
               if (amountNumber.getText().equals("")){
                   throw new Exception("Insert Amount of transaction!");
               } else if (Long.valueOf(amountNumber.getText())<=0){
                   throw new Exception("Insert correct Amount of transaction!");
               }else{
                   currentAmount = Long.parseLong(amountNumber.getText());
               }
           }
           Transaction tr;
           if (e.getSource() == deposit) {
               tr = new Deposit(new Date(), 232323, 1010, currentAmount, db.account);
               tr.operate();
               balance.setText(String.valueOf(db.account.getBalance()));
           } else if (e.getSource() == withdrawal) {
               tr = new Withdrawal(new Date(), 232324, 1010, currentAmount, db.account);
               tr.operate();
               balance.setText(String.valueOf(db.account.getBalance()));
           } else {
               Transaction[] transactions = db.getAccount().getTransactions();
               List<Transaction> list = Arrays.asList(transactions);
               FrmGrid gridTable = new FrmGrid(list);
           }
       }catch(Exception ex){
           System.out.println(ex.getMessage());
       }
    }
}
