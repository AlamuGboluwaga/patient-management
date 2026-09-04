package com.elroi.patientservice;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class PatientServiceApplication {


    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
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

        log.info("Patient Service Application started on port 8080:");
        SpringApplication.run(PatientServiceApplication.class, args);
        
    }

}

//        System.out.println("envFile:" + System.getProperty("user.dir") + "/.env");
//        System.out.println("env:" + dotenv.get("SPRING_DATASOURCE_URL"));
//        System.out.println("env:" + dotenv.get("SPRING_DATASOURCE_USERNAME"));
//        System.out.println("env:" + dotenv.get("SPRING_DATASOURCE_PASSWORD"));
//        System.out.println("env:" + dotenv.get("SPRING_SECURITY_USER_NAME"));
//        System.out.println("env:" + dotenv.get("SPRING_SECURITY_USER_PASSWORD"));