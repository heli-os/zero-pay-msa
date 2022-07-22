package kr.co.zerobase.financevan.application.service.user.exception;

/**
 * @Author Heli
 */
public class NotFindFintechUserException extends RuntimeException {

    private static final String MESSAGE_FORMAT = "등록되지 않은 핀테크 이용 번호입니다. [fintechUserNum=%s]";

    public NotFindFintechUserException(String fintechUserNum) {
        super(String.format(MESSAGE_FORMAT, fintechUserNum));
    }
}
