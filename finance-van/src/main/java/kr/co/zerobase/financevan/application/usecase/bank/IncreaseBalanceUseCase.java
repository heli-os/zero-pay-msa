package kr.co.zerobase.financevan.application.usecase.bank;

import kr.co.zerobase.financevan.application.mapper.BankAccountMapper;
import kr.co.zerobase.financevan.application.service.bank.BankAccountQuery;
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
public class IncreaseBalanceUseCase {

    private final BankAccountQuery bankAccountQuery;
    private final BankAccountRepository bankAccountRepository;
    private final BankAccountTransactionRepository bankAccountTransactionRepository;

    public IncreaseBalanceUseCase(BankAccountQuery bankAccountQuery, BankAccountRepository bankAccountRepository, BankAccountTransactionRepository bankAccountTransactionRepository) {
        this.bankAccountQuery = bankAccountQuery;
        this.bankAccountRepository = bankAccountRepository;
        this.bankAccountTransactionRepository = bankAccountTransactionRepository;
    }

    @Transactional
    public BankAccountDefinition command(BankCorp bank, String accountId, long increaseBalance, BankAccountTransactionChannelSpec spec) {
        if (bankAccountTransactionRepository.existsByChannelRequestId(spec.getChannelRequestId())) {
            throw new DuplicateBankAccountTransactionException(spec.getChannelRequestId());
        }

        BankAccount bankAccount = bankAccountQuery.queryByBankAndAccountId(bank, accountId);
        BankAccountTransaction tx = BankAccountTransaction.deposit(bankAccount, increaseBalance, spec);

        bankAccountTransactionRepository.save(tx);
        bankAccountRepository.save(bankAccount);
        return BankAccountMapper.toDefinition(bankAccount.increaseBalance(increaseBalance));
    }
}
