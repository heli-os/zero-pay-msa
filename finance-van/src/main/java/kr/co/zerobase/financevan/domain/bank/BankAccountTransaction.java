package kr.co.zerobase.financevan.domain.bank;

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

    public static BankAccountTransaction withdraw(BankAccount bankAccount, long amount, String printContent) {
        return new BankAccountTransaction(bankAccount, BankAccountTask.WITHDRAW, LocalDateTime.now(), null, amount, printContent);
    }

    public static BankAccountTransaction deposit(BankAccount bankAccount, long amount, String printContent) {
        return new BankAccountTransaction(bankAccount, BankAccountTask.DEPOSIT, LocalDateTime.now(), null, amount, printContent);
    }

    public BankAccountTransaction applyResDttm() {
        this.resDttm = LocalDateTime.now();
        return this;
    }

    private BankAccountTransaction(BankAccount bankAccount, BankAccountTask task, LocalDateTime reqDttm, LocalDateTime resDttm, long amount, String printContent) {
        this.bankAccount = bankAccount;
        this.task = task;
        this.reqDttm = reqDttm;
        this.resDttm = resDttm;
        this.amount = amount;
        this.printContent = printContent;
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

    protected BankAccountTransaction() {

    }
}
