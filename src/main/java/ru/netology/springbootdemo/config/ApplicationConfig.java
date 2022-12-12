package ru.netology.springbootdemo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.springbootdemo.service.SystemProfile;
import ru.netology.springbootdemo.service.impl.DevProfile;
import ru.netology.springbootdemo.service.impl.ProductionProfile;

@Configuration
public class ApplicationConfig {

    @Bean
    @ConditionalOnProperty(prefix = "netology.profile", name = "dev")
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    @ConditionalOnMissingBean
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }

}
