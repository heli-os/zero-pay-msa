package kr.co.zerobase.financevan.domain.enums;

/**
 * @Author Heli
 */
public enum SuccessYn {
    Y, N;

    public Boolean isSuccess() {
        return this == Y;
    }

    public Boolean isFail() {
        return this == N;
    }
}
