package kr.co.zerobase.financevan.presentation.api.transaction.model;

/**
 * @Author Heli
 */
public class AccountBalanceResponse {

    private final long balance;

    public AccountBalanceResponse(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }
}
