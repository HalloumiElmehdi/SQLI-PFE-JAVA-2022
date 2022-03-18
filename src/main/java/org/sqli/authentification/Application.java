package org.sqli.authentification;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.sqli.authentification.entitie.User;
import org.sqli.authentification.repository.UserRepository;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner run() {
        return args -> {
            System.out.println("RUN :)");
        };
    }
}
