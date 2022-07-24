package kr.co.zerobase.financevan.application.adapter;

import kr.co.zerobase.financevan.application.usecase.bank.definition.BankAccountBalance;
import kr.co.zerobase.financevan.application.usecase.bank.definition.BankAccountDefinition;
import kr.co.zerobase.financevan.application.usecase.bank.spec.BankAccountTransactionChannelSpec;
import kr.co.zerobase.financevan.domain.bank.BankCorp;

/**
 * @Author Heli
 */
public interface BankClientAdapter {

    BankAccountDefinition deposit(BankCorp bank, String accountId, long increaseBalance, BankAccountTransactionChannelSpec spec);

    BankAccountDefinition withdraw(BankCorp bank, String accountId, long increaseBalance, BankAccountTransactionChannelSpec spec);

    BankAccountBalance balance(BankCorp bank, String accountId, BankAccountTransactionChannelSpec spec);
}
