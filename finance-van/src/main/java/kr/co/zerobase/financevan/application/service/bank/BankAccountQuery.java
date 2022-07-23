package kr.co.zerobase.financevan.application.service.bank;

import kr.co.zerobase.financevan.application.service.bank.exception.NotFoundBankAccountException;
import kr.co.zerobase.financevan.domain.bank.BankAccount;
import kr.co.zerobase.financevan.domain.bank.BankCorp;
import kr.co.zerobase.financevan.infrastructure.persistence.bank.BankAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * @Author Heli
 */
@Service
@Transactional(readOnly = true)
public class BankAccountQuery {

    private final BankAccountRepository bankAccountRepository;

    public BankAccountQuery(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public BankAccount queryByBankAndAccountId(BankCorp bank, String accountId) {
        BankAccount bankAccount = bankAccountRepository.findByBankAndAccountId(bank, accountId);
        if (Objects.isNull(bankAccount)) {
            throw new NotFoundBankAccountException(bank, accountId);
        }
        return bankAccount;
    }
}
