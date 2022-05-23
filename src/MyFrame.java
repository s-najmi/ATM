import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
    public static boolean STATUS = false;
    private Container c;
    private JLabel title;
    private JLabel accInfo;
    private JTextField accNumber;
    private JLabel passInfo;
    private JTextField password;
    private JButton sub;
    private JLabel result;
    private Database db;

    public MyFrame(Database db)
    {
        this.db = db;
        setTitle("Login Form");
        setBounds(600, 300, 500, 320);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Please Enter your account number and your password:");
        title.setFont(new Font("Arial", Font.PLAIN, 18));
        title.setSize(500, 30);
        title.setLocation(30, 30);
        c.add(title);

        accInfo = new JLabel("AccountNumber: ");
        accInfo.setFont(new Font("Arial", Font.PLAIN, 16));
        accInfo.setSize(200, 20);
        accInfo.setLocation(30, 100);
        c.add(accInfo);

        accNumber = new JTextField();
        accNumber.setFont(new Font("Arial", Font.PLAIN, 16));
        accNumber.setSize(250, 30);
        accNumber.setLocation(200, 100);
        c.add(accNumber);

        passInfo = new JLabel("Password");
        passInfo.setFont(new Font("Arial", Font.PLAIN, 16));
        passInfo.setSize(200, 20);
        passInfo.setLocation(30, 150);
        c.add(passInfo);

        password = new JPasswordField();
        password.setFont(new Font("Arial", Font.PLAIN, 16));
        password.setSize(250, 30);
        password.setLocation(200, 150);
        c.add(password);

        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 16));
        sub.setSize(430, 30);
        sub.setLocation(30, 200);
        sub.addActionListener(this);
        c.add(sub);

        result = new JLabel("Your login Failed...");
        result.setFont(new Font("Arial", Font.BOLD, 16));
        result.setForeground(Color.RED);
        result.setSize(200, 20);
        result.setLocation(30, 250);
        result.setVisible(false);
        c.add(result);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sub) {
            if((Long.parseLong(accNumber.getText()) == db.getAccount().getAccountID()) && Long.parseLong(password.getText()) == db.getAccount().getPassword()){
                result.setVisible(false);
                STATUS = true;
                dispose();
                ATMFrame atm = new ATMFrame(db);
            }else{
                STATUS = false;
                result.setVisible(true);
            }
        }
    }
}
