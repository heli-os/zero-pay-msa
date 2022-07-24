package kr.co.zerobase.financevan.application.adapter;

import kr.co.zerobase.financevan.application.usecase.bank.DecreaseBalanceUseCase;
import kr.co.zerobase.financevan.application.usecase.bank.IncreaseBalanceUseCase;
import kr.co.zerobase.financevan.application.usecase.bank.InquiryBalanceUseCase;
import kr.co.zerobase.financevan.application.usecase.bank.definition.BankAccountBalance;
import kr.co.zerobase.financevan.application.usecase.bank.definition.BankAccountDefinition;
import kr.co.zerobase.financevan.application.usecase.bank.spec.BankAccountTransactionChannelSpec;
import kr.co.zerobase.financevan.domain.bank.BankCorp;
import org.springframework.stereotype.Service;

/**
 * @Author Heli
 */
@Service
public class CommonBankClient implements BankClientAdapter {

    private final IncreaseBalanceUseCase increaseBalanceUseCase;
    private final DecreaseBalanceUseCase decreaseBalanceUseCase;
    private final InquiryBalanceUseCase inquiryBalanceUseCase;

    public CommonBankClient(IncreaseBalanceUseCase increaseBalanceUseCase, DecreaseBalanceUseCase decreaseBalanceUseCase, InquiryBalanceUseCase inquiryBalanceUseCase) {
        this.increaseBalanceUseCase = increaseBalanceUseCase;
        this.decreaseBalanceUseCase = decreaseBalanceUseCase;
        this.inquiryBalanceUseCase = inquiryBalanceUseCase;
    }

    @Override
    public BankAccountDefinition deposit(BankCorp bank, String accountId, long increaseBalance, BankAccountTransactionChannelSpec spec) {
        return increaseBalanceUseCase.command(bank, accountId, increaseBalance, spec);
    }

    @Override
    public BankAccountDefinition withdraw(BankCorp bank, String accountId, long decreaseBalance, BankAccountTransactionChannelSpec spec) {
        return decreaseBalanceUseCase.command(bank, accountId, decreaseBalance, spec);
    }

    @Override
    public BankAccountBalance balance(BankCorp bank, String accountId, BankAccountTransactionChannelSpec spec) {
        return inquiryBalanceUseCase.command(bank, accountId, spec);
    }
}
