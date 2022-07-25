package kr.co.zerobase.financegateway.infrastructure.client.van.model;

/**
 * @Author Heli
 */
public class TransferResponse {

    private final Object result;

    public TransferResponse(Object result) {
        this.result = result;
    }

    public Object getResult() {
        return result;
    }
}
