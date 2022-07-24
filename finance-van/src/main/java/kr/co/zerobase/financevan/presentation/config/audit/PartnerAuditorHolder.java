package kr.co.zerobase.financevan.presentation.config.audit;

/**
 * @Author Heli
 */
public class PartnerAuditorHolder {

    private static final ThreadLocal<PartnerAuditor> HOLDER = new ThreadLocal<>();

    public static PartnerAuditor get() {
        return HOLDER.get();
    }

    public static void set(PartnerAuditor auditor) {
        HOLDER.set(auditor);
    }

    public static void clear() {
        HOLDER.remove();
    }
}
