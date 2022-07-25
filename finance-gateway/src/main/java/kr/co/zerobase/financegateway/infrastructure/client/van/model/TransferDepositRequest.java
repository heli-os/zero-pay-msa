package kr.co.zerobase.financegateway.infrastructure.client.van.model;

import kr.co.zerobase.financegateway.domain.bank.BankCorp;

/**
 * @Author Heli
 */
public class TransferDepositRequest {

    private final String fintechUserNum;
    private final BankCorp bank;
    private final String bankAccountId;
    private final long amount;
    private final String receivedAccountId;
    private final String receivedAccountDescription;
    private final String channelRequestId;

    public TransferDepositRequest(String fintechUserNum, BankCorp bank, String bankAccountId, long amount, String receivedAccountId, String receivedAccountDescription, String channelRequestId) {
        this.fintechUserNum = fintechUserNum;
        this.bank = bank;
        this.bankAccountId = bankAccountId;
        this.amount = amount;
        this.receivedAccountId = receivedAccountId;
        this.receivedAccountDescription = receivedAccountDescription;
        this.channelRequestId = channelRequestId;
    }

    public String getFintechUserNum() {
        return fintechUserNum;
    }

    public BankCorp getBank() {
        return bank;
    }

    public String getBankAccountId() {
        return bankAccountId;
    }

    public long getAmount() {
        return amount;
    }

    public String getReceivedAccountId() {
        return receivedAccountId;
    }

    public String getReceivedAccountDescription() {
        return receivedAccountDescription;
    }

    public String getChannelRequestId() {
        return channelRequestId;
    }

    @Override
    public String toString() {
        return "TransferDepositRequest{" +
                "fintechUserNum='" + fintechUserNum + '\'' +
                ", bank=" + bank +
                ", bankAccountId='" + bankAccountId + '\'' +
                ", amount=" + amount +
                ", receivedAccountId='" + receivedAccountId + '\'' +
                ", receivedAccountDescription='" + receivedAccountDescription + '\'' +
                ", channelRequestId='" + channelRequestId + '\'' +
                '}';
    }
}
