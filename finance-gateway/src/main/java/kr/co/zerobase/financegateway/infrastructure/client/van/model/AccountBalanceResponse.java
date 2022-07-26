package kr.co.zerobase.financegateway.infrastructure.client.van.model;

/**
 * @Author Heli
 */
public class AccountBalanceResponse {

    private long balance;

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "AccountBalanceResponse{" +
                "balance=" + balance +
                '}';
    }
}
