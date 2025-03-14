package com.megacitycab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication  // This annotation marks it as a Spring Boot application
public class MegaCityCabApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MegaCityCabApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MegaCityCabApplication.class);
    }
}
