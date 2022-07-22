package kr.co.zerobase.financevan.application.service.user;

import kr.co.zerobase.financevan.application.service.user.definition.FintechUserDefinition;
import kr.co.zerobase.financevan.application.service.user.exception.AlreadyRegisterUserException;
import kr.co.zerobase.financevan.domain.bank.BankCorp;
import kr.co.zerobase.financevan.infrastructure.persistence.user.FintechUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * @Author Heli
 */
@ExtendWith(MockitoExtension.class)
class FintechUserIssuerTest {

    private FintechUserIssuer fintechUserIssuer;

    @Mock
    FintechUserRepository fintechUserRepository;

    @BeforeEach
    void init() {
        fintechUserIssuer = new FintechUserIssuer(fintechUserRepository);
    }

    @Test
    @DisplayName("이미 등록된 계좌인 경우 Exception 발생")
    void issue_exception_case_1() {
        when(fintechUserRepository.existsFintechUserByBankAndBankAccountId(any(), any())).thenReturn(true);

        assertThrows(AlreadyRegisterUserException.class, () -> {
            fintechUserIssuer.issue(BankCorp.SHINHAN, "111-2222-3333", "HELLO", LocalDate.of(1996, 8, 13));
        });
    }

    @Test
    @DisplayName("등록되어 있지 않은 계좌인 경우 FintechUserNum 발행")
    void issue_correct_case_1() {
        when(fintechUserRepository.existsFintechUserByBankAndBankAccountId(any(), any())).thenReturn(false);

        FintechUserDefinition definition = fintechUserIssuer.issue(BankCorp.SHINHAN, "111-2222-3333", "HELLO", LocalDate.of(1996, 8, 13));
        assertThat(definition.getFintechUserNum()).isNotNull();
        assertThat(definition.getBank()).isEqualTo(BankCorp.SHINHAN);
        assertThat(definition.getBirthday()).isEqualTo(LocalDate.of(1996, 8, 13));
        assertThat(definition.getBankAccountId()).isEqualTo("111-2222-3333");
    }
}
