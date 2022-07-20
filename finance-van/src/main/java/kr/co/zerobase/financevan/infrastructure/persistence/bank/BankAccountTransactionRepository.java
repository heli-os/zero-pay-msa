package kr.co.zerobase.financevan.infrastructure.persistence.bank;

import kr.co.zerobase.financevan.domain.bank.BankAccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author Heli
 */
public interface BankAccountTransactionRepository extends JpaRepository<BankAccountTransaction, Long>, BankAccountTransactionRepositoryCustom {
}
