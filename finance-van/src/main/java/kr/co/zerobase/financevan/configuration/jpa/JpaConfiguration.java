package kr.co.zerobase.financevan.configuration.jpa;

import kr.co.zerobase.financevan.infrastructure.persistence.Persistence;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @Author Heli
 */
@Configuration
@EnableJpaAuditing
@EnableJpaRepositories(basePackageClasses = Persistence.class)
public class JpaConfiguration {
}
