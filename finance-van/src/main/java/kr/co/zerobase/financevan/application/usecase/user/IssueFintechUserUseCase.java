package kr.co.zerobase.financevan.application.usecase.user;

import kr.co.zerobase.financevan.application.mapper.FintechUserMapper;
import kr.co.zerobase.financevan.application.usecase.transaction.VanTransactionLogger;
import kr.co.zerobase.financevan.application.usecase.transaction.spec.VanTransactionChannelSpec;
import kr.co.zerobase.financevan.application.usecase.user.definition.FintechUserDefinition;
import kr.co.zerobase.financevan.application.usecase.user.exception.AlreadyRegisterUserException;
import kr.co.zerobase.financevan.domain.bank.BankCorp;
import kr.co.zerobase.financevan.domain.partner.Partner;
import kr.co.zerobase.financevan.domain.transaction.VanTransaction;
import kr.co.zerobase.financevan.domain.user.FintechUser;
import kr.co.zerobase.financevan.infrastructure.persistence.transaction.VanTransactionRepository;
import kr.co.zerobase.financevan.infrastructure.persistence.user.FintechUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

/**
 * @Author Heli
 */
@Service
public class IssueFintechUserUseCase extends VanTransactionLogger<FintechUser> {

    private final FintechUserRepository fintechUserRepository;

    public IssueFintechUserUseCase(FintechUserRepository fintechUserRepository, VanTransactionRepository vanTransactionRepository) {
        super(vanTransactionRepository);
        this.fintechUserRepository = fintechUserRepository;
    }

    @Transactional
    public FintechUserDefinition command(Partner partner, BankCorp bank, String bankAccountId, String name, LocalDate birthday, VanTransactionChannelSpec spec) {
        if (fintechUserRepository.existsByBankAndBankAccountId(bank, bankAccountId)) {
            throw new AlreadyRegisterUserException(bank, bankAccountId);
        }

        FintechUser fintechUser = FintechUser.issue(bank, bankAccountId, name, birthday);

        commandWithLog(
                () -> VanTransaction.register(partner, bank, fintechUser, spec),
                () -> fintechUserRepository.save(fintechUser)
        );
        return FintechUserMapper.toDefinition(fintechUser);
    }
}
