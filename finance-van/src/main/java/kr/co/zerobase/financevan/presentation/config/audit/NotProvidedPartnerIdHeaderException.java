package kr.co.zerobase.financevan.presentation.config.audit;

/**
 * @Author Heli
 */
public class NotProvidedPartnerIdHeaderException extends RuntimeException {

    private static final String MESSAGE_FORMAT = "%s is required [requestURI=%s]";

    public NotProvidedPartnerIdHeaderException(String headerName, String requestURI) {
        super(String.format(MESSAGE_FORMAT, headerName, requestURI));
    }

}
