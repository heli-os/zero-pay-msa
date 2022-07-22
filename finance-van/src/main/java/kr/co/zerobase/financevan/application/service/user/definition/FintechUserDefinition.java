package kr.co.zerobase.financevan.application.service.user.definition;

import kr.co.zerobase.financevan.domain.bank.BankCorp;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Author Heli
 */
public class FintechUserDefinition {

    private final Long fintechUserId;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;
    private final BankCorp bank;

    private final String bankAccountId;
    private final LocalDate birthday;
    private final String fintechUserNum;

    public FintechUserDefinition(Long fintechUserId, LocalDateTime createdAt, LocalDateTime modifiedAt, BankCorp bank, String bankAccountId, LocalDate birthday, String fintechUserNum) {
        this.fintechUserId = fintechUserId;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.bank = bank;
        this.bankAccountId = bankAccountId;
        this.birthday = birthday;
        this.fintechUserNum = fintechUserNum;
    }

    public Long getFintechUserId() {
        return fintechUserId;
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
