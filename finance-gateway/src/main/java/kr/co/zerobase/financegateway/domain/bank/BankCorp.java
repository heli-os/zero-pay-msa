package kr.co.zerobase.financegateway.domain.bank;

/**
 * @Author Heli
 */
public enum BankCorp {
    // 4대 시중은행만 정의
    KB("KB국민은행", "004"),
    SHINHAN("신한은행", "088"),
    HANA("하나은행", "081"),
    WOORI("우리은행", "020");

    final String displayName;
    final String code;

    BankCorp(String displayName, String code) {
        this.displayName = displayName;
        this.code = code;
    }
}
