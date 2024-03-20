package com.haztrak.trak;

import com.haztrak.trak.org.Org;
import com.haztrak.trak.org.OrgRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class TrakApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrakApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(OrgRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                var org = new Org(1, "My Org");
                repository.save(org);
            }
        };
    }

}
