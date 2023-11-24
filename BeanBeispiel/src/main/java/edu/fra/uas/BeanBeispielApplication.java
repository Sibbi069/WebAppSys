package edu.fra.uas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BeanBeispielApplication {
    public double a;
    public double b;

    public static void main(String[] args) {
        SpringApplication.run(BeanBeispielApplication.class, args);
    }

    @Bean
    CommandLineRunner init() {
        CommandLineRunner action = new CommandLineRunner() {

            @Override
            public void run(String... args) {
                System.out.println("Hello World");
                a = 1.343434;
                b = Math.round(a*100.0)/100.0;
                System.out.println(b);
            }
        };
        return action;
    }

}
