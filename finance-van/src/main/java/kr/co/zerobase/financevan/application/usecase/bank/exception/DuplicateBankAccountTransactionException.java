package kr.co.zerobase.financevan.application.usecase.bank.exception;

/**
 * @Author Heli
 */
public class DuplicateBankAccountTransactionException extends RuntimeException {
    private static final String MESSAGE_FORMAT = "이미 접수된 요청입니다. [channelRequestId=%s]";

    public DuplicateBankAccountTransactionException(String channelRequestId) {
        super(String.format(MESSAGE_FORMAT, channelRequestId));
    }
}
