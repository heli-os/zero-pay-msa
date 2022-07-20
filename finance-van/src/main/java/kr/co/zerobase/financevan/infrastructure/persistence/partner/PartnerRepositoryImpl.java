package kr.co.zerobase.financevan.infrastructure.persistence.partner;

import kr.co.zerobase.financevan.domain.bank.BankAccount;
import kr.co.zerobase.financevan.domain.partner.Partner;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

/**
 * @Author Heli
 */
public class PartnerRepositoryImpl extends QuerydslRepositorySupport implements PartnerRepositoryCustom {
    public PartnerRepositoryImpl() {
        super(Partner.class);
    }
}
