package kr.co.zerobase.financevan.application.service.bank;

import kr.co.zerobase.financevan.application.mapper.BankAccountMapper;
import kr.co.zerobase.financevan.application.service.bank.definition.BankAccountDefinition;
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
@Transactional
public class BankAccountCommand {

    private final BankAccountRepository bankAccountRepository;
    private final BankAccountQuery bankAccountQuery;

    public BankAccountCommand(BankAccountRepository bankAccountRepository, BankAccountQuery bankAccountQuery) {
        this.bankAccountRepository = bankAccountRepository;
        this.bankAccountQuery = bankAccountQuery;
    }

    public BankAccountDefinition createAccount(BankCorp bank, String name, LocalDate birthday, long balance) {
        BankAccount bankAccount = BankAccount.create(bank, name, birthday, balance);
        bankAccountRepository.save(bankAccount);

        return BankAccountMapper.toDefinition(bankAccount);
    }

    public BankAccountDefinition increaseBalance(BankCorp bank, String accountId, long balance) {
        BankAccount bankAccount = bankAccountQuery.findByBankAndAccountId(bank, accountId);
        bankAccount.increaseBalance(balance);

        return BankAccountMapper.toDefinition(bankAccount);
    }

    public BankAccountDefinition decreaseBalance(BankCorp bank, String accountId, long balance) {
        BankAccount bankAccount = bankAccountQuery.findByBankAndAccountId(bank, accountId);
        bankAccount.decreaseBalance(balance);

        return BankAccountMapper.toDefinition(bankAccount);
    }
}
