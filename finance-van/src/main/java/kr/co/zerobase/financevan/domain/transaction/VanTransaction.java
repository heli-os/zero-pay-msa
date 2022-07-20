package kr.co.zerobase.financevan.domain.transaction;

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

    @Column(name = "received_account_id")
    private String receivedAccountId;

    @Column(name = "received_account_description")
    private String receivedAccountDescription;

    @Column(name = "amount")
    private Long amount;


    public static VanTransaction register(Partner partner, BankCorp bank) {
        return new VanTransaction(partner, bank, null, VanTask.REGISTER, LocalDateTime.now(), null, null, null);
    }

    public static VanTransaction withdraw(Partner partner, BankCorp bank, FintechUser fintechUser, String receivedAccountId, String receivedAccountDescription, long amount) {
        return new VanTransaction(partner, bank, fintechUser, VanTask.WITHDRAW, LocalDateTime.now(), receivedAccountId, receivedAccountDescription, amount);
    }

    public static VanTransaction deposit(Partner partner, BankCorp bank, FintechUser fintechUser, String receivedAccountId, String receivedAccountDescription, long amount) {
        return new VanTransaction(partner, bank, fintechUser, VanTask.DEPOSIT, LocalDateTime.now(), receivedAccountId, receivedAccountDescription, amount);
    }

    public static VanTransaction balance(Partner partner, BankCorp bank, FintechUser fintechUser) {
        return new VanTransaction(partner, bank, fintechUser, VanTask.BALANCE, LocalDateTime.now(), null, null, null);
    }

    public VanTransaction applyRegister(FintechUser fintechUser) {
        this.fintechUser = fintechUser;
        return this.applyResDttm();
    }

    public VanTransaction applyResDttm() {
        this.resDttm = LocalDateTime.now();
        return this;
    }

    private VanTransaction(Partner partner, BankCorp bank, FintechUser fintechUser, VanTask task, LocalDateTime reqDttm, String receivedAccountId, String receivedAccountDescription, Long amount) {
        this.partner = partner;
        this.bank = bank;
        this.fintechUser = fintechUser;
        this.task = task;
        this.reqDttm = reqDttm;
        this.resDttm = null;
        this.receivedAccountId = receivedAccountId;
        this.receivedAccountDescription = receivedAccountDescription;
        this.amount = amount;
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

    public long getAmount() {
        return amount;
    }

    public String getReceivedAccountId() {
        return receivedAccountId;
    }

    public String getReceivedAccountDescription() {
        return receivedAccountDescription;
    }

    protected VanTransaction() {

    }
}
