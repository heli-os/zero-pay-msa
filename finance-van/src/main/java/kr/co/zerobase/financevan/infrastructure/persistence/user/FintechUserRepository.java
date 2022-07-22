package kr.co.zerobase.financevan.infrastructure.persistence.user;

import kr.co.zerobase.financevan.domain.bank.BankCorp;
import kr.co.zerobase.financevan.domain.user.FintechUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author Heli
 */
public interface FintechUserRepository extends JpaRepository<FintechUser, Long>, FintechUserRepositoryCustom {

    boolean existsByBankAndBankAccountId(BankCorp bank, String bankAccountId);

    FintechUser findByFintechUserNum(String fintechUserNum);
}
