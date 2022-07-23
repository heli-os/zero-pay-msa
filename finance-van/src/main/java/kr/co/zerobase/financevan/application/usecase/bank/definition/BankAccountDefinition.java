package kr.co.zerobase.financevan.application.usecase.bank.definition;

import kr.co.zerobase.financevan.domain.bank.BankCorp;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Author Heli
 */
public class BankAccountDefinition {

    private final long id;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;
    private final BankCorp bank;
    private final String accountId;
    private final String name;
    private final LocalDate birthday;
    private final long balance;

    public BankAccountDefinition(long id, LocalDateTime createdAt, LocalDateTime modifiedAt, BankCorp bank, String accountId, String name, LocalDate birthday, long balance) {
        this.id = id;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.bank = bank;
        this.accountId = accountId;
        this.name = name;
        this.birthday = birthday;
        this.balance = balance;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
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

    @Override
    public String toString() {
        return "BankAccountDefinition{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                ", bank=" + bank +
                ", accountId='" + accountId + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", balance=" + balance +
                '}';
    }
}
