package kr.co.zerobase.financevan.application.mapper;

import kr.co.zerobase.financevan.application.service.partner.definition.PartnerDefinition;
import kr.co.zerobase.financevan.domain.partner.Partner;

/**
 * @Author Heli
 */
public class PartnerMapper {

    public static PartnerDefinition toDefinition(Partner partner) {
        return new PartnerDefinition(partner.getId(), partner.getCreatedAt(), partner.getModifiedAt(), partner.getName());
    }
}
