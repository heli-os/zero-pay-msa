package kr.co.zerobase.financevan.configuration.jpa;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @Author Heli
 */
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(updatable = false)
    LocalDateTime createdAt;

    LocalDateTime modifiedAt;

    @PrePersist
    void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        createdAt = now;
        modifiedAt = now;
    }

    @PreUpdate
    void preUpdate() {
        modifiedAt = LocalDateTime.now();
    }
}
