package kr.co.zerobase.financevan.application.usecase.bank.exception;

import kr.co.zerobase.financevan.configuration.ExceptionParamConverter;

import java.util.Map;

/**
 * @Author Heli
 */
public class NotFoundBankAccountTransactionException extends RuntimeException {

    private static final String MESSAGE_FORMAT = "존재하지 않는 계좌 거래내역입니다. [%s]";

    public NotFoundBankAccountTransactionException(Map<String, Object> param) {
        super(String.format(MESSAGE_FORMAT, ExceptionParamConverter.convert(param)));
    }
}
