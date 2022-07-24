package kr.co.zerobase.financevan.application.usecase.transaction;

import kr.co.zerobase.financevan.application.adapter.BankClientAdapter;
import kr.co.zerobase.financevan.application.service.partner.PartnerQuery;
import kr.co.zerobase.financevan.application.service.user.FintechUserQuery;
import kr.co.zerobase.financevan.application.usecase.bank.definition.BankAccountBalance;
import kr.co.zerobase.financevan.application.usecase.bank.spec.BankAccountTransactionChannelSpec;
import kr.co.zerobase.financevan.application.usecase.transaction.spec.VanTransactionChannelSpec;
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
public class InquiryBalanceTransactionUseCase extends VanTransactionLogger<BankAccountBalance> {

    private final BankClientAdapter bankClientAdapter;
    private final PartnerQuery partnerQuery;
    private final FintechUserQuery fintechUserQuery;

    public InquiryBalanceTransactionUseCase(VanTransactionRepository vanTransactionRepository, BankClientAdapter bankClientAdapter, PartnerQuery partnerQuery, FintechUserQuery fintechUserQuery) {
        super(vanTransactionRepository);
        this.bankClientAdapter = bankClientAdapter;
        this.partnerQuery = partnerQuery;
        this.fintechUserQuery = fintechUserQuery;
    }

    @Transactional
    public BankAccountBalance command(long partnerId, String fintechUserNum, String channelRequestId) {
        Partner partner = partnerQuery.queryById(partnerId);
        FintechUser fintechUser = fintechUserQuery.queryByFintechUserNum(fintechUserNum);

        return commandWithLog(
                () -> VanTransaction.balance(partner, fintechUser, new VanTransactionChannelSpec(channelRequestId)),
                () -> bankClientAdapter.balance(fintechUser.getBank(), fintechUser.getBankAccountId(), new BankAccountTransactionChannelSpec(channelRequestId))
        );
    }
}
