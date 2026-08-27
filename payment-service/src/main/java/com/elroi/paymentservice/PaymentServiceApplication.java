package com.elroi.paymentservice;

import io.github.cdimascio.dotenv.Dotenv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaymentServiceApplication {

    private static final Logger log = LoggerFactory.getLogger(PaymentServiceApplication.class);

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
        dotenv.entries().forEach(entry -> {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key.startsWith("SPRING_DATASOURCE_")) {
                key = "spring.datasource." + key.substring("SPRING_DATASOURCE_".length()).toLowerCase();
            }
            System.setProperty(key, value);
        });

        log.info("Payment Service application started successfully.");
        SpringApplication.run(PaymentServiceApplication.class, args);
    }
}
