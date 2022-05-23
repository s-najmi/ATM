public class Database {
    Account account = new Account(123456789,1234,100000,AccountType.INTEREST_FREE_CURRENT_ACCOUNT);
    Person pr = new Person("Ali","Taghavi",50359659,new Account[] {account});

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Person getPr() {
        return pr;
    }

    public void setPr(Person pr) {
        this.pr = pr;
    }
}
