package by.Savelii.pp.compatibilityService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CompatibilityServiceConfig {
    @Bean
    RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
