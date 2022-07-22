package kr.co.zerobase.financevan.application.service.bank.exception;

import kr.co.zerobase.financevan.domain.bank.BankCorp;

/**
 * @Author Heli
 */
public class NotFoundAccountException extends RuntimeException {

    private static final String MESSAGE_FORMAT = "존재하지 않는 은행 계좌입니다. [bank=%s, accountId=%s]";

    public NotFoundAccountException(BankCorp bank, String accountId) {
        super(String.format(MESSAGE_FORMAT, bank, accountId));
    }
}
