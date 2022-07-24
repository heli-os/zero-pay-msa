package kr.co.zerobase.financevan.application.usecase.transaction;

import kr.co.zerobase.financevan.application.adapter.BankClientAdapter;
import kr.co.zerobase.financevan.application.service.partner.PartnerQuery;
import kr.co.zerobase.financevan.application.service.user.FintechUserQuery;
import kr.co.zerobase.financevan.application.usecase.bank.definition.BankAccountDefinition;
import kr.co.zerobase.financevan.application.usecase.bank.spec.BankAccountTransactionChannelSpec;
import kr.co.zerobase.financevan.application.usecase.transaction.spec.VanTransactionChannelSpec;
import kr.co.zerobase.financevan.domain.bank.BankCorp;
import kr.co.zerobase.financevan.domain.partner.Partner;
import kr.co.zerobase.financevan.domain.transaction.VanTransaction;
import kr.co.zerobase.financevan.domain.user.FintechUser;
import kr.co.zerobase.financevan.infrastructure.persistence.transaction.VanTransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author Heli
 */
@Service
public class DepositTransactionUseCase extends VanTransactionLogger<BankAccountDefinition> {

    private final BankClientAdapter bankClientAdapter;
    private final PartnerQuery partnerQuery;
    private final FintechUserQuery fintechUserQuery;

    public DepositTransactionUseCase(VanTransactionRepository vanTransactionRepository, BankClientAdapter bankClientAdapter, PartnerQuery partnerQuery, FintechUserQuery fintechUserQuery) {
        super(vanTransactionRepository);
        this.bankClientAdapter = bankClientAdapter;
        this.partnerQuery = partnerQuery;
        this.fintechUserQuery = fintechUserQuery;
    }

    @Transactional
    public void command(long partnerId, String fintechUserNum, BankCorp bank, String bankAccountId, long increaseAmount, String receivedAccountId, String receivedAccountDescription, VanTransactionChannelSpec spec) {
        Partner partner = partnerQuery.queryById(partnerId);
        FintechUser fintechUser = fintechUserQuery.queryByFintechUserNum(fintechUserNum);

        commandWithLog(
                () -> VanTransaction.deposit(partner, bank, fintechUser, receivedAccountId, receivedAccountDescription, increaseAmount, spec),
                () -> bankClientAdapter.deposit(bank, bankAccountId, increaseAmount, new BankAccountTransactionChannelSpec(spec.getChannelRequestId()))
        );
    }
}
