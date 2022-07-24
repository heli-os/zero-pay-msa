package kr.co.zerobase.financevan.application.usecase.bank;

import kr.co.zerobase.financevan.application.mapper.BankAccountMapper;
import kr.co.zerobase.financevan.application.usecase.bank.definition.BankAccountDefinition;
import kr.co.zerobase.financevan.application.usecase.bank.exception.DuplicateBankAccountTransactionException;
import kr.co.zerobase.financevan.application.usecase.bank.spec.BankAccountTransactionChannelSpec;
import kr.co.zerobase.financevan.domain.bank.BankAccount;
import kr.co.zerobase.financevan.domain.bank.BankAccountTransaction;
import kr.co.zerobase.financevan.domain.bank.BankCorp;
import kr.co.zerobase.financevan.infrastructure.persistence.bank.BankAccountRepository;
import kr.co.zerobase.financevan.infrastructure.persistence.bank.BankAccountTransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author Heli
 */
@Service
public class DecreaseBalanceUseCase {

    private final BankAccountRepository bankAccountRepository;
    private final BankAccountTransactionRepository bankAccountTransactionRepository;

    public DecreaseBalanceUseCase(BankAccountRepository bankAccountRepository, BankAccountTransactionRepository bankAccountTransactionRepository) {
        this.bankAccountRepository = bankAccountRepository;
        this.bankAccountTransactionRepository = bankAccountTransactionRepository;
    }

    @Transactional
    public BankAccountDefinition command(BankCorp bank, String bankAccountId, long decreaseBalance, BankAccountTransactionChannelSpec spec) {
        if (bankAccountTransactionRepository.existsByChannelRequestId(spec.getChannelRequestId())) {
            throw new DuplicateBankAccountTransactionException(spec.getChannelRequestId());
        }

        BankAccount bankAccount = bankAccountRepository.findByBankAndAccountId(bank, bankAccountId);
        BankAccountTransaction tx = BankAccountTransaction.withdraw(bankAccount, decreaseBalance, spec);

        bankAccountTransactionRepository.save(tx);
        bankAccountRepository.save(bankAccount);
        return BankAccountMapper.toDefinition(bankAccount.decreaseBalance(decreaseBalance));
    }
}
