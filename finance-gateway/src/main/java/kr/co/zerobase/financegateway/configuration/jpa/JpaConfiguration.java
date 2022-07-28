package kr.co.zerobase.financegateway.configuration.jpa;

import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.zerobase.financegateway.domain.Persistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @Author Heli
 */
@Configuration
@EnableJpaAuditing
@EnableJpaRepositories(basePackageClasses = Persistence.class)
public class JpaConfiguration {

    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public JPAQueryFactory jpaQueryFactory() {
        return new JPAQueryFactory(entityManager);
    }
}
