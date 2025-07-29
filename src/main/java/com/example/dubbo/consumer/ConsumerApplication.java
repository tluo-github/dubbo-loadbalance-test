package com.example.dubbo.consumer;

import com.example.dubbo.common.HelloService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.apache.dubbo.extensions.ema.config.EmaArkConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(
        scanBasePackages = {
                "com.example.dubbo.consumer",
                "com.example.dubbo.common"
        }
)
@EnableDubbo(scanBasePackages = "com.example.dubbo.consumer")
@EnableConfigurationProperties(EmaArkConfig.class)
@PropertySource("classpath:application-consumer.properties")
public class ConsumerApplication implements CommandLineRunner {

    @DubboReference(version = "1.0.0", loadbalance = "ema")
    private HelloService helloService;

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @Override
    public void run(String... args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println(">>> Response: " + helloService.sayHello("World"));
        }
        Thread.sleep(10*60*1000);
        System.exit(0);
    }
}