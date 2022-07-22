package kr.co.zerobase.financevan.application.service.user;

import kr.co.zerobase.financevan.application.mapper.FintechUserMapper;
import kr.co.zerobase.financevan.application.service.user.definition.FintechUserDefinition;
import kr.co.zerobase.financevan.application.service.user.exception.AlreadyRegisterUserException;
import kr.co.zerobase.financevan.domain.bank.BankCorp;
import kr.co.zerobase.financevan.domain.user.FintechUser;
import kr.co.zerobase.financevan.infrastructure.persistence.user.FintechUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

/**
 * @Author Heli
 */
@Service
public class FintechUserIssuer {

    private final FintechUserRepository fintechUserRepository;

    public FintechUserIssuer(FintechUserRepository fintechUserRepository) {
        this.fintechUserRepository = fintechUserRepository;
    }

    @Transactional
    public FintechUserDefinition issue(BankCorp bank, String bankAccountId, String name, LocalDate birthday) {
        boolean exist = fintechUserRepository.existsFintechUserByBankAndBankAccountId(bank, bankAccountId);
        if (exist) {
            throw new AlreadyRegisterUserException(bank, bankAccountId);
        }

        FintechUser fintechUser = FintechUser.issue(bank, bankAccountId, name, birthday);
        fintechUserRepository.save(fintechUser);

        return FintechUserMapper.toDefinition(fintechUser);
    }
}
