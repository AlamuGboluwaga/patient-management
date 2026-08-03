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
        System.out.println("envfile:" + System.getProperty("user.dir") + "/.env");
        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
//        System.out.println("env:" + dotenv.get("SPRING_DATASOURCE_URL"));
//        System.out.println("env:" + dotenv.get("SPRING_DATASOURCE_USERNAME"));
//        System.out.println("env:" + dotenv.get("SPRING_DATASOURCE_PASSWORD"));
//        System.out.println("env:" + dotenv.get("SPRING_SECURITY_USER_NAME"));
//        System.out.println("env:" + dotenv.get("SPRING_SECURITY_USER_PASSWORD"));

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
