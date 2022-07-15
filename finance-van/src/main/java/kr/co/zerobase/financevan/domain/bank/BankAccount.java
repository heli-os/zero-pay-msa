package kr.co.zerobase.financevan.domain.bank;

import kr.co.zerobase.financevan.configuration.jpa.BaseEntity;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;

/**
 * @Author Heli
 */
@Entity
@Table(name = "bank_accounts")
public class BankAccount extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "bank")
    private BankCorp bank;

    @Column(name = "account_id")
    private String accountId;

    @Column(name = "name")
    private String name;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "amount")
    private BigInteger amount;

    public BankAccount(BankCorp bank, String accountId, String name, LocalDate birthday, BigInteger amount) {
        this.bank = bank;
        this.accountId = accountId;
        this.name = name;
        this.birthday = birthday;
        this.amount = amount;
    }

    public BankAccount() {
    }
}
