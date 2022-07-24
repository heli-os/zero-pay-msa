package kr.co.zerobase.financevan.presentation.api.transaction.model;

/**
 * @Author Heli
 */
public class TransferResponse {

    private final Object result;

    private <T> TransferResponse(T result) {
        this.result = result;
    }

    public static TransferResponse success() {
        return new TransferResponse(true);
    }

    public Object getResult() {
        return result;
    }
}
