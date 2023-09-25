package com.lcp.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.lcp.app.entity.Study;
import com.lcp.app.repository.StudyRepository;

@SpringBootApplication
public class AppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(StudyRepository repository) {
        return (args) -> {
            // fetch all studies
            System.out.println("Studies found with findAll():");
            System.out.println("-------------------------------");
            for (Study study : repository.findAll()) {
                System.out.println(study.toString());
            }
        };
    }
}
