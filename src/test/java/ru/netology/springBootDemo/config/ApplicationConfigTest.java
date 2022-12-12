package ru.netology.springBootDemo.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import ru.netology.springbootdemo.config.ApplicationConfig;
import ru.netology.springbootdemo.service.SystemProfile;
import ru.netology.springbootdemo.service.impl.DevProfile;
import ru.netology.springbootdemo.service.impl.ProductionProfile;

class ApplicationConfigTest {
    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner();

    @Test
    void devProfile_set_true_success() {
        contextRunner.withPropertyValues("netology.profile.dev=true")
                .withUserConfiguration(ApplicationConfig.class)
                .run(context -> {
                    final var actualProfile = context.getBean(SystemProfile.class);
                    Assertions.assertInstanceOf(DevProfile.class, actualProfile);
                });
    }

    @Test
    void prodProfile_default_success() {
        contextRunner
                .withUserConfiguration(ApplicationConfig.class)
                .run(context -> {
                    final var actualProfile = context.getBean(SystemProfile.class);
                    Assertions.assertInstanceOf(ProductionProfile.class, actualProfile);
                });
    }
}