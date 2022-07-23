package kr.co.zerobase.financevan.infrastructure.persistence.bank;

import kr.co.zerobase.financevan.domain.bank.BankAccount;
import kr.co.zerobase.financevan.domain.bank.BankCorp;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author Heli
 */
public interface BankAccountRepository extends JpaRepository<BankAccount, Long>, BankAccountRepositoryCustom {

    BankAccount findByBankAndAccountId(BankCorp bank, String accountId);
}
