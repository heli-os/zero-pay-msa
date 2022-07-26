package kr.co.zerobase.financegateway.infrastructure.client.van;

import feign.RequestInterceptor;
import org.springframework.cloud.openfeign.FeignFormatterRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;

/**
 * @Author Heli
 */
@Configuration
public class VanClientConfiguration {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return restTemplate -> restTemplate.header("X-PARTNER-ID", "444-555");
    }

    @Bean
    public FeignFormatterRegistrar localDateFeignFormatterRegister() {
        return registry -> {
            DateTimeFormatterRegistrar registrar = new DateTimeFormatterRegistrar();
            registrar.setUseIsoFormat(true);
            registrar.registerFormatters(registry);
        };
    }
}
