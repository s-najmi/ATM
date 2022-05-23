import java.util.Date;

public class Deposit extends Transaction{

    public Deposit(Date dateTr, long trace, long terminalCode, long amount, Account account) {
        super(dateTr, trace, terminalCode, amount, account);
    }

    @Override
    public void operate(){
            long currentAmount = account.getBalance();
            long newAmount = currentAmount + this.getAmount();
            account.setBalance(newAmount);
            addTransaction();
    }
}
