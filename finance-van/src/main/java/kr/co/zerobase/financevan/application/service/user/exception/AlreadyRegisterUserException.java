package kr.co.zerobase.financevan.application.service.user.exception;

import kr.co.zerobase.financevan.domain.bank.BankCorp;

/**
 * @Author Heli
 */
public class AlreadyRegisterUserException extends RuntimeException {

    private static final String MESSAGE_FORMAT = "이미 등록된 계좌입니다. [bank=%s, bankAccountId=%s]";

    public AlreadyRegisterUserException(BankCorp bank, String bankAccountId) {
        super(String.format(MESSAGE_FORMAT, bank.name(), bankAccountId));
    }
}
