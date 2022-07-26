package kr.co.zerobase.financevan.configuration.init;

import kr.co.zerobase.financevan.domain.bank.BankAccount;
import kr.co.zerobase.financevan.domain.bank.BankCorp;
import kr.co.zerobase.financevan.domain.partner.Partner;
import kr.co.zerobase.financevan.domain.user.FintechUser;
import kr.co.zerobase.financevan.infrastructure.persistence.bank.BankAccountRepository;
import kr.co.zerobase.financevan.infrastructure.persistence.partner.PartnerRepository;
import kr.co.zerobase.financevan.infrastructure.persistence.user.FintechUserRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

/**
 * @Author Heli
 */
@Profile("test")
@Configuration
public class InitDataConfiguration {

    private final PartnerRepository partnerRepository;
    private final BankAccountRepository bankAccountRepository;
    private final FintechUserRepository fintechUserRepository;

    public InitDataConfiguration(PartnerRepository partnerRepository, BankAccountRepository bankAccountRepository, FintechUserRepository fintechUserRepository) {
        this.partnerRepository = partnerRepository;
        this.bankAccountRepository = bankAccountRepository;
        this.fintechUserRepository = fintechUserRepository;
    }

    private final Partner partner = Partner.create("Zero Pay");
    private final BankAccount shinhanBankAccount = BankAccount.create(BankCorp.SHINHAN, "Heli", LocalDate.of(1996, 8, 13));
    private final FintechUser fintechUser = FintechUser.issue(BankCorp.SHINHAN, "111-222-333", shinhanBankAccount.getName(), shinhanBankAccount.getBirthday(), "444-555");

    @PostConstruct
    @Transactional
    void init() {
        partnerRepository.save(partner);
        bankAccountRepository.save(shinhanBankAccount);
        fintechUserRepository.save(fintechUser);
    }
}
