package kr.co.zerobase.financevan.application.service.user;

import kr.co.zerobase.financevan.application.mapper.FintechUserMapper;
import kr.co.zerobase.financevan.application.service.user.definition.FintechUserDefinition;
import kr.co.zerobase.financevan.application.service.user.exception.NotFoundFintechUserException;
import kr.co.zerobase.financevan.domain.user.FintechUser;
import kr.co.zerobase.financevan.infrastructure.persistence.user.FintechUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * @Author Heli
 */
@Service
@Transactional(readOnly = true)
public class FintechUserQuery {

    private final FintechUserRepository fintechUserRepository;

    public FintechUserQuery(FintechUserRepository fintechUserRepository) {
        this.fintechUserRepository = fintechUserRepository;
    }

    public FintechUserDefinition queryByFintechUserNum(String fintechUserNum) {
        FintechUser fintechUser = fintechUserRepository.findByFintechUserNum(fintechUserNum);
        if (Objects.isNull(fintechUser)) {
            throw new NotFoundFintechUserException(fintechUserNum);
        }

        return FintechUserMapper.toDefinition(fintechUser);
    }
}
