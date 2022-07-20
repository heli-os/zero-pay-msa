package kr.co.zerobase.financevan.infrastructure.persistence.user;

import kr.co.zerobase.financevan.domain.user.FintechUser;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

/**
 * @Author Heli
 */
public class FintechUserRepositoryImpl extends QuerydslRepositorySupport implements FintechUserRepositoryCustom {
    public FintechUserRepositoryImpl() {
        super(FintechUser.class);
    }
}
