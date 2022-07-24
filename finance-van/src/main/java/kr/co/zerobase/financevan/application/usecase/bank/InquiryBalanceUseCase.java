package kr.co.zerobase.financevan.application.usecase.bank;

import kr.co.zerobase.financevan.application.usecase.bank.definition.BankAccountBalance;
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
public class InquiryBalanceUseCase {

    private final BankAccountRepository bankAccountRepository;
    private final BankAccountTransactionRepository bankAccountTransactionRepository;

    public InquiryBalanceUseCase(BankAccountRepository bankAccountRepository, BankAccountTransactionRepository bankAccountTransactionRepository) {
        this.bankAccountRepository = bankAccountRepository;
        this.bankAccountTransactionRepository = bankAccountTransactionRepository;
    }

    @Transactional
    public BankAccountBalance command(BankCorp bank, String accountId, BankAccountTransactionChannelSpec spec) {
        BankAccount bankAccount = bankAccountRepository.findByBankAndAccountId(bank, accountId);
        BankAccountTransaction tx = BankAccountTransaction.balance(bankAccount, spec);

        bankAccountTransactionRepository.save(tx);
        return new BankAccountBalance(bankAccount.getBalance());
    }
}
