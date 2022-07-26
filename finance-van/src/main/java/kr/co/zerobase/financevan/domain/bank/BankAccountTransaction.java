package kr.co.zerobase.financevan.domain.bank;

import kr.co.zerobase.financevan.application.usecase.bank.spec.BankAccountTransactionChannelSpec;
import kr.co.zerobase.financevan.configuration.jpa.BaseEntity;
import kr.co.zerobase.financevan.domain.enums.BankAccountTask;

import javax.persistence.*;

/**
 * @Author Heli
 */
@Entity
@Table(name = "bank_account_transaction")
public class BankAccountTransaction extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_account_id", nullable = false)
    private BankAccount bankAccount;

    @Enumerated(EnumType.STRING)
    @Column(name = "task", nullable = false)
    private BankAccountTask task;

    @Column(name = "amount", nullable = false)
    private long amount;

    @Column(name = "channel_request_id", nullable = false)
    private String channelRequestId;

    public static BankAccountTransaction open(BankAccount bankAccount, BankAccountTransactionChannelSpec spec) {
        return new BankAccountTransaction(bankAccount, BankAccountTask.OPEN, 0, spec);
    }

    public static BankAccountTransaction withdraw(BankAccount bankAccount, long amount, BankAccountTransactionChannelSpec spec) {
        return new BankAccountTransaction(bankAccount, BankAccountTask.WITHDRAW, amount, spec);
    }

    public static BankAccountTransaction deposit(BankAccount bankAccount, long amount, BankAccountTransactionChannelSpec spec) {
        return new BankAccountTransaction(bankAccount, BankAccountTask.DEPOSIT, amount, spec);
    }

    public static BankAccountTransaction balance(BankAccount bankAccount, BankAccountTransactionChannelSpec spec) {
        return new BankAccountTransaction(bankAccount, BankAccountTask.BALANCE, 0, spec);
    }

    private BankAccountTransaction(BankAccount bankAccount, BankAccountTask task, long amount, BankAccountTransactionChannelSpec spec) {
        this.bankAccount = bankAccount;
        this.task = task;
        this.amount = amount;
        this.channelRequestId = spec.getChannelRequestId();
    }

    public BankAccount getBankAccount() {
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

    protected BankAccountTransaction() {

    }
}
