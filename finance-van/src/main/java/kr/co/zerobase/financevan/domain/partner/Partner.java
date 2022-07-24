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

    public static Partner create(String name) {
        return new Partner(name);
    }

    private Partner(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    protected Partner() {
    }
}
