package com.elroi.patientservice;

import io.github.cdimascio.dotenv.Dotenv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PatientServiceApplication {

    private static final Logger log = LoggerFactory.getLogger(PatientServiceApplication.class);

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

        // Map SPRING_DATASOURCE_* env vars to Spring Boot datasource properties.
        // This ensures .env can override application.properties without key
        // conflicts and prevents embedded credentials in the URL from
        // hijacking the datasource username/password.
        dotenv.entries().forEach(entry -> {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key.startsWith("SPRING_DATASOURCE_")) {
                key =
                        "spring.datasource." +
                                key.substring("SPRING_DATASOURCE_".length()).toLowerCase();
            }
            System.setProperty(key, value);
        });

        log.info("Patient Service Application started successfully on Port 8080.");
        SpringApplication.run(PatientServiceApplication.class, args);

    }

}
