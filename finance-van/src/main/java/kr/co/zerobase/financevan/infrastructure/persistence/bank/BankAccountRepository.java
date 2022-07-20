package kr.co.zerobase.financevan.infrastructure.persistence.bank;

import kr.co.zerobase.financevan.domain.bank.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author Heli
 */
public interface BankAccountRepository extends JpaRepository<BankAccount, Long>, BankAccountRepositoryCustom {
}
