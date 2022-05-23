import java.util.Date;

public class Withdrawal extends Transaction {
    public Withdrawal(Date dateTr, long trace, long terminalCode, long amount, Account account) {
        super(dateTr, trace, terminalCode, amount, account);
    }

    @Override
    public void operate() throws Exception {
        if (account.getBalance() < getAmount()) {
            throw new Exception("Not enough balance");
        } else {
            long currentAmount = account.getBalance();
            long newAmount = currentAmount - getAmount();
            account.setBalance(newAmount);
            addTransaction();
        }
    }
}
