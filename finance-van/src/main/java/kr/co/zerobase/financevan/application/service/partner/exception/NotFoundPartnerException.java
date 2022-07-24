package kr.co.zerobase.financevan.application.service.partner.exception;

/**
 * @Author Heli
 */
public class NotFoundPartnerException extends RuntimeException {

    private static final String MESSAGE_FORMAT = "존재하지 않는 제휴사입니다. [id=%s]";

    public NotFoundPartnerException(long partnerId) {
        super(String.format(MESSAGE_FORMAT, partnerId));
    }
}
