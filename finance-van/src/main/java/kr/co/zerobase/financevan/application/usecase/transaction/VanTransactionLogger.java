package kr.co.zerobase.financevan.application.usecase.transaction;

import kr.co.zerobase.financevan.application.usecase.transaction.exception.DuplicateVanTransactionException;
import kr.co.zerobase.financevan.domain.transaction.VanTransaction;
import kr.co.zerobase.financevan.infrastructure.persistence.transaction.VanTransactionRepository;

import java.util.function.Supplier;

/**
 * @Author Heli
 */
public class VanTransactionLogger<T> {

    private final VanTransactionRepository vanTransactionRepository;

    public VanTransactionLogger(VanTransactionRepository vanTransactionRepository) {
        this.vanTransactionRepository = vanTransactionRepository;
    }

    protected T commandWithLog(Supplier<VanTransaction> txSupplier, Supplier<T> entitySupplier) {
        VanTransaction tx = txSupplier.get();
        if (vanTransactionRepository.existsByChannelRequestId(tx.getChannelRequestId())) {
            throw new DuplicateVanTransactionException(tx.getChannelRequestId());
        }
        vanTransactionRepository.save(tx);
        return entitySupplier.get();
    }
}
