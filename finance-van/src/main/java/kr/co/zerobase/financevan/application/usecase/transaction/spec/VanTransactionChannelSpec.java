package kr.co.zerobase.financevan.application.usecase.transaction.spec;

/**
 * @Author Heli
 */
public class VanTransactionChannelSpec {
    private final String channelRequestId;

    public VanTransactionChannelSpec(String channelRequestId) {
        this.channelRequestId = channelRequestId;
    }

    public String getChannelRequestId() {
        return channelRequestId;
    }
}
