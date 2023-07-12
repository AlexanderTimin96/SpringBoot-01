package ru.netology.springboothomework1.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.springboothomework1.profile.DevProfile;
import ru.netology.springboothomework1.profile.ProductionProfile;
import ru.netology.springboothomework1.profile.SystemProfile;

@Configuration
public class JavaConfig {

    @Bean
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    public SystemProfile productProfile() {
        return new ProductionProfile();
    }
}
