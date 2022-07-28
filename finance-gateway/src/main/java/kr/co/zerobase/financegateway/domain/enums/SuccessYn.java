package kr.co.zerobase.financegateway.domain.enums;

/**
 * @Author Heli
 */
public enum SuccessYn {
    Y, N;

    public boolean isSuccess() {
        return this == Y;
    }

    public boolean isFailure() {
        return this == N;
    }
}
