package kr.co.zerobase.financevan.application.usecase.transaction.exception;

/**
 * @Author Heli
 */
public class DuplicateVanTransactionException extends RuntimeException {
    private static final String MESSAGE_FORMAT = "이미 접수된 요청입니다. [channelRequestId=%s]";

    public DuplicateVanTransactionException(String channelRequestId) {
        super(String.format(MESSAGE_FORMAT, channelRequestId));
    }
}
