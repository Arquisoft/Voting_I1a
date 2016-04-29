package controller;

import dao.jpa.VoterRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = VoterRepository.class)
@EntityScan(basePackages = "model")
@ComponentScan({"dao.jpa", "controller"})
public class Application {

    public static void main(String[] args) {
    	SpringApplication.run(Application.class, args);
    }
}