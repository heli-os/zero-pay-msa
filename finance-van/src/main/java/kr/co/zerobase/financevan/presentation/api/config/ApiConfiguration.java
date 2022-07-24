package kr.co.zerobase.financevan.presentation.api.config;

import kr.co.zerobase.financevan.presentation.config.audit.PartnerAuditorInterceptor;
import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.format.DateTimeFormatter;

/**
 * @Author Heli
 */
@Configuration
public class ApiConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new PartnerAuditorInterceptor())
                .addPathPatterns("/api/**");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        DateTimeFormatterRegistrar dateTimeFormatterRegistrar = new DateTimeFormatterRegistrar();
        dateTimeFormatterRegistrar.setDateFormatter(DateTimeFormatter.ISO_LOCAL_DATE);
        dateTimeFormatterRegistrar.setDateTimeFormatter(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        dateTimeFormatterRegistrar.registerFormatters(registry);

        ApplicationConversionService.configure(registry);
    }
}
