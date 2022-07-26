package kr.co.zerobase.financevan.domain.bank;

import kr.co.zerobase.financevan.configuration.jpa.BaseEntity;
import kr.co.zerobase.financevan.domain.bank.exception.NotEnoughBalanceException;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

/**
 * @Author Heli
 */
@Entity
@Table(name = "bank_account")
public class BankAccount extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "bank", nullable = false)
    private BankCorp bank = BankCorp.SHINHAN;

    @Column(name = "account_id", nullable = false)
    private String accountId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @Column(name = "balance", nullable = false)
    private long balance;

    public static BankAccount create(String name, LocalDate birthday) {
        return create(UUID.randomUUID().toString(), name, birthday);
    }

    public static BankAccount create(String accountId, String name, LocalDate birthday) {
        return new BankAccount(accountId, name, birthday, 0);
    }

    public BankAccount increaseBalance(long balance) {
        this.balance += balance;
        return this;
    }

    public BankAccount decreaseBalance(long balance) {
        if (this.balance - balance < 0) {
            throw new NotEnoughBalanceException(this.bank, this.accountId, this.balance, balance);
        }
        this.balance -= balance;
        return this;
    }

    private BankAccount(String accountId, String name, LocalDate birthday, long balance) {
        this.accountId = accountId;
        this.name = name;
        this.birthday = birthday;
        this.balance = balance;
    }

    public BankCorp getBank() {
        return bank;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public long getBalance() {
        return balance;
    }

    protected BankAccount() {
    }
}
