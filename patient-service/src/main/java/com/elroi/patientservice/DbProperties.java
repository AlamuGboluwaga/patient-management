package com.elroi.patientservice;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties(prefix = "db-active")
@Getter
@Setter
public class DbProperties {

    private String ip;
    private String password;

}