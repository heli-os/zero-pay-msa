package kr.co.zerobase.financegateway.infrastructure.client.van.model;

/**
 * @Author Heli
 */
public class TransferResponse {

    private Object result;

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "TransferResponse{" +
                "result=" + result +
                '}';
    }
}
