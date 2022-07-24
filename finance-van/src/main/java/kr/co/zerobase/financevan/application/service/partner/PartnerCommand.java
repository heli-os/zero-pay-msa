package kr.co.zerobase.financevan.application.service.partner;

import kr.co.zerobase.financevan.domain.partner.Partner;
import kr.co.zerobase.financevan.infrastructure.persistence.partner.PartnerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author Heli
 */
@Service
public class PartnerCommand {

    private final PartnerRepository partnerRepository;

    public PartnerCommand(PartnerRepository partnerRepository) {
        this.partnerRepository = partnerRepository;
    }

    @Transactional
    public Partner create(String name) {
        Partner partner = Partner.create(name);
        return partnerRepository.save(partner);
    }
}
