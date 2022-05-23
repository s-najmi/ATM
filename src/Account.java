import java.util.Arrays;

public class Account {
    private long accountID;
    private long password;
    private long balance;
    private Transaction[] transactions = new Transaction[10];
    public int countTransaction=0;
    private AccountType accountType;

    public Account(long accountID, long password, long balance, AccountType accountType) {
        this.accountID = accountID;
        this.password = password;
        this.balance = balance;
        this.accountType = accountType;
    }

    public long getAccountID() {
        return accountID;
    }

    public void setAccountID(long accountID) {
        this.accountID = accountID;
    }

    public long getPassword() {
        return password;
    }

    public void setPassword(long password) {
        this.password = password;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public Transaction[] getTransactions() {
        return transactions;
    }

    public void setTransactions(Transaction transactions,int index) {
        this.transactions[index] = transactions;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountID=" + accountID +
                ", password=" + password +
                ", balance=" + balance +
                ", transactions=" + Arrays.toString(transactions) +
                ", accountType=" + accountType +
                '}';
    }

    public void shiftArray(){
        for (int i = 1; i < 10; i++) {
            transactions[i-1] = transactions[i];
        }
    }
}
