package kr.co.zerobase.financevan.infrastructure.persistence.partner;

import kr.co.zerobase.financevan.domain.bank.BankAccount;
import kr.co.zerobase.financevan.domain.partner.Partner;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author Heli
 */
public interface PartnerRepository extends JpaRepository<Partner, Long>, PartnerRepositoryCustom {
}
