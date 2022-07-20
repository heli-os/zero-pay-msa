package kr.co.zerobase.financevan.infrastructure.persistence.bank;

import kr.co.zerobase.financevan.domain.bank.BankAccountTransaction;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

/**
 * @Author Heli
 */
public class BankAccountTransactionRepositoryImpl extends QuerydslRepositorySupport implements BankAccountTransactionRepositoryCustom {
    public BankAccountTransactionRepositoryImpl() {
        super(BankAccountTransaction.class);
    }
}
