package kr.co.zerobase.financevan.application.mapper;

import kr.co.zerobase.financevan.application.usecase.bank.definition.BankAccountTransactionDefinition;
import kr.co.zerobase.financevan.domain.bank.BankAccountTransaction;

/**
 * @Author Heli
 */
public class BankAccountTransactionMapper {

    public static BankAccountTransactionDefinition toDefinition(BankAccountTransaction tx) {
        return new BankAccountTransactionDefinition(
                tx.getId(),
                tx.getCreatedAt(),
                tx.getModifiedAt(),
                BankAccountMapper.toDefinition(tx.getBankAccount()),
                tx.getTask(),
                tx.getAmount(),
                tx.getChannelRequestId()
        );
    }
}
