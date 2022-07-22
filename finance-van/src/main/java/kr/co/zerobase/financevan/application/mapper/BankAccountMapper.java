package kr.co.zerobase.financevan.application.mapper;

import kr.co.zerobase.financevan.application.service.user.definition.FintechUserDefinition;
import kr.co.zerobase.financevan.domain.user.FintechUser;

/**
 * @Author Heli
 */
public class BankAccountMapper {

    public static FintechUserDefinition toDefinition(FintechUser fintechUser) {
        return new FintechUserDefinition(fintechUser.getId(), fintechUser.getCreatedAt(), fintechUser.getModifiedAt(), fintechUser.getBank(), fintechUser.getBankAccountId(), fintechUser.getBirthday(), fintechUser.getFintechUserNum());
    }
}
