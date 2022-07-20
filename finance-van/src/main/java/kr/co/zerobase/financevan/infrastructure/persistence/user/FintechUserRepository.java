package kr.co.zerobase.financevan.infrastructure.persistence.user;

import kr.co.zerobase.financevan.domain.user.FintechUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author Heli
 */
public interface FintechUserRepository extends JpaRepository<FintechUser, Long>, FintechUserRepositoryCustom {
}
