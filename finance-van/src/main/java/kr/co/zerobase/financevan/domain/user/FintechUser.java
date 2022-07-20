package kr.co.zerobase.financevan.domain.user;

import kr.co.zerobase.financevan.configuration.jpa.BaseEntity;
import kr.co.zerobase.financevan.domain.bank.BankCorp;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @Author Heli
 */
@Entity
@Table(name = "fintech_user")
public class FintechUser extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "bank", nullable = false)
    private BankCorp bank;

    @Column(name = "bank_account_id", nullable = false)
    private String bankAccountId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @Column(name = "fintech_user_num", nullable = false)
    private String fintechUserNum;
}
