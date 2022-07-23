package kr.co.zerobase.financevan.application.mapper;

import kr.co.zerobase.financevan.application.usecase.bank.definition.BankAccountDefinition;
import kr.co.zerobase.financevan.domain.bank.BankAccount;

/**
 * @Author Heli
 */
public class BankAccountMapper {
    public static BankAccountDefinition toDefinition(BankAccount bankAccount) {
        return new BankAccountDefinition(bankAccount.getId(), bankAccount.getCreatedAt(), bankAccount.getModifiedAt(), bankAccount.getBank(), bankAccount.getAccountId(), bankAccount.getName(), bankAccount.getBirthday(), bankAccount.getBalance());
    }
}
