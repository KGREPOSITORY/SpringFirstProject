package com.example.springfirstproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@EnableJpaRepositories
public class SpringFirstProjectApplication {
      public static void main(String[] args) {
        SpringApplication.run(SpringFirstProjectApplication.class, args);



    }

}
