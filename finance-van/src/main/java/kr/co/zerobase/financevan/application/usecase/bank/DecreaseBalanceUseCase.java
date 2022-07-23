package kr.co.zerobase.financevan.application.usecase.bank;

import kr.co.zerobase.financevan.application.mapper.BankAccountMapper;
import kr.co.zerobase.financevan.application.service.bank.BankAccountQuery;
import kr.co.zerobase.financevan.application.service.bank.BankAccountTransactionCommand;
import kr.co.zerobase.financevan.application.service.bank.BankAccountTransactionQuery;
import kr.co.zerobase.financevan.application.usecase.bank.definition.BankAccountDefinition;
import kr.co.zerobase.financevan.application.usecase.bank.exception.DuplicateBankAccountTransactionException;
import kr.co.zerobase.financevan.application.usecase.bank.spec.BankAccountTransactionChannelSpec;
import kr.co.zerobase.financevan.domain.bank.BankAccount;
import kr.co.zerobase.financevan.domain.bank.BankCorp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author Heli
 */
@Service
public class DecreaseBalanceUseCase {

    private final BankAccountQuery bankAccountQuery;
    private final BankAccountTransactionQuery bankAccountTransactionQuery;
    private final BankAccountTransactionCommand bankAccountTransactionCommand;

    public DecreaseBalanceUseCase(BankAccountQuery bankAccountQuery, BankAccountTransactionQuery bankAccountTransactionQuery, BankAccountTransactionCommand bankAccountTransactionCommand) {
        this.bankAccountQuery = bankAccountQuery;
        this.bankAccountTransactionQuery = bankAccountTransactionQuery;
        this.bankAccountTransactionCommand = bankAccountTransactionCommand;
    }

    @Transactional
    public BankAccountDefinition command(BankCorp bank, String bankAccountId, long decreaseBalance, String printContent, BankAccountTransactionChannelSpec spec) {
        if (bankAccountTransactionQuery.existsByChannelRequestId(spec.getChannelRequestId())) {
            throw new DuplicateBankAccountTransactionException(spec.getChannelRequestId());
        }

        BankAccount bankAccount = bankAccountQuery.queryByBankAndAccountId(bank, bankAccountId);
        bankAccountTransactionCommand.logWithdraw(bankAccount, decreaseBalance, printContent, spec);
        return BankAccountMapper.toDefinition(bankAccount.decreaseBalance(decreaseBalance));
    }
}
