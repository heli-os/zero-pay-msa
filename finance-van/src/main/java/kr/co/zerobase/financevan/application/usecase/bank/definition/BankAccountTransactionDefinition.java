package kr.co.zerobase.financevan.application.usecase.bank.definition;

import kr.co.zerobase.financevan.domain.enums.BankAccountTask;

import java.time.LocalDateTime;

/**
 * @Author Heli
 */
public class BankAccountTransactionDefinition {

    private final long id;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;
    private final BankAccountDefinition bankAccount;
    private final BankAccountTask task;
    private final long amount;
    private final String channelRequestId;

    public BankAccountTransactionDefinition(long id, LocalDateTime createdAt, LocalDateTime modifiedAt, BankAccountDefinition bankAccount, BankAccountTask task, long amount, String channelRequestId) {
        this.id = id;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.bankAccount = bankAccount;
        this.task = task;
        this.amount = amount;
        this.channelRequestId = channelRequestId;
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

    public BankAccountDefinition getBankAccount() {
        return bankAccount;
    }

    public BankAccountTask getTask() {
        return task;
    }

    public long getAmount() {
        return amount;
    }

    public String getChannelRequestId() {
        return channelRequestId;
    }

    @Override
    public String toString() {
        return "BankAccountTransactionDefinition{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                ", bankAccount=" + bankAccount +
                ", task=" + task +
                ", amount=" + amount +
                ", channelRequestId='" + channelRequestId + '\'' +
                '}';
    }
}
