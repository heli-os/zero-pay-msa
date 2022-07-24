package kr.co.zerobase.financevan.application.usecase.user.exception;

/**
 * @Author Heli
 */
public class NotFoundFintechUserException extends RuntimeException {

    private static final String MESSAGE_FORMAT = "등록되지 않은 핀테크 이용 번호입니다. [fintechUserNum=%s]";

    public NotFoundFintechUserException(String fintechUserNum) {
        super(String.format(MESSAGE_FORMAT, fintechUserNum));
    }
}
