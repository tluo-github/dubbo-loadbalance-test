package com.example.dubbo.config;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 开启 Dubbo 注解扫描，并注册应用／注册中心
 */
@Configuration
@EnableDubbo(scanBasePackages = "com.example.dubbo")
@ComponentScan("com.example.dubbo.provider")
public class DubboConfiguration {

    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig app = new ApplicationConfig();
        app.setName("dubbo-loadbalance-test");
        return app;
    }

    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig reg = new RegistryConfig();
        reg.setAddress("zookeeper://127.0.0.1:2181");
        return reg;
    }
}