package com.elroi.patientservice;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PatientServiceApplication {

    public static void main(String[] args) {

        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

//        dotenv.entries().forEach(entry -> {
//            String key = entry.getKey();
//            String value = entry.getValue();
//            if (key.startsWith("SPRING_DATASOURCE_")) {
//                key =
//                        "spring.datasource." +
//                                key.substring("SPRING_DATASOURCE_".length()).toLowerCase();
//            }
//            System.setProperty(key, value);
//        });
        SpringApplication.run(PatientServiceApplication.class, args);
    }

}
