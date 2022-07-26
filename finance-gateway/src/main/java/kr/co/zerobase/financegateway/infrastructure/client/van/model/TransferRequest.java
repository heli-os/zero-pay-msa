package kr.co.zerobase.financegateway.infrastructure.client.van.model;

import kr.co.zerobase.financegateway.domain.bank.BankCorp;

/**
 * @Author Heli
 */
public class TransferRequest {

    private final String fintechUserNum;
    private final String description;
    private final long amount;
    private final BankCorp transactionBank;
    private final String transactionAccountId;
    private final String transactionDescription;
    private final String channelRequestId;

    public TransferRequest(String fintechUserNum, String description, long amount, BankCorp transactionBank, String transactionAccountId, String transactionDescription, String channelRequestId) {
        this.fintechUserNum = fintechUserNum;
        this.description = description;
        this.amount = amount;
        this.transactionBank = transactionBank;
        this.transactionAccountId = transactionAccountId;
        this.transactionDescription = transactionDescription;
        this.channelRequestId = channelRequestId;
    }

    public String getFintechUserNum() {
        return fintechUserNum;
    }

    public String getDescription() {
        return description;
    }

    public long getAmount() {
        return amount;
    }

    public BankCorp getTransactionBank() {
        return transactionBank;
    }

    public String getTransactionAccountId() {
        return transactionAccountId;
    }

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public String getChannelRequestId() {
        return channelRequestId;
    }

    @Override
    public String toString() {
        return "TransferRequest{" +
                "fintechUserNum='" + fintechUserNum + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", transactionBank=" + transactionBank +
                ", transactionAccountId='" + transactionAccountId + '\'' +
                ", transactionDescription='" + transactionDescription + '\'' +
                ", channelRequestId='" + channelRequestId + '\'' +
                '}';
    }
}
