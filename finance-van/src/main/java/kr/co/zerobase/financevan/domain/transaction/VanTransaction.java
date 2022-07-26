package kr.co.zerobase.financevan.domain.transaction;

import kr.co.zerobase.financevan.application.usecase.transaction.spec.VanTransactionChannelSpec;
import kr.co.zerobase.financevan.configuration.jpa.BaseEntity;
import kr.co.zerobase.financevan.domain.bank.BankCorp;
import kr.co.zerobase.financevan.domain.enums.VanTask;
import kr.co.zerobase.financevan.domain.partner.Partner;
import kr.co.zerobase.financevan.domain.user.FintechUser;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @Author Heli
 */
@Entity
@Table(name = "van_transaction")
public class VanTransaction extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "partner_id", nullable = false)
    private Partner partner;

    @Enumerated(EnumType.STRING)
    @Column(name = "bank", nullable = false)
    private BankCorp bank;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fintech_user_id")
    private FintechUser fintechUser;

    @Enumerated(EnumType.STRING)
    @Column(name = "task", nullable = false)
    private VanTask task;

    @Column(name = "req_dttm", nullable = false)
    private LocalDateTime reqDttm;

    @Column(name = "res_dttm")
    private LocalDateTime resDttm;

    @Column(name = "description", nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_bank", nullable = false)
    private BankCorp transactionBank;

    @Column(name = "transaction_account_id", nullable = false)
    private String transactionAccountId;

    @Column(name = "transaction_account_description", nullable = false)
    private String transactionAccountDescription;

    @Column(name = "amount", nullable = false)
    private long amount;

    @Column(name = "channel_request_id")
    private String channelRequestId;


    public static VanTransaction register(Partner partner, FintechUser fintechUser, VanTransactionChannelSpec spec) {
        return new VanTransaction(partner, fintechUser, VanTask.REGISTER, "", fintechUser.getBank(), "", "", 0, spec);
    }

    public static VanTransaction withdraw(Partner partner, FintechUser fintechUser, String description, BankCorp transactionBank, String transactionAccountId, String transactionAccountDescription, long amount, VanTransactionChannelSpec spec) {
        return new VanTransaction(partner, fintechUser, VanTask.WITHDRAW, description, transactionBank, transactionAccountId, transactionAccountDescription, amount, spec);
    }

    public static VanTransaction deposit(Partner partner, FintechUser fintechUser, String description, BankCorp transactionBank, String transactionAccountId, String transactionAccountDescription, long amount, VanTransactionChannelSpec spec) {
        return new VanTransaction(partner, fintechUser, VanTask.DEPOSIT, description, transactionBank, transactionAccountId, transactionAccountDescription, amount, spec);
    }

    public static VanTransaction balance(Partner partner, FintechUser fintechUser, VanTransactionChannelSpec spec) {
        return new VanTransaction(partner, fintechUser, VanTask.BALANCE, "", fintechUser.getBank(), "", "", 0, spec);
    }

    public VanTransaction applyResDttm() {
        this.resDttm = LocalDateTime.now();
        return this;
    }

    public VanTransaction(Partner partner, FintechUser fintechUser, VanTask task, String description, BankCorp transactionBank, String transactionAccountId, String transactionAccountDescription, long amount, VanTransactionChannelSpec spec) {
        this.partner = partner;
        this.bank = fintechUser.getBank();
        this.fintechUser = fintechUser;
        this.task = task;
        this.reqDttm = LocalDateTime.now();
        this.resDttm = null;
        this.description = description;
        this.transactionBank = transactionBank;
        this.transactionAccountId = transactionAccountId;
        this.transactionAccountDescription = transactionAccountDescription;
        this.amount = amount;
        this.channelRequestId = spec.getChannelRequestId();
    }

    public Partner getPartner() {
        return partner;
    }

    public BankCorp getBank() {
        return bank;
    }

    public FintechUser getFintechUser() {
        return fintechUser;
    }

    public VanTask getTask() {
        return task;
    }

    public LocalDateTime getReqDttm() {
        return reqDttm;
    }

    public LocalDateTime getResDttm() {
        return resDttm;
    }

    public String getDescription() {
        return description;
    }

    public BankCorp getTransactionBank() {
        return transactionBank;
    }

    public String getTransactionAccountId() {
        return transactionAccountId;
    }

    public String getTransactionAccountDescription() {
        return transactionAccountDescription;
    }

    public long getAmount() {
        return amount;
    }

    public String getChannelRequestId() {
        return channelRequestId;
    }

    protected VanTransaction() {

    }
}
