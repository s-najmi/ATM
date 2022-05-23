import java.util.Date;

public abstract class Transaction {
    private Date dateTr;
    private long trace;
    private long terminalCode;
    private long amount;
    protected Account account;

    public Transaction(Date dateTr, long trace, long terminalCode, long amount, Account account) {
        this.dateTr = dateTr;
        this.trace = trace;
        this.terminalCode = terminalCode;
        this.amount = amount;
        this.account = account;
    }

    public Date getDateTr() {
        return dateTr;
    }

    public void setDateTr(Date dateTr) {
        this.dateTr = dateTr;
    }

    public long getTrace() {
        return trace;
    }

    public void setTrace(long trace) {
        this.trace = trace;
    }

    public long getTerminalCode() {
        return terminalCode;
    }

    public void setTerminalCode(long terminalCode) {
        this.terminalCode = terminalCode;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "dateTr=" + dateTr +
                ", trace=" + trace +
                ", terminalCode=" + terminalCode +
                ", amount=" + amount +
                '}';
    }

    public abstract void operate() throws Exception;
    public void addTransaction(){
        if(account.countTransaction == 10){
            account.shiftArray();
            account.countTransaction=9;
        }
        account.setTransactions(this, account.countTransaction);
        account.countTransaction++;
    }
}
