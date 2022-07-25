package kr.co.zerobase.financegateway.configuration;

import kr.co.zerobase.financegateway.infrastructure.client.Client;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Heli
 */
@Configuration
@EnableFeignClients(basePackageClasses = Client.class)
public class FeignConfiguration {
}
