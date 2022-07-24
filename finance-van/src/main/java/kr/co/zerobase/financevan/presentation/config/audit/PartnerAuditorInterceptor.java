package kr.co.zerobase.financevan.presentation.config.audit;

import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.AnnotatedElement;
import java.util.Optional;

/**
 * @Author Heli
 */
public class PartnerAuditorInterceptor implements HandlerInterceptor {

    private static final String PARTNER_ID_HEADER_NAME = "X-PARTNER-ID";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        assert handler instanceof HandlerMethod;

        PartnerAuditingApi partnerAuditingApi = AnnotatedElementUtils.findMergedAnnotation((AnnotatedElement) handler, PartnerAuditingApi.class);
        if (partnerAuditingApi != null) {
            resolveAuditor(request);
        }

        return true;
    }

    private void resolveAuditor(HttpServletRequest request) {
        String fintechUserNumValue = Optional.ofNullable(request.getHeader(PARTNER_ID_HEADER_NAME))
                .orElseThrow(() -> new NotProvidedPartnerIdHeaderException(PARTNER_ID_HEADER_NAME, request.getRequestURI()));

        PartnerAuditor partnerAuditor = new PartnerAuditor(Long.parseLong(fintechUserNumValue));
        PartnerAuditorHolder.set(partnerAuditor);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        PartnerAuditorHolder.clear();
    }
}
