package kr.co.zerobase.financegateway.infrastructure.client.van;

import kr.co.zerobase.financegateway.infrastructure.client.van.model.AccountBalanceResponse;
import kr.co.zerobase.financegateway.infrastructure.client.van.model.TransferDepositRequest;
import kr.co.zerobase.financegateway.infrastructure.client.van.model.TransferResponse;
import kr.co.zerobase.financegateway.infrastructure.client.van.model.TransferWithdrawRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author Heli
 */
@FeignClient(value = "vanClient", url = "http://localhost:10001", configuration = VanClientConfiguration.class)
public interface VanClient {

    @PostMapping("/api/v1/transfer/deposit/fin_num")
    ResponseEntity<TransferResponse> transferDepositFromFinNum(
            @RequestBody TransferDepositRequest request
    );

    @PostMapping("/api/v1/transfer/withdraw/fin_num")
    ResponseEntity<TransferResponse> transferWithdrawFromFinNum(
            @RequestBody TransferWithdrawRequest request
    );

    @GetMapping("/api/v1/account/balance/fin_num")
    ResponseEntity<AccountBalanceResponse> inquiryBalanceFromFinNum(
            @RequestParam("fintechUserNum") String fintechUserNum,
            @RequestParam("channelRequestId") String channelRequestId
    );
}
