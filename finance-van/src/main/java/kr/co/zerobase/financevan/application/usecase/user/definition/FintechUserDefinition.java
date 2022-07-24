package kr.co.zerobase.financevan.application.usecase.user.definition;

import kr.co.zerobase.financevan.domain.bank.BankCorp;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Author Heli
 */
public class FintechUserDefinition {

    private final long id;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;
    private final BankCorp bank;
    private final String bankAccountId;
    private final LocalDate birthday;
    private final String fintechUserNum;

    public FintechUserDefinition(long id, LocalDateTime createdAt, LocalDateTime modifiedAt, BankCorp bank, String bankAccountId, LocalDate birthday, String fintechUserNum) {
        this.id = id;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.bank = bank;
        this.bankAccountId = bankAccountId;
        this.birthday = birthday;
        this.fintechUserNum = fintechUserNum;
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

    public String getBankAccountId() {
        return bankAccountId;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getFintechUserNum() {
        return fintechUserNum;
    }
}
