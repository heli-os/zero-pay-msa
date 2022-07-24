package kr.co.zerobase.financevan.application.service.partner.definition;

import java.time.LocalDateTime;

/**
 * @Author Heli
 */
public class PartnerDefinition {

    private final long id;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;
    private final String name;

    public PartnerDefinition(long id, LocalDateTime createdAt, LocalDateTime modifiedAt, String name) {
        this.id = id;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "PartnerDefinition{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                ", name='" + name + '\'' +
                '}';
    }
}
