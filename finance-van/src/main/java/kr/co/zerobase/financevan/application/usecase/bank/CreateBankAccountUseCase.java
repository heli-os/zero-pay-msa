package kr.co.zerobase.financevan.application.usecase.bank;

import kr.co.zerobase.financevan.application.mapper.BankAccountMapper;
import kr.co.zerobase.financevan.application.service.bank.BankAccountTransactionCommand;
import kr.co.zerobase.financevan.application.service.bank.BankAccountTransactionQuery;
import kr.co.zerobase.financevan.application.usecase.bank.definition.BankAccountDefinition;
import kr.co.zerobase.financevan.application.usecase.bank.exception.DuplicateBankAccountTransactionException;
import kr.co.zerobase.financevan.application.usecase.bank.spec.BankAccountTransactionChannelSpec;
import kr.co.zerobase.financevan.domain.bank.BankAccount;
import kr.co.zerobase.financevan.domain.bank.BankCorp;
import kr.co.zerobase.financevan.infrastructure.persistence.bank.BankAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

/**
 * @Author Heli
 */
@Service
public class CreateBankAccountUseCase {

    private final BankAccountRepository bankAccountRepository;
    private final BankAccountTransactionQuery bankAccountTransactionQuery;
    private final BankAccountTransactionCommand bankAccountTransactionCommand;

    public CreateBankAccountUseCase(BankAccountRepository bankAccountRepository, BankAccountTransactionQuery bankAccountTransactionQuery, BankAccountTransactionCommand bankAccountTransactionCommand) {
        this.bankAccountRepository = bankAccountRepository;
        this.bankAccountTransactionQuery = bankAccountTransactionQuery;
        this.bankAccountTransactionCommand = bankAccountTransactionCommand;
    }

    @Transactional
    public BankAccountDefinition command(BankCorp bank, String name, LocalDate birthday, BankAccountTransactionChannelSpec spec) {
        if (bankAccountTransactionQuery.existsByChannelRequestId(spec.getChannelRequestId())) {
            throw new DuplicateBankAccountTransactionException(spec.getChannelRequestId());
        }

        BankAccount bankAccount = BankAccount.create(bank, name, birthday);

        bankAccountTransactionCommand.logCreate(bankAccount, spec);
        bankAccountRepository.save(bankAccount);
        return BankAccountMapper.toDefinition(bankAccount);
    }
}
