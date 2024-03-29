import java.util.Arrays;

public class Person {
    private String name;
    private String family;
    private long nationalCode;
    private Account[] accounts;

    public Person(String name, String family, long nationalCode, Account[] accounts) {
        this.name = name;
        this.family = family;
        this.nationalCode = nationalCode;
        this.accounts = accounts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public long getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(long nationalCode) {
        this.nationalCode = nationalCode;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", nationalCode=" + nationalCode +
                ", accounts=" + Arrays.toString(accounts) +
                '}';
    }
}
