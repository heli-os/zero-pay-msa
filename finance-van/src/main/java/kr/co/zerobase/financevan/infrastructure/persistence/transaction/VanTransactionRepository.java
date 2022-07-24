package kr.co.zerobase.financevan.infrastructure.persistence.transaction;

import kr.co.zerobase.financevan.domain.transaction.VanTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author Heli
 */
public interface VanTransactionRepository extends JpaRepository<VanTransaction, Long>, VanTransactionRepositoryCustom {

    boolean existsByChannelRequestId(String channelRequestId);
}
