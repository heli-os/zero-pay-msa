package kr.co.zerobase.financevan.application.service.mock;

import kr.co.zerobase.financevan.application.usecase.user.definition.FintechUserDefinition;
import kr.co.zerobase.financevan.domain.bank.BankCorp;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Author Heli
 */
public class MockDefinition {

    private static final LocalDateTime NOW_DTTM = LocalDateTime.now();
    private static final LocalDate NOW_DT = LocalDate.now();

    public static final FintechUserDefinition SHINHAN_FINTECH_USER = new FintechUserDefinition(
            1L, NOW_DTTM, NOW_DTTM, BankCorp.SHINHAN, "bank_account_id_111", NOW_DT, "fintech_user_num_111"
    );
}
