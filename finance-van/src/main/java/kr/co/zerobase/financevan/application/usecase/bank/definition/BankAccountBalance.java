package kr.co.zerobase.financevan.application.usecase.bank.definition;

/**
 * @Author Heli
 */
public class BankAccountBalance {

    private final long balance;

    public BankAccountBalance(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "BankAccountBalance{" +
                "balance=" + balance +
                '}';
    }
}
