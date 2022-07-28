package kr.co.zerobase.financegateway.domain.agg;

import kr.co.zerobase.financegateway.configuration.jpa.BaseEntity;
import kr.co.zerobase.financegateway.domain.bank.BankCorp;
import kr.co.zerobase.financegateway.domain.enums.BankingTask;
import kr.co.zerobase.financegateway.domain.enums.SuccessYn;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @Author Heli
 */
@Entity
@Table(name = "aggregation_account")
public class AggregationAccount extends BaseEntity {

    @Column(name = "user_id", nullable = false)
    private long userId;

    @Enumerated(EnumType.STRING)
    @Column(name = "task", nullable = false)
    private BankingTask task;

    @Enumerated(EnumType.STRING)
    @Column(name = "agg_bank", nullable = false)
    private BankCorp aggBank;

    @Column(name = "agg_account_id", nullable = false)
    private String aggAccountId;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_bank", nullable = false)
    private BankCorp transactionBank;

    @Column(name = "transaction_account_id", nullable = false)
    private String transactionAccountId;

    @Column(name = "req_dttm", nullable = false)
    private LocalDateTime reqDttm;

    @Column(name = "res_dttm")
    private LocalDateTime resDttm;

    @Column(name = "amount")
    private long amount;

    @Column(name = "channel_request_id")
    private String channelRequestId;

    @Enumerated(EnumType.STRING)
    @Column(name = "success")
    private SuccessYn success;
}
