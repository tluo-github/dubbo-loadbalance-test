// src/main/java/com/example/dubbo/provider/ProviderApplication20881.java
package com.example.dubbo.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.apache.dubbo.extensions.ema.config.EmaAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = {
        "com.example.dubbo.provider",
        "com.example.dubbo.common"
})
@EnableDubbo(scanBasePackages = "com.example.dubbo.provider")
@Import(EmaAutoConfiguration.class)
public class ProviderApplication20881 {
    public static void main(String[] args) {
        System.setProperty("spring.config.name", "application-provider-20881");
        SpringApplication.run(ProviderApplication20881.class, args);
    }
}