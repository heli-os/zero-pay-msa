package kr.co.zerobase.financevan.presentation.config.audit;

/**
 * @Author Heli
 */
public class PartnerAuditor {

    private final long partnerId;

    public PartnerAuditor(long partnerId) {
        this.partnerId = partnerId;
    }

    public long getPartnerId() {
        return partnerId;
    }

    @Override
    public String toString() {
        return "PartnerAuditor{" +
                "partnerId='" + partnerId + '\'' +
                '}';
    }
}
