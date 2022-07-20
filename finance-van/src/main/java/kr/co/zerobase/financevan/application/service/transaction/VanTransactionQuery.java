package kr.co.zerobase.financevan.application.service.transaction;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author Heli
 */
@Service
@Transactional(readOnly = true)
public class VanTransactionQuery {
}
