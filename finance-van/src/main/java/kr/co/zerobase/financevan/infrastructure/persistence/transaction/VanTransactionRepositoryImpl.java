package kr.co.zerobase.financevan.infrastructure.persistence.transaction;

import kr.co.zerobase.financevan.domain.transaction.VanTransaction;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

/**
 * @Author Heli
 */
public class VanTransactionRepositoryImpl extends QuerydslRepositorySupport implements VanTransactionRepositoryCustom {
    public VanTransactionRepositoryImpl() {
        super(VanTransaction.class);
    }
}
