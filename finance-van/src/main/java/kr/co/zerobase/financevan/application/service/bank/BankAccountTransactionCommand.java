package kr.co.zerobase.financevan.application.service.bank;

import kr.co.zerobase.financevan.application.usecase.bank.spec.BankAccountTransactionChannelSpec;
import kr.co.zerobase.financevan.domain.bank.BankAccount;
import kr.co.zerobase.financevan.domain.bank.BankAccountTransaction;
import kr.co.zerobase.financevan.infrastructure.persistence.bank.BankAccountTransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * @Author Heli
 */
@Service
@Transactional
public class BankAccountTransactionCommand {

    private final BankAccountTransactionRepository bankAccountTransactionRepository;

    private final BankAccountTransactionQuery bankAccountTransactionQuery;

    public BankAccountTransactionCommand(BankAccountTransactionRepository bankAccountTransactionRepository, BankAccountTransactionQuery bankAccountTransactionQuery) {
        this.bankAccountTransactionRepository = bankAccountTransactionRepository;
        this.bankAccountTransactionQuery = bankAccountTransactionQuery;
    }

    public BankAccountTransaction logCreate(BankAccount bankAccount, BankAccountTransactionChannelSpec spec) {
        BankAccountTransaction tx = BankAccountTransaction.create(bankAccount, spec);
        return bankAccountTransactionRepository.save(tx);
    }

    public BankAccountTransaction logDeposit(BankAccount bankAccount, long depositBalance, String printContent, BankAccountTransactionChannelSpec spec) {
        BankAccountTransaction tx = BankAccountTransaction.deposit(bankAccount, depositBalance, printContent, spec);
        return bankAccountTransactionRepository.save(tx);
    }

    public BankAccountTransaction logWithdraw(BankAccount bankAccount, long withdrawBalance, String printContent, BankAccountTransactionChannelSpec spec) {
        BankAccountTransaction tx = BankAccountTransaction.withdraw(bankAccount, withdrawBalance, printContent, spec);
        return bankAccountTransactionRepository.save(tx);

    }

    public BankAccountTransaction applyResDttm(long txId, LocalDateTime resDttm) {
        BankAccountTransaction tx = bankAccountTransactionQuery.queryById(txId);
        return tx.applyResDttm(resDttm);
    }
}
