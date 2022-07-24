package kr.co.zerobase.financevan.application.service.partner;

import kr.co.zerobase.financevan.application.service.partner.exception.NotFoundPartnerException;
import kr.co.zerobase.financevan.domain.partner.Partner;
import kr.co.zerobase.financevan.infrastructure.persistence.partner.PartnerRepository;
import org.springframework.stereotype.Service;

/**
 * @Author Heli
 */
@Service
public class PartnerQuery {

    private final PartnerRepository partnerRepository;

    public PartnerQuery(PartnerRepository partnerRepository) {
        this.partnerRepository = partnerRepository;
    }

    public Partner queryById(long partnerId) {
        return partnerRepository.findById(partnerId)
                .orElseThrow(() -> new NotFoundPartnerException(partnerId));
    }
}
