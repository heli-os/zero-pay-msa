package kr.co.zerobase.financevan.application.service.mock;

import kr.co.zerobase.financevan.domain.bank.BankCorp;
import kr.co.zerobase.financevan.domain.user.FintechUser;

import java.time.LocalDate;

/**
 * @Author Heli
 */
public class MockEntities {

    public static final FintechUser SHINHAN_FINTECH_USER = FintechUser.issue(BankCorp.SHINHAN, "111-222-333", "Heli", LocalDate.of(1996, 8, 13));
}
