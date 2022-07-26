package kr.co.zerobase.financevan.application.service.bank;

import kr.co.zerobase.financevan.application.service.bank.exception.NotFoundBankAccountException;
import kr.co.zerobase.financevan.domain.bank.BankAccount;
import kr.co.zerobase.financevan.domain.bank.BankCorp;
import kr.co.zerobase.financevan.infrastructure.persistence.bank.BankAccountRepository;
import org.springframework.stereotype.Service;

/**
 * @Author Heli
 */
@Service
public class BankAccountQuery {

    private final BankAccountRepository bankAccountRepository;

    public BankAccountQuery(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public BankAccount queryByBankAndAccountId(BankCorp bank, String accountId) {
        return bankAccountRepository.findByBankAndAccountId(bank, accountId).orElseThrow(() -> new NotFoundBankAccountException(bank, accountId));
    }
}
