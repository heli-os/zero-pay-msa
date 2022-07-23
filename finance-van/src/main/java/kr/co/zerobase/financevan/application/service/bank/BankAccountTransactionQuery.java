package kr.co.zerobase.financevan.application.service.bank;

import kr.co.zerobase.financevan.application.usecase.bank.exception.NotFoundBankAccountTransactionException;
import kr.co.zerobase.financevan.domain.bank.BankAccountTransaction;
import kr.co.zerobase.financevan.infrastructure.persistence.bank.BankAccountTransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * @Author Heli
 */
@Service
@Transactional(readOnly = true)
public class BankAccountTransactionQuery {

    private final BankAccountTransactionRepository bankAccountTransactionRepository;

    public BankAccountTransactionQuery(BankAccountTransactionRepository bankAccountTransactionRepository) {
        this.bankAccountTransactionRepository = bankAccountTransactionRepository;
    }

    public BankAccountTransaction queryById(long txId) {
        return bankAccountTransactionRepository.findById(txId)
                .orElseThrow(() -> new NotFoundBankAccountTransactionException(Map.of("txId", txId)));
    }

    public boolean existsByChannelRequestId(String channelRequestId) {
        return bankAccountTransactionRepository.existsByChannelRequestId(channelRequestId);
    }
}
