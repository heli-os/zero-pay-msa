package kr.co.zerobase.financevan.domain.partner;

import kr.co.zerobase.financevan.configuration.jpa.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Author Heli
 */
@Entity
@Table(name = "partner")
public class Partner extends BaseEntity {

    @Column(name = "name")
    private String name;

    public static Partner createPartner(String name) {
        Partner entity = new Partner();
        entity.name = name;
        return entity;
    }

    public String getName() {
        return name;
    }

    protected Partner() {
    }
}
