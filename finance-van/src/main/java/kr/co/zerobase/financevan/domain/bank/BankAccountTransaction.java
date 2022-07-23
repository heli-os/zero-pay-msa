package kr.co.zerobase.financevan.domain.bank;

import kr.co.zerobase.financevan.application.usecase.bank.spec.BankAccountTransactionChannelSpec;
import kr.co.zerobase.financevan.configuration.jpa.BaseEntity;
import kr.co.zerobase.financevan.domain.enums.BankAccountTask;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @Column(name = "req_dttm", nullable = false)
    private LocalDateTime reqDttm;

    @Column(name = "res_dttm")
    private LocalDateTime resDttm;

    @Column(name = "amount", nullable = false)
    private long amount;

    @Column(name = "print_content", nullable = false)
    private String printContent;

    @Column(name = "channel_request_id", nullable = false)
    private String channelRequestId;

    public static BankAccountTransaction create(BankAccount bankAccount, BankAccountTransactionChannelSpec spec) {
        return new BankAccountTransaction(bankAccount, BankAccountTask.CREATE, 0, "", spec);
    }

    public static BankAccountTransaction withdraw(BankAccount bankAccount, long amount, String printContent, BankAccountTransactionChannelSpec spec) {
        return new BankAccountTransaction(bankAccount, BankAccountTask.WITHDRAW, amount, printContent, spec);
    }

    public static BankAccountTransaction deposit(BankAccount bankAccount, long amount, String printContent, BankAccountTransactionChannelSpec spec) {
        return new BankAccountTransaction(bankAccount, BankAccountTask.DEPOSIT, amount, printContent, spec);
    }

    public BankAccountTransaction applyResDttm(LocalDateTime resDttm) {
        this.resDttm = resDttm;
        return this;
    }

    private BankAccountTransaction(BankAccount bankAccount, BankAccountTask task, long amount, String printContent, BankAccountTransactionChannelSpec spec) {
        this.bankAccount = bankAccount;
        this.task = task;
        this.reqDttm = LocalDateTime.now();
        this.amount = amount;
        this.printContent = printContent;
        this.channelRequestId = spec.getChannelRequestId();
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public BankAccountTask getTask() {
        return task;
    }

    public LocalDateTime getReqDttm() {
        return reqDttm;
    }

    public LocalDateTime getResDttm() {
        return resDttm;
    }

    public long getAmount() {
        return amount;
    }

    public String getPrintContent() {
        return printContent;
    }

    public String getChannelRequestId() {
        return channelRequestId;
    }

    protected BankAccountTransaction() {

    }
}
