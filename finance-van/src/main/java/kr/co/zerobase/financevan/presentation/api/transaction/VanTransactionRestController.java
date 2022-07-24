package kr.co.zerobase.financevan.presentation.api.transaction;

import kr.co.zerobase.financevan.application.usecase.bank.definition.BankAccountBalance;
import kr.co.zerobase.financevan.application.usecase.transaction.DepositTransactionUseCase;
import kr.co.zerobase.financevan.application.usecase.transaction.InquiryBalanceTransactionUseCase;
import kr.co.zerobase.financevan.application.usecase.transaction.WithdrawTransactionUseCase;
import kr.co.zerobase.financevan.application.usecase.transaction.spec.VanTransactionChannelSpec;
import kr.co.zerobase.financevan.presentation.api.transaction.model.AccountBalanceResponse;
import kr.co.zerobase.financevan.presentation.api.transaction.model.TransferDepositRequest;
import kr.co.zerobase.financevan.presentation.api.transaction.model.TransferResponse;
import kr.co.zerobase.financevan.presentation.api.transaction.model.TransferWithdrawRequest;
import kr.co.zerobase.financevan.presentation.config.audit.PartnerAuditingApi;
import kr.co.zerobase.financevan.presentation.config.audit.PartnerAuditor;
import kr.co.zerobase.financevan.presentation.config.audit.PartnerAuditorHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Heli
 */
@RestController
public class VanTransactionRestController {

    private final DepositTransactionUseCase depositTransactionUseCase;
    private final WithdrawTransactionUseCase withdrawTransactionUseCase;
    private final InquiryBalanceTransactionUseCase inquiryBalanceTransactionUseCase;

    public VanTransactionRestController(DepositTransactionUseCase depositTransactionUseCase, WithdrawTransactionUseCase withdrawTransactionUseCase, InquiryBalanceTransactionUseCase inquiryBalanceTransactionUseCase) {
        this.depositTransactionUseCase = depositTransactionUseCase;
        this.withdrawTransactionUseCase = withdrawTransactionUseCase;
        this.inquiryBalanceTransactionUseCase = inquiryBalanceTransactionUseCase;
    }

    @PartnerAuditingApi
    @PostMapping("/api/v1/transfer/deposit/fin_num")
    public ResponseEntity<TransferResponse> transferDepositFromFinNum(@RequestBody TransferDepositRequest request) {
        PartnerAuditor partnerAuditor = PartnerAuditorHolder.get();
        depositTransactionUseCase.command(
                partnerAuditor.getPartnerId(),
                request.getFintechUserNum(),
                request.getBank(),
                request.getBankAccountId(),
                request.getAmount(),
                request.getReceivedAccountId(),
                request.getReceivedAccountDescription(),
                new VanTransactionChannelSpec(request.getChannelRequestId())
        );
        return ResponseEntity.ok().body(TransferResponse.success());
    }

    @PartnerAuditingApi
    @PostMapping("/api/v1/transfer/withdraw/fin_num")
    public ResponseEntity<TransferResponse> transferWithdrawFromFinNum(@RequestBody TransferWithdrawRequest request) {
        PartnerAuditor partnerAuditor = PartnerAuditorHolder.get();
        withdrawTransactionUseCase.command(
                partnerAuditor.getPartnerId(),
                request.getFintechUserNum(),
                request.getBank(),
                request.getBankAccountId(),
                request.getAmount(),
                request.getReceivedAccountId(),
                request.getReceivedAccountDescription(),
                new VanTransactionChannelSpec(request.getChannelRequestId())
        );
        return ResponseEntity.ok().body(TransferResponse.success());
    }

    @PartnerAuditingApi
    @GetMapping("/api/v1/account/balance/fin_num")
    public ResponseEntity<AccountBalanceResponse> inquiryBalanceFromFinNum(
            @RequestParam String fintechUserNum,
            @RequestParam String channelRequestId
    ) {
        PartnerAuditor partnerAuditor = PartnerAuditorHolder.get();
        BankAccountBalance bankAccountBalance = inquiryBalanceTransactionUseCase.command(partnerAuditor.getPartnerId(), fintechUserNum, channelRequestId);
        return ResponseEntity.ok().body(new AccountBalanceResponse(bankAccountBalance.getBalance()));
    }
}
