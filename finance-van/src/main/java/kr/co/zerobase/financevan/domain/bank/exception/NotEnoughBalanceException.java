package kr.co.zerobase.financevan.domain.bank.exception;

import kr.co.zerobase.financevan.domain.bank.BankCorp;

/**
 * @Author Heli
 */
public class NotEnoughBalanceException extends RuntimeException {

    private static final String MESSAGE_FORMAT = "계좌 잔액 부족. [bank=%s, bankAccountId=%s, currentBalance=%s, txBalance=%s]";

    public NotEnoughBalanceException(BankCorp bank, String bankAccountId, long currentBalance, long txBalance) {
        super(String.format(MESSAGE_FORMAT, bank.name(), bankAccountId, currentBalance, txBalance));
    }
}
