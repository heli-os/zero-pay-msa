package kr.co.zerobase.financevan.application.usecase.bank.spec;

/**
 * @Author Heli
 */
public class BankAccountTransactionChannelSpec {

    private final String channelRequestId;

    public BankAccountTransactionChannelSpec(String channelRequestId) {
        this.channelRequestId = channelRequestId;
    }

    public String getChannelRequestId() {
        return channelRequestId;
    }
}
