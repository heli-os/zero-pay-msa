package kr.co.zerobase.financevan.domain.bank;

import kr.co.zerobase.financevan.configuration.jpa.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @Author Heli
 */
@Entity
@Table(name = "bank_account")
public class BankAccount extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "bank", nullable = false)
    private BankCorp bank;

    @Column(name = "account_id", nullable = false)
    private String accountId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @Column(name = "balance", nullable = false)
    private long balance;

    public static BankAccount create(BankCorp bank, String accountId, String name, LocalDate birthday, long balance) {
        return new BankAccount(bank, accountId, name, birthday, balance);
    }

    public BankAccount increaseBalance(long balance) {
        this.balance += balance;
        return this;
    }

    public BankAccount decreaseBalance(long balance) {
        this.balance -= balance;
        return this;
    }

    private BankAccount(BankCorp bank, String accountId, String name, LocalDate birthday, long balance) {
        this.bank = bank;
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
