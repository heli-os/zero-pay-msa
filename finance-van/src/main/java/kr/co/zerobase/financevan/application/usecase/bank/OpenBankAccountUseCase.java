package kr.co.zerobase.financevan.application.usecase.bank;

import kr.co.zerobase.financevan.application.mapper.BankAccountMapper;
import kr.co.zerobase.financevan.application.usecase.bank.definition.BankAccountDefinition;
import kr.co.zerobase.financevan.application.usecase.bank.exception.DuplicateBankAccountTransactionException;
import kr.co.zerobase.financevan.application.usecase.bank.spec.BankAccountTransactionChannelSpec;
import kr.co.zerobase.financevan.domain.bank.BankAccount;
import kr.co.zerobase.financevan.domain.bank.BankAccountTransaction;
import kr.co.zerobase.financevan.infrastructure.persistence.bank.BankAccountRepository;
import kr.co.zerobase.financevan.infrastructure.persistence.bank.BankAccountTransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

/**
 * @Author Heli
 */
@Service
public class OpenBankAccountUseCase {

    private final BankAccountRepository bankAccountRepository;
    private final BankAccountTransactionRepository bankAccountTransactionRepository;

    public OpenBankAccountUseCase(BankAccountRepository bankAccountRepository, BankAccountTransactionRepository bankAccountTransactionRepository) {
        this.bankAccountRepository = bankAccountRepository;
        this.bankAccountTransactionRepository = bankAccountTransactionRepository;
    }

    @Transactional
    public BankAccountDefinition command(String name, LocalDate birthday, BankAccountTransactionChannelSpec spec) {
        if (bankAccountTransactionRepository.existsByChannelRequestId(spec.getChannelRequestId())) {
            throw new DuplicateBankAccountTransactionException(spec.getChannelRequestId());
        }

        BankAccount bankAccount = BankAccount.open(name, birthday);
        BankAccountTransaction tx = BankAccountTransaction.open(bankAccount, spec);

        bankAccountTransactionRepository.save(tx);
        bankAccountRepository.save(bankAccount);
        return BankAccountMapper.toDefinition(bankAccount);
    }
}
