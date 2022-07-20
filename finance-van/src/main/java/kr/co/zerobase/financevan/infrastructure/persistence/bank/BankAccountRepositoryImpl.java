package kr.co.zerobase.financevan.infrastructure.persistence.bank;

import kr.co.zerobase.financevan.domain.bank.BankAccount;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

/**
 * @Author Heli
 */
public class BankAccountRepositoryImpl extends QuerydslRepositorySupport implements BankAccountRepositoryCustom {
    public BankAccountRepositoryImpl() {
        super(BankAccount.class);
    }
}
