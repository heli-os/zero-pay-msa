package kr.co.zerobase.financevan.application.service.user;

import kr.co.zerobase.financevan.application.service.user.definition.FintechUserDefinition;
import kr.co.zerobase.financevan.application.service.user.exception.NotFindFintechUserException;
import kr.co.zerobase.financevan.infrastructure.persistence.user.FintechUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static kr.co.zerobase.financevan.application.service.mock.MockEntities.SHINHAN_FINTECH_USER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * @Author Heli
 */
@ExtendWith(MockitoExtension.class)
class FintechUserQueryTest {

    private static final String EXIST_FINTECH_USER_NUM = UUID.randomUUID().toString();
    private FintechUserQuery fintechUserQuery;

    @Mock
    FintechUserRepository fintechUserRepository;

    @BeforeEach
    void init() {
        fintechUserQuery = new FintechUserQuery(fintechUserRepository);
    }

    @Test
    @DisplayName("존재하는 핀테크 이용 번호인 경우 정상 조회")
    void query_correct_case_1() {
        when(fintechUserRepository.findByFintechUserNum(any())).thenReturn(SHINHAN_FINTECH_USER);

        FintechUserDefinition definition = fintechUserQuery.queryByFintechUserNum(SHINHAN_FINTECH_USER.getFintechUserNum());
        assertThat(definition.getFintechUserNum()).isEqualTo(SHINHAN_FINTECH_USER.getFintechUserNum());
    }

    @Test
    @DisplayName("존재하지 않은 핀테크 이용 번호인 경우 Exception 발생")
    void query_exception_case_1() {
        when(fintechUserRepository.findByFintechUserNum(any())).thenReturn(null);

        assertThrows(NotFindFintechUserException.class, () -> fintechUserQuery.queryByFintechUserNum(SHINHAN_FINTECH_USER.getFintechUserNum()));
    }
}
